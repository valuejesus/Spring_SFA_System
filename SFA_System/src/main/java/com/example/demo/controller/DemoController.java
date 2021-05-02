package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class DemoController {
@GetMapping(path = "original_login")
public String login(@RequestParam(value = "error", required = false) String error,
        @RequestParam(value = "logout", required = false) String logout,
        Model model, HttpSession session) {

    model.addAttribute("showErrorMsg", false);
    model.addAttribute("showLogoutedMsg", false);

    if (error != null) {
    	model.addAttribute("showErrorMsg", true);
        if (session != null) {
            AuthenticationException ex = (AuthenticationException) session
                    .getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            if (ex != null) {
                model.addAttribute("showErrorMsg", true);
                model.addAttribute("errorMsg", ex.getMessage());
            }
        }
    } else if (logout != null) {
        model.addAttribute("showLogoutedMsg", true);
    }
    return "original_login";
}

}
