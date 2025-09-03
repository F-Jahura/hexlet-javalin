package org.example.hexlet;
import com.sun.source.tree.IfTree;
import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class HelloWorld {
    private static final List<Map<String, String>> COMPANIES = DataCompay.getCompanies();
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

        List<Map<String, String>> USERS = DataUsers.getUsers();


        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/welcome", ctx -> ctx.result("Welcome to Hexlet!")); // http://localhost:8080/welcome

        app.get("/phones", ctx -> ctx.json(phones));       //    http://localhost:8080/phones
        app.get("/domains", ctx -> ctx.json(domains));     //    http://localhost:8080/domains


        app.get("/hello", ctx -> {
            String name = ctx.queryParam("name");
            if (name == null) {
                name = "World";
            }
            ctx.result("Hello, " + name + "!");
        });   //    http://localhost:8080/hello?name=Jhon

        app.get("/users", ctx -> {
            int page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
            int per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);
            int start = (page - 1) * per;
            int end = Math.min(start + per, USERS.size());

            if (start >= USERS.size()) {
                ctx.json(Collections.emptyList());
            } else {
                ctx.json(USERS.subList(start, end));
            }
        });

        //////////////////////////////////////////////////////
        app.get("/companies/{id}", ctx -> {             //    http://localhost:8080/companies/6
            var id = ctx.pathParam("id");
            var company = COMPANIES.stream()
                    .filter(i -> i.get("id").equals(id)).findFirst();

            if (company.isPresent()) {
                ctx.json(company.get());
            } else {
                throw new NotFoundResponse("Company not found");
            }
        });

        app.get("/companies", ctx -> {       //    http://localhost:8080/companies
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {                      //      http://localhost:8080/
            ctx.result("open something like (you can change id): /companies/5");
        });


        /////////////////////////////////////////////////////////
        app.get("/courses/{courseId}/lessons/{id}", ctx -> {     //    http://localhost:8080/courses/5/lessons/1
            var courseId = ctx.pathParam("courseId");
            var lessonId =  ctx.pathParam("id");
            ctx.result("Course ID: " + courseId + " Lesson ID: " + lessonId);
        });


        return app;
    }
    public static void main(String[] args) {
        Javalin app1 = getApp1();
        app1.start("0.0.0.0", 7070);

        Javalin app = getApp();
        app.start("0.0.0.0", 8080);
    }
}