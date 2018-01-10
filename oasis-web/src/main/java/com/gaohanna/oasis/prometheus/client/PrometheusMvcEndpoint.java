package com.gaohanna.oasis.prometheus.client;

import io.prometheus.client.exporter.common.TextFormat;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

/**
 * something
 *
 * @author keben
 * @date 2018/1/9
 */
@ConfigurationProperties("endpoints.prometheus")
public class PrometheusMvcEndpoint extends EndpointMvcAdapter {

    private final PrometheusEndpoint delegate;

    /**
     * Create a new {@link EndpointMvcAdapter}.
     *
     * @param delegate the underlying {@link Endpoint} to adapt.
     */
    public PrometheusMvcEndpoint(PrometheusEndpoint delegate) {
        super(delegate);
        this.delegate = delegate;
    }

    @RequestMapping(method = {RequestMethod.GET}, produces = {"*/*"})
    @ResponseBody
    public ResponseEntity value(@RequestParam(value = "name[]", required = false, defaultValue = "") Set<String> name) {
        if (!getDelegate().isEnabled()) {
            return getDisabledResponse();
        }

        String result = delegate.writeRegistry(name);
        return ResponseEntity.ok()
                .header("CONTENT_TYPE", TextFormat.CONTENT_TYPE_004)
                .body(result);
    }

}
