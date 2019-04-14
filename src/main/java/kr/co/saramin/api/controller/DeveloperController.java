package kr.co.saramin.api.controller;

import kr.co.saramin.api.developer.domain.Developer;
import kr.co.saramin.api.developer.dto.LoginDto;
import kr.co.saramin.api.developer.service.DeveloperService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class DeveloperController {

    public String defaultPath = "/developer";

    @Resource(name = "kr.co.saramin.api.developer.service.DeveloperService")
    DeveloperService ds;

    @RequestMapping({"/developer", "/developer/index"})
    private String index() throws Exception {
        return defaultPath + "/index";
    }

    @RequestMapping({"/developer/join"})
    private String join(Model mo) throws Exception {
        mo.addAttribute("defaultPath", defaultPath);
        return defaultPath + "/join";
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
        System.out.println("insert result : " + result);
        mo.addAttribute("user_name", dev.getName());

        return result == 0 ? defaultPath + "/join" : defaultPath + "/join-success";
    }
    
    @RequestMapping("/developer/my-page")
    private String myPage(HttpSession sess, Model mo) throws Exception {

        boolean loginChk = false;
        try {
            Developer developer = (Developer) sess.getAttribute("userLoginInfo");
            Integer idx = developer.getIdx();
            if (idx != null) {
                loginChk = true;
            }
            mo.addAttribute("name", developer.getName());
            mo.addAttribute("email", developer.getEmail());
            mo.addAttribute("companyName", developer.getCompany_nm());
        } catch (Exception e) {
            System.out.println("my-page error : " + e.getMessage());
        }
        
        return loginChk ? defaultPath + "/my-page" : "redirect:/login";
    }
    
    
}
