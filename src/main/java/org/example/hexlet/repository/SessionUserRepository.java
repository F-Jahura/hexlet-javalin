package org.example.hexlet.repository;

import org.example.hexlet.model.SessionUser;
import org.example.hexlet.util.Generator;

import java.util.List;
import java.util.Optional;

public class SessionUserRepository {
    private static List<SessionUser> entities = Generator.getUsers();

    public static void save(SessionUser user) {
        user.setId((long) entities.size() + 1);
        entities.add(user);
    }

    public static List<SessionUser> search(String term) {
        return entities.stream()
                .filter(entity -> entity.getName().startsWith(term))
                .toList();
    }

    public static Optional<SessionUser> find(Long id) {
        return entities.stream()
                .filter(entity -> entity.getId().equals(id))
                .findAny();
    }

    public static Optional<SessionUser> findByName(String name) {
        return entities.stream()
                .filter(entity -> entity.getName().equals(name))
                .findAny();
    }

    public static boolean existsByName(String name) {
        return entities.stream()
                .anyMatch(value -> value.getName().equals(name));
    }

    public static List<SessionUser> getEntities() {
        return entities;
    }

    public static void clear() {
        entities.clear();
    }
}
