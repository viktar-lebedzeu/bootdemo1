package com.example.bootdemo.controller;

import com.example.bootdemo.dto.ErrorMessage;

import javax.validation.constraints.NotNull;

/**
 * Factory class to create different types of responses
 * @author Viktar Lebedzeu
 */
public class ResponseFactory {

    public static AppResponse createBaseSuccessResponse() {
        return new AppResponse("OK");
    }

    public static AppResponse createErrorResponse(@NotNull ErrorMessage error) {
        AppResponse appResponse = new AppResponse("FAIL");
        appResponse.put("errorCode", error.getErrorCode());
        appResponse.put("errormessage", error.getMessage());
        return appResponse;
    }

}
