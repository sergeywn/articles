package ru.volkov.articles.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.volkov.articles.models.Article;
import ru.volkov.articles.services.ArticleServices;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired private ArticleServices service;

    @GetMapping
    public List<Article> getArticles() {return service.getAll();}

    @PostMapping
    public void createArticle(@RequestBody Article article) {
        service.create(article);
    }

    @PostMapping("/{articleId}")
    public void updateArticle(@RequestBody Article article, @PathVariable long articleId) {
        service.update(articleId, article);
    }

    @PostMapping("/{articleId}/rating/up")
    public void upVote(@PathVariable long articleId) {
        service.upVote(articleId);
    }

    @PostMapping("/{articleId}/rating/down")
    public void downVote(@PathVariable long articleId) {
        service.downVote(articleId);
    }

    @GetMapping("/best")
    public List<Article> getBest(@RequestParam String category) {
        return service.getBestInCategory(category);
    }
}
