package org.example.ex5.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoginProcessorSessionScope {

    private String username;
    private String password;

    private boolean isLoginFlag = false;

    public LoginProcessorSessionScope() {}

    public LoginProcessorSessionScope(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setNamePass(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isLogin() {

        String username = this.getUsername();
        String password = this.getPassword();

        // if "" or null - ??
        if ("user".equals(username) && "1".equals(password))
            return this.isLoginFlag = true;

        return this.isLoginFlag = false;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLoginFlag() { return isLoginFlag; }

    public void logoff() {

        username = null;
        password  = null;

        isLoginFlag = false;
    }
}
