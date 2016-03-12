package eu.estimol.giflib.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GifController {
    @RequestMapping("/")
    public String listGifs(){
        return "home";
    }

}
