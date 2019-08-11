package com.example.pokerhands;

import java.util.List;

public class PokerHandsCompare {
    public int getWinner(List<Card> firstPlayer, List<Card> secondPlayer) {
        int maxFirst = -1;
        int maxSecond = -1;
        for (int i = 0; i < firstPlayer.size(); i++) {
            if (maxFirst < firstPlayer.get(i).getNum()) {
                maxFirst = firstPlayer.get(i).getNum();
            }
            if (maxSecond < secondPlayer.get(i).getNum()) {
                maxSecond = secondPlayer.get(i).getNum();
            }
        }
        if (maxFirst > maxSecond) {
            return 1;
        }
        return 2;
    }

}
