package com.itechart.container.spring.emailscheduler.api;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class DefaultApi {

    @GetMapping("/")
    public String defaultRedirect() {
        return "redirect:swagger-ui.html";
    }

}

