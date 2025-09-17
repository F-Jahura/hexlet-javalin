package org.example.hexlet.model;

public class SessionUser {
    private Long id;
    private String name;

    private String password;

    public SessionUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public SessionUser(Long id, String name, String password) {
        this.name = name;
        this.password = password;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SessionUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
