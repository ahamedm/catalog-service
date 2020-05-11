package dev.trials.spring.service.catalog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.trials.spring.service.catalog.dto.ApiConfiguration;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    @Autowired
    ApiConfiguration api;

    @GetMapping("/api/meta")
    public ApiConfiguration index(){
        return api;
    }
}