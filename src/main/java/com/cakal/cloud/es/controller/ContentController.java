package com.cakal.cloud.es.controller;

import com.cakal.cloud.es.model.Content;
import com.cakal.cloud.es.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })
@RequiredArgsConstructor
public class ContentController {
    private final SearchService searchService;

    @GetMapping("full")
    public List<Content> searchAll() {
        return searchService.searchAll();
    }

    @GetMapping("search")
    public Page<Content> searchWithTerm(@RequestParam("term") String term,
                                @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                @RequestParam(required = false, defaultValue = "5") Integer pageSize)
    {
        return searchService.searchWithTerm(term,pageNum,pageSize);
    }
}

