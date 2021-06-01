package com.example.phrase_game.controller;

import com.example.phrase_game.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    MainService mainService;

    @GetMapping("/")
    public String main(Model model) {
        //選択肢にフレーズをセット
        List<String> phrase = mainService.setPhrase();
        model.addAttribute("btn1", phrase.get(0));
        model.addAttribute("btn2", phrase.get(1));
        model.addAttribute("btn3", phrase.get(2));
        return "phrase_game";
    }

}
