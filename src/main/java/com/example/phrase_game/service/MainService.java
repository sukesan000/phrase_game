package com.example.phrase_game.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class MainService {
    //選択肢にフレーズを代入
    public List<String> setPhrase() {
        Random rand = new Random();
        int rndCnt = 6;
        ArrayList<String> list = new ArrayList<>();
        List<String> phrase = new ArrayList<String>();
        phrase.addAll(Arrays.asList("大親友", "彼女", "パスタ", "家庭的", "大貧民", "マジ切れ"));

        for (int n = 0; n < 3; n++) {
            int num = rand.nextInt(rndCnt);
            list.add(phrase.get(num));
            phrase.remove(num);
            rndCnt--;
        }
        return list;
    }
}
