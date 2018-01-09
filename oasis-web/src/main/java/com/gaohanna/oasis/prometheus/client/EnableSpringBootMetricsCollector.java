package com.gaohanna.oasis.prometheus.client;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * something
 *
 * @author keben
 * @date 2018/1/9
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(PrometheusMetricsConfiguration.class)
public @interface EnableSpringBootMetricsCollector {
}
