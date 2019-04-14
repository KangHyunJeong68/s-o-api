package kr.co.saramin.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {

    @RequestMapping("/application")
    private String index() throws Exception {
        return "application/index";
    }

}
