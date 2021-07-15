package com.testdomain.aop_sample.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SampleController.BASE_URL)
public class SampleController {
    public static final String BASE_URL = "/api/sample";

    @GetMapping
    public ResponseEntity<Object> get() {
        return new ResponseEntity<>( "success", HttpStatus.OK);
    }
}
