package org.example.hexlet;
import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import io.javalin.validation.ValidationException;
import org.example.hexlet.controller.NewUsersController;
import org.example.hexlet.controller.PostsController;
import org.example.hexlet.controller.RootController;
import org.example.hexlet.data.*;
import org.example.hexlet.dto.articles.ArticlesPage;
import org.example.hexlet.dto.articles.BuildArticlePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.*;
import org.apache.commons.text.StringEscapeUtils;
import org.example.hexlet.repository.ArticleRepository;

import javax.naming.Name;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {
    private static final List<Map<String, String>> COMPANIES = DataCompay.getCompanies();

    private static final List<User> USERS = DataUser.getUsers();
    public static Javalin getApp1() {
        var app1 = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app1.get("/", ctx -> ctx.result("Hello World"));          //   http://localhost:7070
        app1.get("/users_get", ctx -> ctx.result("GET /users"));      //   http://localhost:7070/users
        app1.post("/users_post", ctx -> ctx.result("POST /users"));

        return app1;
    }

    public static Javalin getApp() {
        List<String> phones = Data.getPhones();
        List<String> domains = Data.getDomains();

        List<Map<String, String>> USERS = Data1.getUsers();


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

        app.get("/text", ctx -> {                      //      http://localhost:8080/
            ctx.result("open something like (you can change id): /companies/5");
        });


        /////////////////////////////////////////////////////////
        app.get("/courses/{courseId}/lessons/{id}", ctx -> {     //    http://localhost:8080/courses/5/lessons/1
            var courseId = ctx.pathParam("courseId");
            var lessonId =  ctx.pathParam("id");
            ctx.result("Course ID: " + courseId + " Lesson ID: " + lessonId);
        });


        //////////////////////////////////////////jte
        app.get("/jte", ctx -> ctx.render("index.jte"));       //     http://localhost:8080/jte

        //////////////////////jte
        var app_jte = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        return app;
    }

    public static Javalin getAppCourse() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/courses/{id}", ctx -> {      // http://localhost:7070/courses/2
            var id = ctx.pathParam("id");
            var courseId = Long.parseLong(id);
            var course = DataCourse.getCourses().stream()
                    .filter(c -> c.getId() == courseId)
                    .findFirst()
                    .orElse(null);
            var page = new CoursePage(course);
            ctx.render("courses/show.jte", model("page", page));
        });

        /*app.get("/courses", ctx -> {             //   http://localhost:7070/courses
            var courses = DataCourse.getCourses();
            var header = "Курсы по программированию";
            var page = new CoursesPage(courses, header);
            ctx.render("courses/index.jte", model("page", page));
        });*/

        app.get("/courses", ctx -> {             //   http://localhost:7070/courses
            var term = ctx.queryParam("term");
            var header = "Курсы по программированию";
            List<Course> courses;
            if (term != null) {
                courses = DataCourse.getCourses().stream()
                        .filter(t -> t.getName().equals(term))
                        .collect(Collectors.toList());
            } else {
                courses = DataCourse.getCourses();
            }
            var page = new CoursesPage(courses, header, term);
            ctx.render("courses/index.jte", model("page", page));
        });

        return app;
    }

    public static Javalin getAppUser() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN (write your solution here)
        app.get(NamedRoutes.userPath("{id}"), ctx -> {               //   http://localhost:7070/users/14
            var id = ctx.pathParam("id");
            var escapedId = StringEscapeUtils.escapeHtml4(id);
            var userId = Long.parseLong(escapedId);
            var user = USERS.stream()
                    .filter(c -> c.getId() == userId)
                    .findFirst()
                    .orElseThrow(() -> new NotFoundResponse("User not found"));;
            var page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        });

        /*app.get("/users", ctx -> {                  // http://localhost:7070/users
            var header = "Курсы по программированию";
            var page = new UsersPage(USERS, header);
            ctx.render("users/index.jte", model("page", page));
        });*/


        app.get(NamedRoutes.usersPath(), ctx -> {
            var term = ctx.queryParam("term");
            List<User> users;
            if (term != null) {
                users = DataUser.getUsers().stream()
                        .filter(t -> t.getFirstName().toLowerCase().contains(term.toLowerCase()))
                        .collect(Collectors.toList());
            } else {
                users = USERS;
            }
            var page = new UsersPage(users, term);
            ctx.render("users/index.jte", model("page", page));
        });


        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static Javalin getAppNewUser() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        /*app.get(NamedRoutes.usersPath(), ctx -> {
            List<NewUser> users = NewUserRepository.getEntities();
            var page = new NewUsersPage(users);
            ctx.render("newusers/index.jte", model("page", page));
        });


        app.get(NamedRoutes.buildUserPath(), ctx -> {
            var page = new BuildNewUserPage();
            ctx.render("newusers/build.jte", model("page", page));
        });

        app.post(NamedRoutes.usersPath(), ctx -> {
            var firstName = ctx.formParam("firstName").trim();
            var lastName = ctx.formParam("lastName").trim();
            var email = ctx.formParam("email").trim().toLowerCase();
            String password;

            try {
                var passwordConfirmation = ctx.formParam("passwordConfirmation");
                password = ctx.formParamAsClass("password", String.class)
                        .check(value -> value.equals(passwordConfirmation), "Password does not match")
                        .check(value -> value.length() > 6, "Password shorter than 6")
                        .get();
                var user = new NewUser(firstName, lastName, email, password);
                NewUserRepository.save(user);
                ctx.redirect(NamedRoutes.usersPath());
            } catch (ValidationException e) {
                ctx.status(422);
                var page = new BuildNewUserPage(firstName, lastName, email, e.getErrors());
                ctx.render("newusers/build.jte", model("page", page));
            }
        });*/

        app.get(NamedRoutes.usersPath(), NewUsersController::index);
        app.get("/users/build", NewUsersController::build);
        app.get("/users/{id}", NewUsersController::show);
        app.post("/users", NewUsersController::create);
        app.get("/users/{id}/edit", NewUsersController::edit);
        app.patch("/users/{id}", NewUsersController::update);
        app.delete("/users/{id}", NewUsersController::destroy);

        return app;
    }

    public static Javalin getArticleApp() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.result("Go to /articles");
        });

        app.get("/articles", ctx -> {
            List<Article> articles = ArticleRepository.getEntities();
            var page = new ArticlesPage(articles);
            ctx.render("articles/index.jte", model("page", page));
        });

        // BEGIN (write your solution here)
        app.get("/articles/build", ctx -> {
            var page = new BuildArticlePage();
            ctx.render("articles/build.jte", model("page", page));
        });

        app.post("/articles", ctx -> {
            String title = null;
            String content = null;
            try {
                title = ctx.formParamAsClass("title", String.class)
                        .check(value -> value.length() > 2, "title shorter than 2")
                        .check(value -> !ArticleRepository.existsByTitle(value), "title must be unique")
                        .get();
                content = ctx.formParamAsClass("content", String.class)
                        .check(value -> value.length() > 10, "content shorter than 2")
                        .get();
                var article = new Article(title, content);
                ArticleRepository.save(article);
                ctx.redirect("/articles");
            } catch (ValidationException e) {
                ctx.status(422);
                var page = new BuildArticlePage(title, content, e.getErrors());
                ctx.render("articles/build.jte", model("page", page));
            }
        });
        // END

        return app;
    }

    public static Javalin getAppPost() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.post(NamedRoutes.postsPath(), PostsController::create);
        app.get(NamedRoutes.rootPath(), RootController::index);

        app.get(NamedRoutes.postPath("{id}"), PostsController::show);
        app.get(NamedRoutes.postsPath(), PostsController::index);

        app.get(NamedRoutes.postEditPath("{id}"), PostsController::edit);
        app.post(NamedRoutes.postUpdatePath("{id}"), PostsController::update);
        return app;
    }
    public static void main(String[] args) {
        /*Javalin app1 = getApp1();
        app1.start("0.0.0.0", 7070);*/

        /*Javalin app = getApp();
        app.start("0.0.0.0", 8080);*/

        /*Javalin app2 = getAppCourse();
        app2.start("0.0.0.0", 8080);*/

        /*Javalin app3 = getAppUser();
        app3.start("0.0.0.0", 7070);*/

        /*Javalin app4 = getAppNewUser();
        app4.start("0.0.0.0", 7070);*/

        /*Javalin app5 = getArticleApp();
        app5.start("0.0.0.0", 7070);*/

        Javalin app6 = getAppPost();
        app6.start("0.0.0.0", 7070);
    }
}