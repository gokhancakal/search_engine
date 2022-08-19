package com.cakal.cloud.es.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = ".ent-search-engine-documents-garanti-demo")
public class Content {

    @Id
    private String id;

    @Field(type = FieldType.Text, name = "url")
    private String url;

    @Field(type = FieldType.Text, name = "title")
    private String title;

    @Field(type = FieldType.Text, name = "meta_description")
    private String meta_description;

    @Field(type = FieldType.Text, name = "last_crawled_at")
    private String last_crawled_at;

}
