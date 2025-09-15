package org.example.hexlet.model;

public class Post {
    private Long id;

    private String name;
    private String body;

    public Post(String name, String body) {
        this.name = name;
        this.body = body;
    }

    public Post(Long id, String name, String body) {
        this.name = name;
        this.body = body;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}


