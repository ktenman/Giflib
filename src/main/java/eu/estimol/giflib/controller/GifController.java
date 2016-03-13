package eu.estimol.giflib.controller;

import eu.estimol.giflib.data.GifRepository;
import eu.estimol.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class GifController {

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/")
    public String listGifs(ModelMap modelMap){
        ArrayList<Gif> allGifs = gifRepository.getAllGifs();
        modelMap.put("gifs", allGifs);
        return "home";
    }

//    @RequestMapping("/gif")
//    public String gifDetails (ModelMap modelMap){
//        Gif gif = new Gif("compiler-bot", LocalDate.of(2016,2,13),"Konstantin Tenman", true);
//        modelMap.put("gif",gif);
//        return "gif-details";
//    }

    @RequestMapping("/gif/{gifName}")
    public String gifDetailsByName (ModelMap modelMap, @PathVariable String gifName){
        Gif gif = gifRepository.findByName(gifName);
        if (gif == null){
            return "home";
        }
        modelMap.put("gif", gif);
        return "gif-details";
    }

}
