package com.example.restful.common;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author gggitpl
 */
@Data
public class Pageable<T> {

    private Long page = 1L;
    private Long pageSize = 15L;
    private String sort;

    public Page<T> getPage() {
        Page<T> var1 = new Page<>(page, pageSize);
        var1.setOrders(getOrderItems());
        return var1;
    }

    public Wrapper<T> getWrapper(T t) {
        QueryWrapper<T> query = Wrappers.query();
        for (Field field : t.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object fieldValue = field.get(t);
                String fieldName = field.getName();
                if (Objects.nonNull(fieldValue) && !"serialVersionUID".equals(fieldName)) {
                    if (field.getType() == String.class) {
                        String value = fieldValue.toString();
                        if (StringUtils.isNotBlank(value)) {
                            query.like(fieldName, fieldValue);
                        }
                    } else {
                        query.eq(fieldName, fieldValue);
                    }
                }
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
        return query;
    }

    private List<OrderItem> getOrderItems() {
        if (StringUtils.isNotEmpty(sort)) {
            ArrayList<OrderItem> orderItems = Lists.newArrayList();
            String[] items = sort.split(",");
            for (String item : items) {
                String[] var2 = item.split(":");
                String var3 = var2[0], var4 = var2[1];
                if (Sort.DESC.getValue().equals(var4)) {
                    orderItems.add(OrderItem.desc(var3));
                } else if (Sort.ASC.getValue().equals(var4)) {
                    orderItems.add(OrderItem.asc(var3));
                }
            }
            return orderItems;
        }
        return Collections.emptyList();
    }

    @AllArgsConstructor
    @Getter
    enum Sort {
        /**
         * 降序
         */
        DESC("desc"),
        /**
         * 升序
         */
        ASC("asc");
        private String value;

    }
}
