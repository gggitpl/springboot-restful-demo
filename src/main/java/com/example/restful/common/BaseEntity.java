package com.example.restful.common;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.example.restful.constant.Deleted;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author gggitpl
 */
@Data
@Accessors(chain = true)
public class BaseEntity {

    @TableId
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private Long createTime = System.currentTimeMillis();

    @ApiModelProperty(value = "更新时间")
    private Long updateTime = System.currentTimeMillis();

    @TableLogic
    @ApiModelProperty(value = "是否删除")
    private Deleted deleted = Deleted.NOT_DELETED;
}
