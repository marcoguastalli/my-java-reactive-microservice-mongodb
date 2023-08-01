package net.marco27.api.rx.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties("web")
public class ApplicationYmlConfig {

    public static final String VERSION = "v1";
    private String version;

}
