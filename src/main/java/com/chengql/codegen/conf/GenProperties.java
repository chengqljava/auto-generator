package com.chengql.codegen.conf;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "gen")
public class GenProperties {

    private String              packageName;
    private String              author;
    private String              email;
    private String              tablePrefix;
    private Map<String, String> typeMap;

}
