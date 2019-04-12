package kr.co.saramin.api.controller;

import kr.co.saramin.api.developer.domain.Developer;
import kr.co.saramin.api.developer.service.DeveloperService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class DeveloperController {

    public String defaultUrl = "/developer";

    @Resource(name = "kr.co.saramin.api.developer.service.DeveloperService")
    DeveloperService ds;

    @RequestMapping({"/developer", "/developer/index"})
    private String index(LoginDto loginDto, Model mo) throws Exception {

//        System.out.println(loginDto.toString());
        return defaultUrl + "/index";
    }

    @RequestMapping({"/developer/join"})
    private String join(Model mo) throws Exception {
        mo.addAttribute("defaultUrl", defaultUrl);
        return defaultUrl + "/join";
    }

    @RequestMapping("/developer/join-proc")
    private String joinProc(HttpServletRequest rs, Model mo) throws Exception {
        System.out.println("joinProc");

        Developer dev = new Developer();
        dev.setName(rs.getParameter("user_name"));
        dev.setEmail(rs.getParameter("email"));
        dev.setCompany_nm(rs.getParameter("company_name"));
        dev.setPassword(rs.getParameter("password"));
        Integer result = ds.insertDev(dev);

        mo.addAttribute("user_name", dev.getName());
        return result == 0 ? defaultUrl + "/join" : defaultUrl + "/join-success";
    }


    @RequestMapping("/developer/my-page")
    private String myPage() throws Exception {

        return defaultUrl + "/my-page";
    }
}
