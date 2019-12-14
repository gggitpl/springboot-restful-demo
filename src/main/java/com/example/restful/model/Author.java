package com.example.restful.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.restful.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * <p>
 * 作者
 * </p>
 *
 * @author gggitpl
 * @since 2019-12-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_author")
@ApiModel(value = "Author对象", description = "作者")
public class Author extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "作者名")
    @NotBlank(message = "{author.name.not_blank}")
    @Size(min = 1, max = 10, message = "{author.name.size}")
    private String name;

}
