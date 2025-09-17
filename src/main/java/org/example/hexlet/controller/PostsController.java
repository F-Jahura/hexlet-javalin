package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.newusers.BuildNewUserPage;
import org.example.hexlet.dto.posts.BuildPostPage;
import org.example.hexlet.dto.posts.EditPostPage;
import org.example.hexlet.dto.posts.PostPage;
import org.example.hexlet.dto.posts.PostsPage;
import org.example.hexlet.model.NewUser;
import org.example.hexlet.model.Post;
import org.example.hexlet.repository.NewUserRepository;
import org.example.hexlet.repository.PostRepository;
import org.example.hexlet.util.Security;


import static io.javalin.rendering.template.TemplateUtil.model;

public class PostsController {
    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Post not found"));

        var page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }

    //This index for page back-next
    /*public static void index(Context ctx) {
        int pageNumber = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        int pageSize = 5;

        List<Post> posts = PostRepository.findAll(pageNumber, pageSize);

        int totalPosts = PostRepository.getEntities().size();
        int totalPages = (int) Math.ceil((double) totalPosts / pageSize);

        var page = new PostsPage(posts, pageNumber, totalPages);

        // Отправляем данные в шаблон для отображения
        ctx.render("posts/index.jte", model("page", page));
    }*/

    public static void index(Context ctx) {
        var posts = PostRepository.getEntities();
        var page = new PostsPage(posts);
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        ctx.render("posts/index.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildPostPage();
        ctx.render("posts/build.jte", model("page", page));
    }

    public static void create(Context ctx) throws Exception {
        var body = ctx.formParam("body");
        try {
            var name = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() >= 2, "Name should not be less than two symbols")
                    .get();

        var post = new Post(name, body);
        PostRepository.save(post);
        ctx.sessionAttribute("flash", "Post was successfully created!");

        ctx.redirect(NamedRoutes.postsPath());
        } catch (ValidationException e) {
            var name = ctx.formParam("name");
            var page = new BuildPostPage(name, body, e.getErrors());
            ctx.render("posts/build.jte", model("page", page)).status(422);
        }
    }

    /*public static void create(Context ctx) {
        try {
            var name = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() >= 2, "Название не должно быть короче двух символов")
                    .get();

            var body = ctx.formParamAsClass("body", String.class)
                    .check(value -> value.length() >= 10, "Пост должен быть не короче 10 символов")
                    .get();

            var post = new Post(name, body);
            PostRepository.save(post);
            ctx.sessionAttribute("flash", "Post was successfully created!");
            ctx.redirect(NamedRoutes.postsPath());

       } catch (ValidationException e) {
            var name = ctx.formParam("name");
            var body = ctx.formParam("body");
            var page = new BuildPostPage(name, body, e.getErrors());
            ctx.render("posts/build.jte", model("page", page)).status(422);
        }
    }*/

    public static void edit(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new EditPostPage(post.getId(), post.getName(), post.getBody(), null);
        ctx.render("posts/edit.jte", model("page", page));
    }

    public static void update(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        try {
            var name = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() >= 2, "Название не должно быть короче двух символов")
                    .get();

            var body = ctx.formParamAsClass("body", String.class)
                    .check(value -> value.length() >= 10, "Пост должен быть не короче 10 символов")
                    .get();

            var post = PostRepository.find(id)
                    .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
            post.setName(name);
            post.setBody(body);
            PostRepository.save(post);
            ctx.redirect(NamedRoutes.postsPath());

        } catch (ValidationException e) {
            // При возникновении ошибки остаемся на странице редактирования
            var page = new EditPostPage(id, ctx.formParam("name"), ctx.formParam("body"), e.getErrors());
            ctx.render("posts/edit.jte", model("page", page)).status(422);
        }
    }
}