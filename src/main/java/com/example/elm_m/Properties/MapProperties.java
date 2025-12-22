package com.example.elm_m.Properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "elm.map")
public class MapProperties {
    private String mapKey;
}
