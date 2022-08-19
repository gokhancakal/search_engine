package com.cakal.cloud.es.configuration;

import lombok.SneakyThrows;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.springframework.beans.factory.annotation.Value;
import org.apache.http.HttpHost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import javax.annotation.Nonnull;
import javax.net.ssl.SSLContext;

@Configuration
public class ESConfig extends AbstractElasticsearchConfiguration {

    private static final int ONE_MINUTE = 60 * 1000;
    private static final int ONE_SECOND = 1000;
    @Value("${elasticsearch.host}")
    private String host;
    @Value("${elasticsearch.port}")
    private int port;
    @Value("${elasticsearch.username}")
    private String username;
    @Value("${elasticsearch.password}")
    private String password;

    @SneakyThrows
    @Bean
    @Deprecated
    @Nonnull
    public RestHighLevelClient elasticsearchClient() throws RuntimeException  {
        try {
            SSLContextBuilder sslBuilder = SSLContexts.custom()
                    .loadTrustMaterial(null, (x509Certificates, s) -> true);
            final SSLContext sslContext = sslBuilder.build();
            final CredentialsProvider credentialsProvider =
                    new BasicCredentialsProvider();
            credentialsProvider.setCredentials(AuthScope.ANY,
                    new UsernamePasswordCredentials(username, password));
            RestHighLevelClient client = new RestHighLevelClient(RestClient
                    .builder(new HttpHost(host, port, "https"))
                    .setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder
                            .setDefaultCredentialsProvider(credentialsProvider)
                            .setSSLContext(sslContext)
                            .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE))
                    .setRequestConfigCallback(requestConfigBuilder -> requestConfigBuilder.setConnectTimeout(ONE_MINUTE)
                            .setSocketTimeout(ONE_SECOND)));
            System.out.println("elasticsearch client created");
            return client;
        } catch (Exception e) {
            throw new Exception("Could not create an elasticsearch client!!");
        }
    }
    @Bean
    public ElasticsearchOperations elasticsearchRestTemplate() {
        return new ElasticsearchRestTemplate(elasticsearchClient());
    }
}