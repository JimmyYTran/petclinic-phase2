package com.example.petclinic.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeEvent;
import org.springframework.boot.ExitCodeExceptionMapper;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class ExitCodeConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(ExitCodeConfiguration.class.getName());

    // Uncomment this to exit with code 80
//    @Bean
//    CommandLineRunner createException() {
//        return args -> Integer.parseInt("test") ;
//    }

    @Bean
    ExitCodeExceptionMapper exitCodeToExceptionMapper() {
        return exception -> {
            // set exit code base on the exception type
            if (exception.getCause() instanceof NumberFormatException) {
                return 80;
            }
            return 1;
        };
    }

    @Bean
    DemoListener demoListenerBean() {
        return new DemoListener();
    }

    private static class DemoListener {
        @EventListener
        public void exitEvent(ExitCodeEvent event) {
            logger.warn("Exit code: " + event.getExitCode());
        }
    }
}
