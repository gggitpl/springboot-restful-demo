package com.example.restful.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.restful.common.Pageable;
import com.example.restful.model.Article;
import com.example.restful.model.Author;
import com.example.restful.service.ArticleService;
import com.example.restful.service.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.restful.common.BaseController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * 文章 前端控制器
 * </p>
 *
 * @author gggitpl
 * @since 2019-12-14
 */
@Validated
@RestController
@RequestMapping("/articles")
@Api(value = "文章操作接口列表")
public class ArticleController extends BaseController {
    @Resource
    private ArticleService articleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "添加文章", response = Article.class)
    //@PreAuthorize("hasAuthority('add')")
    public Article create(@RequestBody @Valid Article article) {
        articleService.save(article);
        return article;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "根据ID删除文章")
    public void delete(@PathVariable Long id) {
        articleService.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "根据ID更新文章信息", response = Article.class)
    public Article update(@RequestBody @Valid Article article) {
        articleService.updateById(article);
        return article;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取文章信息", response = Article.class)
    public Article getById(@PathVariable Long id) {
        return articleService.getById(id);
    }

    @GetMapping
    @ApiOperation(value = "分页获取文章列表")
    public Page<Article> list(Pageable<Article> pageable, Article article) {
        return articleService.page(pageable.getPage(), pageable.getWrapper(article));
    }
}
