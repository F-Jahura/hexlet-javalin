package org.example.hexlet.util;

import net.datafaker.Faker;
import org.example.hexlet.model.Post;
import org.example.hexlet.model.SessionUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.example.hexlet.util.Security.encryptSession;

public class Generator {
    private static final int ITEMS_COUNT = 32;
    private static final Random RANDOM = new Random(123);

    public static List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();
        Faker faker = new Faker(RANDOM);

        for (int i = 0; i < ITEMS_COUNT; i++) {
            var name = faker.book().title();
            var body = faker.lorem().sentence();
            var id = (long) (i + 1);
            var post = new Post(id, name, body);
            posts.add(post);
        }

        return posts;
    }

    public static List<SessionUser> getUsers() {
        List<SessionUser> users = new ArrayList<>();

        users.add(new SessionUser(1L, "admin", encryptSession("secret")));
        users.add(new SessionUser(2L, "mike", encryptSession("superpass")));
        users.add(new SessionUser(3L, "kate", encryptSession("strongpass")));

        return users;
    }
}
