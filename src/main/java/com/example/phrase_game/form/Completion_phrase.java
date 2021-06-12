package com.example.phrase_game.form;

import lombok.Data;

@Data
public class Completion_phrase {
    private String word1;
    private String word2;
    private String word3;
    private String word4;

    public Completion_phrase() {
        this.word1 = "◯◯◯";
        this.word2 = "◯◯◯";
        this.word3 = "◯◯◯";
        this.word4 = "◯◯◯";
    }
}
