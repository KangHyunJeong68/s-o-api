package kr.co.saramin.api.controller;

import kr.co.saramin.api.developer.domain.Application;
import kr.co.saramin.api.developer.domain.Developer;
import kr.co.saramin.api.developer.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @RequestMapping("/application")
    private String index() throws Exception {
        return "application/index";
    }

    @RequestMapping("/application/index")
    private String app(HttpSession sess) throws Exception {
        System.out.println("app-------------");
        return !isLogin(sess) ? "redirect:/login" : "application/register";
    }

    @RequestMapping("/application/app-insert")
    private String appInstall(HttpServletRequest rs, HttpSession sess) throws Exception {

        Application app = new Application();
        Developer sessData = (Developer)sess.getAttribute("userLoginInfo");
        app.setName(rs.getParameter("app_name"));
        app.setDev_idx(sessData.getIdx());
        Integer result = applicationService.insertApplication(app);
        return result == 0 ? "redirect:/application/index" :"redirect:/application/app-list";
    }

    @RequestMapping("/application/app-list")
    private String appList(Model mo, HttpSession sess) throws Exception {
        if (!isLogin(sess)) {
            return "redirect:/login";
        }
        Developer devData = (Developer) sess.getAttribute("userLoginInfo");
        List appList = applicationService.selectApplicationList(devData.getIdx());
        mo.addAttribute("appList", appList);
        return "/application/list";
    }

    @PostMapping("application/delete-app")
    @ResponseBody
    private Integer appDelete(HttpServletRequest rs) throws Exception {
        Integer idx = Integer.parseInt(rs.getParameter("idx"));
        if (idx == null) return 0;
        return applicationService.deleteApplication(idx);
    }

    private boolean isLogin(HttpSession sess) {

        Object sessData = null;
        try {
            sessData = sess.getAttribute("userLoginInfo");

        } catch (Exception e) {
            System.out.println("app - error" + e.getMessage());
        }

        return sessData != null;
    }

}
