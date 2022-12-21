package ru.volkov.articles.models;

import javax.persistence.*;

@Entity
@Table(name = "\"Articles\"")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "category", nullable = false, length = 20)
    private String category;

    @Column(name = "title", nullable = false, length = 20)
    private String title;

    @Column(name = "text", nullable = false, length = 40)
    private String text;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

}