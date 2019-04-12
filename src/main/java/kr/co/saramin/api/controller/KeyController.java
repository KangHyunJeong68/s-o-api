package kr.co.saramin.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class KeyController {

    private String index(Model mo) throws Exception {
        mo.addAttribute("title", "사람인 오픈 API");
        return "key/index";
    }
}
