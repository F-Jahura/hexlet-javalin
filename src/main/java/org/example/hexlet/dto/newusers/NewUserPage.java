package org.example.hexlet.dto.newusers;

import org.example.hexlet.model.NewUser;

public class NewUserPage {
    private NewUser user;

    public NewUserPage(NewUser user) {
        this.user = user;
    }

    public NewUser getUser() {
        return user;
    }
}
