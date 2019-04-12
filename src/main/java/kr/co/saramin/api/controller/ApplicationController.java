package kr.co.saramin.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {

    @RequestMapping("/application")
    private String index(Model mo) throws Exception {
        mo.addAttribute("title", "사람인 오픈 API - 앱관리");
        return "application/index";
    }

}
