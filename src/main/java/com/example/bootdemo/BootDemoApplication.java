package com.example.bootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@SpringBootApplication
@PropertySources(
        @PropertySource("application.properties")
)
public class BootDemoApplication {
    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(BootDemoApplication.class);

    public static void main(String... args) {
        SpringApplication application = new SpringApplication(BootDemoApplication.class);

        // Adding application hooks
        application.addListeners(
                (ApplicationListener<ApplicationStartingEvent>) event -> {
                    logger.info("starting BootDemo application ");
                },
                (ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> {
                    Environment environment = event.getEnvironment();
                    String appEncoding = environment.getProperty("app.encoding");
                    String appJavaVersion = environment.getProperty("app.java.version");
                    String appName = environment.getProperty("spring.application.name");
                    logger.info("Application environment prepared [" + appName + "]");
                    logger.debug("app.encoding = " + appEncoding);
                    logger.debug("app.java.version = " + appJavaVersion);
                }
        );
        // Running application instance
        application.run(args);
    }
}
