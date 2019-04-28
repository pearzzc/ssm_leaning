package com.zzc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hi")
public class MyController {
    @RequestMapping("/aaa")
    public String say(Model model) {
        model.addAttribute("jj","简单");
        model.addAttribute("JB","几把");
        return "say";
    }
}
