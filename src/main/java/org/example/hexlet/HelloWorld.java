package org.example.hexlet;
import io.javalin.Javalin;

import java.util.List;
public class HelloWorld {
    public static Javalin getApp1() {
        var app1 = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app1.get("/", ctx -> ctx.result("Hello World"));          //   http://localhost:7070
        app1.get("/users", ctx -> ctx.result("GET /users"));      //   http://localhost:7070/users
        app1.post("/users", ctx -> ctx.result("POST /users"));

        return app1;
    }

    public static Javalin getApp() {
        List<String> phones = Data.getPhones();
        List<String> domains = Data.getDomains();

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/welcome", ctx -> ctx.result("Welcome to Hexlet!")); // http://localhost:8080/welcome

        app.get("/phones", ctx -> ctx.json(phones));       //    http://localhost:8080/phones
        app.get("/domains", ctx -> ctx.json(domains));     //    http://localhost:8080/domains

        return app;
    }
    public static void main(String[] args) {
        Javalin app1 = getApp1();
        app1.start("0.0.0.0", 7070);

        Javalin app = getApp();
        app.start("0.0.0.0", 8080);
    }
}