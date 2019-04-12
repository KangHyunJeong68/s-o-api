package kr.co.saramin.api.controller;

import kr.co.saramin.api.developer.domain.Developer;
import kr.co.saramin.api.developer.dto.DefaultResponse;
import kr.co.saramin.api.developer.dto.LoginResponse;
import kr.co.saramin.api.developer.service.DeveloperService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Resource(name = "kr.co.saramin.api.developer.service.DeveloperService")
    DeveloperService ds;

    @GetMapping("/login")
    private String login(HttpSession sess) throws Exception {
        try {
            Object userData = sess.getAttribute("userLoginInfo");
            System.out.println(userData.toString());
        } catch (Exception e) {
            System.out.println("login seesion : " + e.getMessage());
        }

        return "developer/login";
    }

    @PostMapping("/login")
    private String loginProc(HttpServletRequest rs, HttpSession sess) throws Exception {

        DefaultResponse response = new DefaultResponse();

        System.out.println("loginProc");

        Developer dev = new Developer();
        dev.setEmail(rs.getParameter("email"));
        dev.setPassword(rs.getParameter("password"));

        Integer result = 0;
        try {
            Developer devData = ds.getDevData(dev);
            System.out.println("로그인처리 : " + devData.getName());
            String name = devData.getName();

            if (name != null) {
                sess.setAttribute("userLoginInfo", devData);
                result = 1;
            }

        } catch (Exception e) {
            System.out.println("login-proc error : " + e.getMessage());
            response.setSuccess(false);
            response.setErrorMsg("로그인 실패 하였습니다. 다시 로그인 하십시요.");
            sess.setAttribute("errorResponse", response);
        }

        return result == 0 ? "redirect:/login" : "redirect:developer/my-page";
    }

    private String logout(HttpSession sess) throws Exception {
        sess.setAttribute("userLoginInfo", null);
        return "index";
    }

    private boolean errorChk(HttpSession sess) throws Exception {
        Object errorResponse = null;
        try {
            errorResponse = sess.getAttribute("errorResponse");
        } catch (Exception e) {
            System.out.println("errorChk : " + e.getMessage());
        }

        if (errorResponse == null) {
            return false;
        }

        return true;
    }

}
