package org.example.hexlet.repository;

import org.example.hexlet.model.NewUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NewUserRepository {
    private static List<NewUser> entities = new ArrayList<NewUser>();

    public static void save(NewUser user) {
        user.setId((long) entities.size() + 1);
        entities.add(user);
    }

    public static List<NewUser> search(String term) {
        var users = entities.stream()
                .filter(entity -> entity.getFirstName().startsWith(term))
                .toList();
        return users;
    }

    public static Optional<NewUser> find(Long id) {
        var user = entities.stream()
                .filter(entity -> entity.getId().equals(id))
                .findAny()
                .orElse(null);
        return Optional.of(user);
    }

    public static void delete(Long id) {

    }

    public static List<NewUser> getEntities() {
        return entities;
    }

    public static void clear() {
        entities.clear();
    }
}
