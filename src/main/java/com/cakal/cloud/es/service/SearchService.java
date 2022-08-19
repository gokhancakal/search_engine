package com.cakal.cloud.es.service;

import com.cakal.cloud.es.model.Content;
import com.cakal.cloud.es.repository.ContentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Service
public class SearchService {

    private ContentRepository contentRepository;

    public List<Content> searchAll() {
        Iterable<Content> content = contentRepository.findAll();
        List<Content> contents = new ArrayList<>();
        content.iterator().forEachRemaining(contents::add);
        return contents;
    }

}
