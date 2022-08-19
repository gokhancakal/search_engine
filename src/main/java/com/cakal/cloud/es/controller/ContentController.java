package com.cakal.cloud.es.controller;

import com.cakal.cloud.es.model.Content;
import com.cakal.cloud.es.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class ContentController {
    private final SearchService searchService;

    @GetMapping
    public List<Content> searchAll() {
        return searchService.searchAll();
    }

}

