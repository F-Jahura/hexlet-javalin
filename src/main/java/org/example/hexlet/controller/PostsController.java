package org.example.hexlet.controller;

import io.javalin.http.Context;
import org.example.hexlet.dto.posts.PostPage;
import org.example.hexlet.dto.posts.PostsPage;
import org.example.hexlet.model.Post;
import org.example.hexlet.repository.PostRepository;

import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class PostsController {
    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        Post post = PostRepository.find(id).orElse(null);

        if (post == null) {
            ctx.status(404).result("Page not found");
        } else {
            var page = new PostPage(post);
            ctx.render("posts/show.jte", model("page", page));
        }
    }

    public static void index(Context ctx) {
        int pageNumber = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        int pageSize = 5;

        List<Post> posts = PostRepository.findAll(pageNumber, pageSize);

        int totalPosts = PostRepository.getEntities().size();
        int totalPages = (int) Math.ceil((double) totalPosts / pageSize);

        var page = new PostsPage(posts, pageNumber, totalPages);

        // Отправляем данные в шаблон для отображения
        ctx.render("posts/index.jte", model("page", page));
    }
}