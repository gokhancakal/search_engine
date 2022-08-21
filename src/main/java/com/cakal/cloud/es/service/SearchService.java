package com.cakal.cloud.es.service;

import com.cakal.cloud.es.model.Content;
import com.cakal.cloud.es.repository.ContentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Service
public class SearchService {

    private ContentRepository contentRepository;

    @Autowired
    public List<Content> searchAll() {
        Iterable<Content> content = contentRepository.findAll();
        List<Content> contents = new ArrayList<>();
        content.iterator().forEachRemaining(contents::add);
        return contents;
    }

    public Page<Content> searchWithTerm(String term, Integer pageNum, Integer pageSize)
    {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return contentRepository.findByTitle(term,pageable);
    }

}
