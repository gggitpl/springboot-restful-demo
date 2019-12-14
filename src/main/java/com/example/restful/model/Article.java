package com.example.restful.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.restful.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * <p>
 * 文章
 * </p>
 *
 * @author gggitpl
 * @since 2019-12-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_article")
@ApiModel(value = "Article对象", description = "文章")
public class Article extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文章标题")
    @NotBlank(message = "{article.title.not_blank}")
    @Size(min = 1, max = 15, message = "{article.title.size}")
    private String title;

    @ApiModelProperty(value = "文章子标题")
    @Size(max = 50, message = "{article.subtitle.size}")
    private String subtitle;

    @ApiModelProperty(value = "作者ID")
    @NotNull(message = "{article.author_id.not_null}")
    private Long authorId;

}
