package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.example.hexlet.model.Car;
import org.example.hexlet.repository.CarRepository;

import java.sql.SQLException;


public class CarsController {
    public static void create(Context ctx) throws SQLException {
        try {
            var make = ctx.formParamAsClass("make", String.class)
                    .check(value -> !value.isEmpty(), "марка не должно быть пустым")
                    .get();
            var model = ctx.formParamAsClass("model", String.class)
                    .check(value -> !value.isEmpty(), "Модель не должно быть пустым")
                    .get();
            var car = new Car(make, model);
            CarRepository.save(car);
            ctx.json(car);

        } catch (ValidationException e) {
            ctx.json(e.getErrors()).status(422);
        }
    }

    public static void index(Context ctx) throws SQLException {
        var posts = CarRepository.getEntities();
        ctx.json(posts);
    }

    public static void show(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var car = CarRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Car not found"));
        ctx.json(car);
    }
}
