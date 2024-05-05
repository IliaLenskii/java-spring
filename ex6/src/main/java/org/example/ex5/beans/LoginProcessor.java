package org.example.ex5.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope // Scope is request
public class LoginProcessor {
    private String username;
    private String password;

    public LoginProcessor(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isLogin() {

        String username = this.getUsername();
        String password = this.getPassword();

        // if "" or null - ??
        if ("user".equals(username) && "pass".equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
