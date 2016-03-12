package eu.estimol.giflib.controller;

import eu.estimol.giflib.model.Gif;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Arrays;

@Controller
public class GifController {
    @RequestMapping("/")
    public String listGifs(){
        return "home";
    }

    @RequestMapping("/gif")
    public String gifDetails (ModelMap modelMap){
        Gif gif = new Gif("compiler-bot", LocalDate.of(2016,2,13),"Konstantin Tenman", true);
        modelMap.put("gif",gif);
        System.out.println(modelMap.toString());
        for (int i = 0; i < modelMap.size(); i++) {
            System.out.println(modelMap.get(i).toString());
        }
        return "gif-details";
    }

}
