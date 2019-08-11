package com.example.pokerhands;

import java.util.List;

public class PokerHandsCompare {
    public int getWinner(List<Card> firstPlayer, List<Card> secondPlayer) {
        int maxFirst = -1;
        int first = -1;
        int maxSecond = -1;
        int second = -1;
        for (int i = 0; i < firstPlayer.size(); i++) {
            first = translateNum(firstPlayer, i);
            if (maxFirst < first) {
                maxFirst = first;
            }
            second = translateNum(secondPlayer, i);
            if (maxSecond < second) {
                maxSecond = second;
            }
        }
        if (maxFirst > maxSecond) {
            return 1;
        }
        return 2;
    }

    private int translateNum(List<Card> secondPlayer, int i) {
        int second;
        switch (secondPlayer.get(i).getNum()) {
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
                second = secondPlayer.get(i).getNum()-48;
                break;
        }
        return second;
    }

}
