package com.example.pokerhands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokerHandsCompare {

    public static final int OnePair = 2;
    public static final int TwoPair = 3;
    public static final int ThreeOfAKind = 4;

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
            int[] nums1 = new int[15];
            int[] nums2 = new int[15];
            Arrays.fill(nums1, 0);
            Arrays.fill(nums2, 0);
            for (int i = 0; i < firstPlayer.size(); i++) {
                nums1[firstPlayer.get(i).getNum()]++;
                nums2[secondPlayer.get(i).getNum()]++;
            }
            int result1 = 0;
            int result2 = 0;
            for (int i = 0; i < 15; i++) {
                result1 += Math.pow(i * i, nums1[i]);
                result2 += Math.pow(i * i, nums2[i]);
            }
            if (result1 > result2) {
                return 1;
            } else if (result2 > result1) {
                return 2;
            } else {
                return 0;
            }
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
        } else if (n.size() == 3 && n.contains(2)) {
            return TwoPair;
        } else if (n.size() == 3 && n.contains(3)) {
            return ThreeOfAKind;
        }
        return 0;
    }

}
