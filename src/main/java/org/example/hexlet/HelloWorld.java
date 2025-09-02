package org.example.hexlet;
import io.javalin.Javalin;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        // Описываем, что загрузится по адресу /
        app.get("/", ctx -> ctx.result("Hello World"));
        app.start(7070); // Стартуем веб-сервер
    }
}