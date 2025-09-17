package org.example.hexlet.dto.sessionuser;


import org.example.hexlet.dto.BasePage;

public class MainPage extends BasePage {
    private Object name;

    public MainPage(Object name) {
        this.name = name;
    }

    public Object getName() {
        return name;
    }
}