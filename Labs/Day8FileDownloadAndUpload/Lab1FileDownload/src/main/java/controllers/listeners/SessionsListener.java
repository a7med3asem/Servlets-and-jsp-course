package controllers.listeners;

import controllers.helpers.*;
import jakarta.servlet.http.*;
import jakarta.servlet.*;

public class SessionsListener implements HttpSessionListener {
    private int usersCount = 0;

    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("Session created");
        incrementUserCounter();
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("Session destroyed");
        decrementUserCounter();
    }

    public void incrementUserCounter() {
        usersCount++;
        CachedServerData.getInstance().saveusersCount(usersCount);
    }

    public void decrementUserCounter() {
        usersCount--;
        CachedServerData.getInstance().saveusersCount(usersCount);
    }
}
