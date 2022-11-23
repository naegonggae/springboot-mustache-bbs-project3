package com.mustache.bbsproject3.domain;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public class ArticleDto {
    private String title;
    private String content;

    public ArticleDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Article toEntity() {
        return new Article(this.title, this.content);
    }
}
