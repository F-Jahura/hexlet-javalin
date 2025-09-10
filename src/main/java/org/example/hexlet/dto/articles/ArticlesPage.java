package org.example.hexlet.dto.articles;

import org.example.hexlet.model.Article;

import java.util.List;

public class ArticlesPage {
    private List<Article> articles;

    public ArticlesPage(List<Article> articles) {
        this.articles = articles;
    }

    public List<Article> getArticles() {
        return articles;
    }
}
