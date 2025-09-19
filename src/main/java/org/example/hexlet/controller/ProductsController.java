package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.example.hexlet.model.Product;
import org.example.hexlet.repository.ProductsRepository;

import java.sql.SQLException;

public class ProductsController {

    public static void create(Context ctx) throws SQLException {
        try {
            var title = ctx.formParamAsClass("title", String.class)
                    .check(value -> !value.isEmpty(), "Название не должно быть пустым")
                    .get();
            var price = ctx.formParamAsClass("price", Integer.class)
                    .check(value -> value >= 0, "Цена не должна быть отрицательной")
                    .get();
            var product = new Product(title, price);
            ProductsRepository.save(product);
            ctx.json(product);

        } catch (ValidationException e) {
            ctx.json(e.getErrors()).status(422);
        }
    }

    public static void index(Context ctx) throws SQLException {
        var posts = ProductsRepository.getEntities();
        ctx.json(posts);
    }

    public static void show(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var product = ProductsRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Product not found"));
        ctx.json(product);
    }
}
