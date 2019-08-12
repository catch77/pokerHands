package com.example.pokerhands;

import java.util.ArrayList;
import java.util.List;

public class PokerHandsCompare {

    public static final int OnePair = 2;

    public int getWinner(List<Card> firstPlayer, List<Card> secondPlayer) {
        int maxFirst = -1;
        int first = -1;
        int maxSecond = -1;
        int second = -1;
        int firstLevel = 0;
        int secondLevel = 0;
        for (int i = 0; i < firstPlayer.size(); i++) {
            first = firstPlayer.get(i).getNum();
            if (maxFirst < first) {
                maxFirst = first;
            }
            second = secondPlayer.get(i).getNum();
            if (maxSecond < second) {
                maxSecond = second;
            }
        }
        firstLevel = cardsType(firstPlayer);
        secondLevel = cardsType(secondPlayer);

        if (firstLevel > secondLevel) {
            return 1;
        } else if (secondLevel > firstLevel) {
            return 2;
        } else {
            if (maxFirst > maxSecond) {
                return 1;
            }
            return 2;
        }
    }



    private int cardsType(List<Card> cards) {
        int[] nums = new int[20];
        for (int i = 0; i < cards.size(); i++) {
            nums[cards.get(i).getNum()]++;
        }
        List<Integer> n = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                n.add(nums[i]);
            }
        }
        if (n.size() == 4) {
            return OnePair;
        }
        return 0;
    }

}
