package org.example.ex5.controller;

import org.example.ex5.beans.LoginProcessorAppScope;
import org.example.ex5.beans.LoginProcessorSessionScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SessionScope {

    private final LoginProcessorSessionScope loginSessionScope;
    private final LoginProcessorAppScope AppScope;

    public SessionScope(
            LoginProcessorSessionScope loginSessionScope,
            LoginProcessorAppScope AppScope
    ) {
        this.loginSessionScope = loginSessionScope;
        this.AppScope = AppScope;
    }

    @GetMapping("/sessionScope")
    public String sessionScope(Model model) {

        model.addAttribute("message", loginSessionScope.isLoginFlag());

        model.addAttribute("count", AppScope.getCount());

        return "sessionScope.html";
    }

    @PostMapping("/sessionScope")
    public String sessionScope(
            @RequestParam String username,
            @RequestParam String password
    ) {

        loginSessionScope.setNamePass(username, password);
        loginSessionScope.isLogin();

        AppScope.increment();

        return "redirect:/sessionScope";
    }

    @GetMapping("/sessionScope/logoff")
    public String sessionScope() {

        loginSessionScope.logoff();

        return "redirect:/sessionScope";
    }

}
