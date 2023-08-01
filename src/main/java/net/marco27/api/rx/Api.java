package net.marco27.api.rx;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Api {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Api.class).web(WebApplicationType.REACTIVE).run(args);
    }
}