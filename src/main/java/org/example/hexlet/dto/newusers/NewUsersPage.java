package org.example.hexlet.dto.newusers;

import org.example.hexlet.model.NewUser;

import java.util.List;

public class NewUsersPage {
    private List<NewUser> newusers;

    public NewUsersPage(List<NewUser> newusers) {
        this.newusers = newusers;
    }

    public List<NewUser> getNewusers() {
        return newusers;
    }
}
