package com.example.pokerhands;

import java.util.List;

public class Card {

    private int num;
    private char type;

    public Card() {
    }

    public Card(String number) {
        this.num = translateNum(number.charAt(0));
        this.type = number.charAt(1);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int compareNum(Card card) {
        return this.num > card.num ? 1 : 2;
    }

    private int translateNum(char player) {
        int second;
        switch (player) {
            case 't':
                second = 10;
                break;
            case 'j':
                second = 11;
                break;
            case 'q':
                second = 12;
                break;
            case 'k':
                second = 13;
                break;
            case 'a':
                second = 14;
                break;
            default:
                second = player-48;
                break;
        }
        return second;
    }
}
