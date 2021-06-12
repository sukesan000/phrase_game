package com.example.phrase_game.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MainService {
    //選択肢にフレーズを代入
    public void setPhrase(Model model, List<String> wordList) {
        Random rand = new Random();
        List<String> select_phrase = new ArrayList<String>(wordList);
        int rndCnt = select_phrase.size();
        ArrayList<String> list = new ArrayList<>();
        for (int n = 0; n < 3; n++) {
            int num = rand.nextInt(rndCnt);
            list.add(select_phrase.get(num));
            select_phrase.remove(num);
            rndCnt--;
        }
        model.addAttribute("btn1", list.get(0));
        model.addAttribute("btn2", list.get(1));
        model.addAttribute("btn3", list.get(2));
    }
}
