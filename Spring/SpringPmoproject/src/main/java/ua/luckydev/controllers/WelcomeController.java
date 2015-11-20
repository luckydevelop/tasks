package ua.luckydev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  онтроллер дл€ главной страницы приложени€.
 */
@Controller
public class WelcomeController {

    private int visitorCount = 0;

    @RequestMapping("/index.html")
    public String index(Model model) {
        model.addAttribute("visitorCount", visitorCount++);
        return "WEB-INF/jsp/index.jsp";
    }

}