package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.newusers.BuildNewUserPage;
import org.example.hexlet.dto.newusers.NewUserPage;
import org.example.hexlet.dto.newusers.NewUsersPage;
import org.example.hexlet.model.NewUser;
import org.example.hexlet.repository.NewUserRepository;

import static io.javalin.rendering.template.TemplateUtil.model;

public class NewUsersController {
    public static void index(Context ctx) {
        var users = NewUserRepository.getEntities();
        var page = new NewUsersPage(users);
        ctx.render("newusers/index.jte", model("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = NewUserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new NewUserPage(user);
        ctx.render("newusers/show.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildNewUserPage();
        ctx.render("newusers/build.jte", model("page", page));
    }


    public static void create(Context ctx) {
        var firstName = ctx.formParam("firstName");
        var lastName = ctx.formParam("lastName");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");

        var user = new NewUser(firstName, lastName, email, password);
        NewUserRepository.save(user);
        ctx.redirect(NamedRoutes.usersPath());
    }

    public static void edit(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = NewUserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new NewUserPage(user);
        ctx.render("newusers/edit.jte", model("page", page));
    }


    public static void update(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();

        var firstName = ctx.formParam("firstName");
        var lastName = ctx.formParam("lastName");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");

        var user = NewUserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        NewUserRepository.save(user);
        ctx.redirect(NamedRoutes.usersPath());
    }

    public static void destroy(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        NewUserRepository.delete(id);
        ctx.redirect(NamedRoutes.usersPath());
    }
}
