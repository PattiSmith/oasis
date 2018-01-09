package com.gaohanna.oasis.prometheus.client;

import io.prometheus.client.CollectorRegistry;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * something
 *
 * @author keben
 * @date 2018/1/9
 */
@Configuration
public class PrometheusEndpointConfiguration {

    @Bean
    public PrometheusEndpoint prometheusEndpoint(){
        return new PrometheusEndpoint(CollectorRegistry.defaultRegistry);
    }

    @Bean
    @ConditionalOnBean(PrometheusEndpoint.class)
    @ConditionalOnEnabledEndpoint("prometheus")
    public PrometheusMvcEndpoint prometheusEndpointFix(PrometheusEndpoint prometheusEndpoint) {
        return new PrometheusMvcEndpoint(prometheusEndpoint);
    }
}
