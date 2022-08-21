package com.cakal.cloud.es.repository;

import com.cakal.cloud.es.model.Content;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


@Repository
public interface ContentRepository extends ElasticsearchRepository<Content, String> {

    Page<Content> findByTitle(String title, Pageable page);

}
