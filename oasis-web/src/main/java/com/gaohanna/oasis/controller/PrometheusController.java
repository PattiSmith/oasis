package com.gaohanna.oasis.controller;

import io.prometheus.client.spring.web.PrometheusTimeMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * something
 *
 * @author keben
 * @date 2018/1/10
 */
@Controller
public class PrometheusController {

    /*@RequestMapping("/")
    @PrometheusTimeMethod(name = "my_controller_path_duration_seconds", help = "Some helpful info here")
    public Object handleMain() {
        // Do something
        return "Hello World";
    }*/
}
