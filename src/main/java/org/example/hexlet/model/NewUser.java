package org.example.hexlet.model;

public class NewUser {
    private Long id;
    private String firstName;

    private String lastName;

    private String email;
    private String encriptedPassword;
    private String token;

    public NewUser(String firstName, String lastName, String email, String encriptedPassword, String token) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.encriptedPassword = encriptedPassword;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncriptedPassword() {
        return encriptedPassword;
    }

    public void setEncriptedPassword(String encriptedPassword) {
        this.encriptedPassword = encriptedPassword;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
