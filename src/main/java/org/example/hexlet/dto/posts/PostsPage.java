package org.example.hexlet.dto.posts;

import org.example.hexlet.dto.BasePage;
import org.example.hexlet.model.Post;

import java.util.List;

public class PostsPage extends BasePage {
    private List<Post> posts;
    private int currentPage;
    private int totalPages;

    public PostsPage(List<Post> posts, int currentPage, int totalPages) {
        this.posts = posts;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
    }

    public PostsPage(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }
}
