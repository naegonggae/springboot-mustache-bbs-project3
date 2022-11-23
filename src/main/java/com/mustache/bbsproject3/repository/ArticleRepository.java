package com.mustache.bbsproject3.repository;

import com.mustache.bbsproject3.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
