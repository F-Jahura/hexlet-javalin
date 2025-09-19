package org.example.hexlet.controller;

import io.javalin.http.Context;

public class RootDataBaseController {
    public static void index(Context ctx) {
        ctx.result("Welcome to Hexlet");
    }
}
