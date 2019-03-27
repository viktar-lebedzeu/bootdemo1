package com.example.bootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Provides application info
 * @author Viktar Lebedzeu
 */
@Service
public class ApplicationInfoService {
    /** Spring application environment */
    @Autowired
    private Environment environment;

    public Map<String, Object> getApplicationInfo() {
        HashMap<String, Object> appInfo = new HashMap<>();
        String appEncoding = environment.getProperty("app.encoding");
        String appJavaVersion = environment.getProperty("app.java.version");
        String appName = environment.getProperty("spring.application.name");
        String serverPort = environment.getProperty("server.port");
        appInfo.put("app.name", appName);
        appInfo.put("app.encoding", appEncoding);
        appInfo.put("java.version", appJavaVersion);
        appInfo.put("server.port", serverPort);
        return appInfo;
    }
}
