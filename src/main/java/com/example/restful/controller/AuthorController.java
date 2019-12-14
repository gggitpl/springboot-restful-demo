package com.example.restful.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.restful.common.BaseController;
import com.example.restful.common.Pageable;
import com.example.restful.model.Author;
import com.example.restful.service.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.auth.AUTH;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * 作者 前端控制器
 * </p>
 *
 * @author gggitpl
 * @since 2019-12-14
 */
@Validated
@RestController
@RequestMapping("/authors")
@Api(value = "作者操作接口列表")
public class AuthorController extends BaseController {

    @Resource
    private AuthorService authorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "添加作者", response = Author.class)
    //@PreAuthorize("hasAuthority('add')")
    public Author create(@RequestBody @Valid Author author) {
        authorService.save(author);
        return author;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "根据ID删除作者")
    public void delete(@PathVariable Long id) {
        authorService.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "根据ID更新作者信息", response = Author.class)
    public Author update(@RequestBody @Valid Author author) {
        authorService.updateById(author);
        return author;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取作者信息", response = Author.class)
    public Author getById(@PathVariable Long id) {
        return authorService.getById(id);
    }

    @GetMapping
    @ApiOperation(value = "分页获取作者列表", response = Page.class)
    public Page<Author> list(Pageable<Author> pageable, Author author) {
        return authorService.page(pageable.getPage(), pageable.getWrapper(author));
    }

}
