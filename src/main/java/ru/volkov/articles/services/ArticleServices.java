package ru.volkov.articles.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import ru.volkov.articles.exceptions.ArticleNotFoundException;
import ru.volkov.articles.models.Article;
import ru.volkov.articles.repository.ArticleRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ArticleServices {

    @Autowired private ArticleRepository repository;

    public List<Article> getAll() {
        return repository.findAll();
    }

    public void create(Article article) {
        article.setId(new Random().nextLong());
        repository.save(article);
    }

    public void update(Long id, Article article) {
        article.setId(id);
        repository.save(article);
    }

    public void upVote (Long id) {
        Article article = repository.findById(id).orElseThrow(ArticleNotFoundException::new);
        article.setRating(article.getRating()+1);
        repository.save(article);
    }

    public void downVote (Long id) {
        Article article = repository.findById(id).orElseThrow(ArticleNotFoundException::new);
        article.setRating(article.getRating()-1);
        repository.save(article);
    }

    public List<Article> getBestInCategory (String category) {
        return repository.findAllByCategory(category)
                .stream()
                .filter(article -> article.getRating()>0)
                .sorted(Comparator.comparing(Article::getRating))
                .collect(Collectors.toList());
    }
}
