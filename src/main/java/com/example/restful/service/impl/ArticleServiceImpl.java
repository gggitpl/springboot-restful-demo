package com.example.restful.service.impl;

import com.example.restful.model.Article;
import com.example.restful.mapper.ArticleMapper;
import com.example.restful.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章 服务实现类
 * </p>
 *
 * @author gggitpl
 * @since 2019-12-14
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}
