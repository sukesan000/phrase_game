package com.example.phrase_game.controller;

import com.example.phrase_game.form.Completion_phrase;
import com.example.phrase_game.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@SessionAttributes(names = "form")
public class MainController {
    @Autowired
    MainService mainService;
    @Autowired
    HttpSession session;

    Completion_phrase completion_phrase = new Completion_phrase();

    public static int pushCnt = 1;
    public static List<String> wordList = new ArrayList<String>(Arrays.asList("大親友", "彼女", "パスタ", "家庭的", "大貧民", "マジ切れ"));

    @GetMapping("/")
    public String main(Model model) {
        //選択肢にフレーズをセット
        mainService.setPhrase(model, wordList);
        //〇〇〇をセット
        model.addAttribute("form", completion_phrase);
        return "phrase_game";
    }

    @PostMapping(value = "/", params = "btn1")
    public String chosePhrase1(@RequestParam(name = "btn1", required = false) String selected_phrase, Model model) {
        switch (pushCnt) {
            case 1:
                completion_phrase.setWord1(selected_phrase);
                break;
            case 2:
                completion_phrase.setWord2(selected_phrase);
                break;
            case 3:
                completion_phrase.setWord3(selected_phrase);
                break;
            case 4:
                completion_phrase.setWord4(selected_phrase);
                break;
        }
        model.addAttribute("form", completion_phrase);
        wordList.remove(selected_phrase);
        pushCnt++;
        mainService.setPhrase(model, wordList);
        return "phrase_game";
    }

    @PostMapping(value = "/", params = "btn2")
    public String chosePhrase2(@RequestParam(name = "btn2", required = false) String selected_phrase, Model model) {
        model.addAttribute("word" + pushCnt, selected_phrase);
        pushCnt++;
        mainService.setPhrase(model, wordList);
        return "phrase_game";
    }

    @PostMapping(value = "/", params = "btn3")
    public String chosePhrase3(@RequestParam(name = "btn3", required = false) String selected_phrase, Model model) {
        model.addAttribute("word" + pushCnt, selected_phrase);
        pushCnt++;
        mainService.setPhrase(model, wordList);
        return "phrase_game";
    }

    //セッションのオブジェクト代入格納メソッド
    @ModelAttribute("form")
    public Completion_phrase setCompPhrase(Completion_phrase completion_phrase) {
        return completion_phrase;
    }

}
