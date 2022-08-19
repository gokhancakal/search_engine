package com.cakal.cloud.es.repository;

import com.cakal.cloud.es.model.Content;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContentRepository extends ElasticsearchRepository<Content, String> {

}
