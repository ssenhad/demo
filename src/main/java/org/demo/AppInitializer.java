package org.demo;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.logging.Logger;


/*
Quarkus provides lifecycle events that you can observes in a CDI bean.
 */

@ApplicationScoped
public class AppInitializer {
    private final static Logger LOGGER = Logger.getLogger(AppInitializer.class.getName());
    @Inject
    private PostRepository posts;


    void onStart(@Observes StartupEvent ev) {
        LOGGER.info("The application is starting...");
        Post first = Post.of("123456","Hello Quarkus", "My first post of Quarkus");
        Post second = Post.of("456987","Hello Again, Quarkus", "My second post of Quarkus");
        this.posts.save(first);
        this.posts.save(second);
    }

    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("The application is stopping...");
    }
}
