package com.up.empresa.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

public class ConfigurationFactory {

    @Produces
    @Configuration
    @ApplicationScoped
    public Properties getProperties() throws IOException{
        InputStream inputStream = ConfigurationFactory.class.getResourceAsStream("/config.properties");

        Properties properties = new Properties();
        properties.load(inputStream);

        return properties;
    }


}