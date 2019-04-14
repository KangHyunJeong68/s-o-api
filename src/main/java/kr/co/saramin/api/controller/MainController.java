package kr.co.saramin.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    private String index(Model mo) throws Exception {
        mo.addAttribute("title", "사람인 오픈 API");
        return "index";
    }

    @RequestMapping("/api")
    private String apiIntro() throws Exception {
        return "api-intro/index";
    }

}
