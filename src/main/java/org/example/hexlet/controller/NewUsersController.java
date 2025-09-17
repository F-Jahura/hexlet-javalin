package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.newusers.BuildNewUserPage;
import org.example.hexlet.dto.newusers.NewUserPage;
import org.example.hexlet.dto.newusers.NewUsersPage;
import org.example.hexlet.model.NewUser;
import org.example.hexlet.repository.NewUserRepository;
import org.example.hexlet.util.Security;

import static io.javalin.rendering.template.TemplateUtil.model;

public class NewUsersController {
    public static void index(Context ctx) {
        var users = NewUserRepository.getEntities();
        var page = new NewUsersPage(users);   //this code has closed for flash examples

        page.setFlash(ctx.consumeSessionAttribute("flash"));
        ctx.render("newusers/index.jte", model("page", page));
    }

    /*public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = NewUserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new NewUserPage(user);
        ctx.render("newusers/show.jte", model("page", page));
    }*/

    public static void build(Context ctx) {
        var page = new BuildNewUserPage();
        ctx.render("newusers/build.jte", model("page", page));
    }


    /*public static void create(Context ctx) {
        var firstName = ctx.formParam("firstName");
        var lastName = ctx.formParam("lastName");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");

        var user = new NewUser(firstName, lastName, email, password);
        NewUserRepository.save(user);
        ctx.redirect(NamedRoutes.usersPath());
    }*/

    public static void create(Context ctx) throws Exception {
        // BEGIN (write your solution here)
        var firstName = ctx.formParam("firstName");
        var lastName = ctx.formParam("lastName");
        var email = ctx.formParam("email");
        var encriptedPassword = ctx.formParam("encriptedPassword");
        var token = Security.generateToken();
        ctx.cookie("token", token);

        var user = new NewUser(firstName, lastName, email, encriptedPassword, token);
        NewUserRepository.save(user);

        ////
        ctx.sessionAttribute("flash", "User has  been created!");
        ////

        ctx.redirect(NamedRoutes.usersPath());
        // END
    }

    public static void show(Context ctx) throws Exception {
        // BEGIN (write your solution here)
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var tokenFromCookie = ctx.cookie("token");
        var user = NewUserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new NewUserPage(user);
        if (tokenFromCookie.equals(user.getToken())) {
            ctx.render("newusers/show.jte", model("page", page));
        } else {
            ctx.redirect(NamedRoutes.buildUserPath());
        }
        // END
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
        user.setEncriptedPassword(password);
        NewUserRepository.save(user);
        ctx.redirect(NamedRoutes.usersPath());
    }

    public static void destroy(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        NewUserRepository.delete(id);
        ctx.redirect(NamedRoutes.usersPath());
    }
}
