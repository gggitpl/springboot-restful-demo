package com.example.restful.service.impl;

import com.example.restful.model.Author;
import com.example.restful.mapper.AuthorMapper;
import com.example.restful.service.AuthorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 作者 服务实现类
 * </p>
 *
 * @author gggitpl
 * @since 2019-12-14
 */
@Service
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper, Author> implements AuthorService {

}
