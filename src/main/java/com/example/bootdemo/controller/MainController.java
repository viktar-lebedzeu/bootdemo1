package com.example.bootdemo.controller;

import com.example.bootdemo.ApplicationInfoService;
import com.example.bootdemo.annotation.LogMethod;
import com.example.bootdemo.dto.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Viktar Lebedzeu
 */
@RestController
public class MainController {
    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private ApplicationInfoService applicationInfoService;

    @GetMapping("/app-info")
    @LogMethod
    public ResponseEntity<AppResponse> getApplicationInfo() {
        AppResponse response = ResponseFactory.createBaseSuccessResponse();
        response.put("app-info", applicationInfoService.getApplicationInfo());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/get-error")
    @LogMethod(type = "get-error")
    public ResponseEntity<AppResponse> getErrorResponse(@RequestBody Optional<ErrorMessage> error) {
        AppResponse response = ResponseFactory.createErrorResponse(error.orElse(ErrorMessage.UNKNOWN));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
