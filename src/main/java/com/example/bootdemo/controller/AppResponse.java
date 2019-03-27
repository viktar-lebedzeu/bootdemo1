package com.example.bootdemo.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Viktar Lebedzeu
 */
public class AppResponse extends HashMap<String, Object> {
    private String status;

    private AppResponse(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    private AppResponse(int initialCapacity) {
        super(initialCapacity);
    }

    private AppResponse() {
    }

    private AppResponse(Map<? extends String, ?> m) {
        super(m);
    }

    public AppResponse(int initialCapacity, float loadFactor, String status) {
        super(initialCapacity, loadFactor);
        this.status = status;
        put("status", status);
    }

    public AppResponse(int initialCapacity, String status) {
        super(initialCapacity);
        this.status = status;
        put("status", status);
    }

    public AppResponse(String status) {
        this.status = status;
        put("status", status);
    }

    public AppResponse(Map<? extends String, ?> m, String status) {
        super(m);
        this.status = status;
        put("status", status);
    }
}
