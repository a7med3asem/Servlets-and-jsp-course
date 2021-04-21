package listeners;

import helpers.CachedCredentialsData;
import jakarta.servlet.http.*;
import jakarta.servlet.*;

public class SessionsListeners implements HttpSessionListener {
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
        CachedCredentialsData.getInstance().saveusersCount(usersCount);
    }

    public void decrementUserCounter() {
        usersCount--;
        CachedCredentialsData.getInstance().saveusersCount(usersCount);
    }
}
