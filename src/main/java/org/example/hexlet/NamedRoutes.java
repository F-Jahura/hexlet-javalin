package org.example.hexlet;

public class NamedRoutes {
    public static String rootPath() {
        return "/";
    }

    public static String usersPath() {
        return "/users";
    }

    public static String buildUserPath() {
        return "/users/build";
    }

    public static String userPath(Long id) {
        return userPath(String.valueOf(id));
    }

    public static String userPath(String id) {
        return "/users/" + id;
    }

    public static String coursesPath() {
        return "/courses";
    }

    // Это нужно, чтобы не преобразовывать типы снаружи
    public static String coursePath(Long id) {
        return coursePath(String.valueOf(id));
    }

    public static String coursePath(String id) {
        return "/courses/" + id;
    }

    public static String articlesPath() {
        return "/articles";
    }

    public static String buildArticlePath() {
        return "/articles/build";
    }


    public static String postsPath() {
        return "/posts";
    }

    public static String buildPostPath() {
        return "/posts/build";
    }

    public static String postPath(Long id) {
        return postPath(String.valueOf(id));
    }

    public static String postPath(String id) {
        return "/posts/" + id;
    }

    public static String postEditPath(String postId) {
        return "/posts/" + postId + "/edit";
    }

    public static String postUpdatePath(String postId) {
        return "/posts/" + postId;
    }
}