package org.example.hexlet.dto.posts;

import org.example.hexlet.model.Post;

public class PostPage {
    private Post post;

    public PostPage(Post post) {
        this.post = post;
    }

    public Post getPost() {
        return post;
    }
}
