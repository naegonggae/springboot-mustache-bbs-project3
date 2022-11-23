package com.mustache.bbsproject3.controller;

import com.mustache.bbsproject3.domain.Article;
import com.mustache.bbsproject3.domain.ArticleDto;
import com.mustache.bbsproject3.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("")
    public String list(Model model) {
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "list";
    }


    @GetMapping("/new")
    public String createArticleForm() {
        return "new";
    }

    @GetMapping("/{id}")
    public String selectId(@PathVariable Long id, Model model) {
        Optional<Article> optArticle = articleRepository.findById(id);
        if (!optArticle.isEmpty()) {
            model.addAttribute("article", optArticle.get());
            return "show";
        } else {
            return "error";
        }
    }

    @PostMapping("")
    public String createArticle(ArticleDto articleDto) {
        Article savedArticle = articleRepository.save(articleDto.toEntity());
        return String.format("redirect:/articles/%d", savedArticle.getId());
    }
}
