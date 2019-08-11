package com.example.pokerhands;

public class Card {

    private char num;
    private char type;

    public Card() {
    }

    public Card(String number) {
        this.num = number.charAt(0);
        this.type = number.charAt(1);
    }

    public char getNum() {
        return num;
    }

    public void setNum(char num) {
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
}
