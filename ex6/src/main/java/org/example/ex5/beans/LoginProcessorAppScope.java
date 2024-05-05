package org.example.ex5.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope
public class LoginProcessorAppScope {

    private int count = 0;

    public void increment() {
        ++count;
    }

    public int getCount() {
        return count;
    }
}
