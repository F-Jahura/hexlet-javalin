package org.example.hexlet.controller;

import io.javalin.http.Context;
import org.eclipse.jetty.util.log.Log;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.newusers.BuildNewUserPage;
import org.example.hexlet.dto.newusers.NewUsersPage;
import org.example.hexlet.dto.posts.BuildPostPage;
import org.example.hexlet.dto.sessionuser.LoginPage;
import org.example.hexlet.dto.sessionuser.MainPage;
import org.example.hexlet.model.NewUser;
import org.example.hexlet.model.SessionUser;
import org.example.hexlet.repository.NewUserRepository;
import org.example.hexlet.repository.SessionUserRepository;
import org.example.hexlet.util.Security;

import static io.javalin.rendering.template.TemplateUtil.model;

public class SessionUserController {
    /*public static void index(Context ctx) {
        /*SessionUser currentUser = ctx.sessionAttribute("currentUser");
        Object name = null;
        if (currentUser != null) {
            name = (Object) currentUser.getName();
        }

        var page = new MainPage(name);

        ctx.render("sessionusers/index.jte", model("page", page));


        var users = SessionUserRepository.getEntities();
        var page = new MainPage(users);
        ctx.render("sessionusers/index.jte", model("page", page));
    }*/

    public static void index(Context ctx) {
        SessionUser currentUser = ctx.sessionAttribute("currentUser");
        Object name = null;

        if (currentUser != null) {
            name = currentUser.getName();
        }

        var page = new MainPage(name);
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        ctx.render("sessionusers/index.jte", model("page", page));
    }


    public static void build(Context ctx) {
        var name = ctx.formParam("name");
        var error = "Enter username and password";
        var page = new LoginPage(name, error);
        ctx.render("sessionusers/build.jte", model("page", page));
    }

    public static void create(Context ctx) throws Exception {
        var name = ctx.formParam("name");
        var password = ctx.formParam("password");
        var users = SessionUserRepository.getEntities();

        boolean authenticated = false;
        for (var user : users) {
            if (name.equals(user.getName()) && Security.encryptSession(password).equals(user.getPassword())) {
                authenticated = true;
                ctx.sessionAttribute("currentUser", name);
                break;
            }
        }
        if (authenticated) {   // Если имя и пароль совпадает (authenticated = true), то возвращаемся на главную стрницу
            ctx.redirect("/");
        } else {
            ctx.sessionAttribute("flash", "wrong username and password. Please try again");
            ctx.redirect(NamedRoutes.loginPath());
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");
    }
}
