package com.example.restful.constant;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gggitpl
 */
@Getter
@AllArgsConstructor
public enum Deleted {

    /**
     * 未删除
     */
    NOT_DELETED(0, "未删除"),
    /**
     * 已删除
     */
    DELETED(1, "已删除");

    @JsonValue
    @EnumValue
    private Integer key;
    private String label;

}
