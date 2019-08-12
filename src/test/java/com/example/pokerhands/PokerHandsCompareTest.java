package com.example.pokerhands;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;


public class PokerHandsCompareTest {

    PokerHandsCompare pokerHandsCompare = new PokerHandsCompare();

    private List<Card> addCards(List<Card> cards, String number) {
        Card card = new Card(number);
        cards.add(card);
        return cards;
    }

    @Test
    public void should_return_one_when_given_9c_and_5s() {
        Card firstPlayer = new Card("9c");
        Card secondPlayer = new Card("5s");
        assertEquals(1, pokerHandsCompare.getWinner(Collections.singletonList(firstPlayer), Collections.singletonList(secondPlayer)));
    }

    @Test
    public void should_return_two_when_given_2h_3d_and_5s_9c() {
        List<Card> firstPlayer = new ArrayList<>();
        List<Card> secondPlayer = new ArrayList<>();

        addCards(firstPlayer, "3d");
        addCards(firstPlayer, "2h");

        addCards(secondPlayer, "5s");
        addCards(secondPlayer, "9c");
        assertEquals(2, pokerHandsCompare.getWinner(firstPlayer, secondPlayer));
    }

    @Test
    public void should_return_one_when_given_3d_2h_5c_kc_ac_and_5s_9c_kh_6c_7h() {
        List<Card> firstPlayer = new ArrayList<>();
        List<Card> secondPlayer = new ArrayList<>();

        addCards(firstPlayer, "3d");
        addCards(firstPlayer, "2h");
        addCards(firstPlayer, "5c");
        addCards(firstPlayer, "kc");
        addCards(firstPlayer, "ac");

        addCards(secondPlayer, "5s");
        addCards(secondPlayer, "9c");
        addCards(secondPlayer, "kh");
        addCards(secondPlayer, "6c");
        addCards(secondPlayer, "7h");
        assertEquals(1, pokerHandsCompare.getWinner(firstPlayer, secondPlayer));
    }

    @Test
    public void should_return_two_when_given_5s_9c_ah_6c_7h_and_3d_3s_5c_kc_9d() {
        List<Card> firstPlayer = new ArrayList<>();
        List<Card> secondPlayer = new ArrayList<>();

        addCards(firstPlayer, "5s");
        addCards(firstPlayer, "9c");
        addCards(firstPlayer, "ah");
        addCards(firstPlayer, "6c");
        addCards(firstPlayer, "7h");

        addCards(secondPlayer, "3d");
        addCards(secondPlayer, "3s");
        addCards(secondPlayer, "5c");
        addCards(secondPlayer, "kc");
        addCards(secondPlayer, "9d");
        assertEquals(2, pokerHandsCompare.getWinner(firstPlayer, secondPlayer));
    }

    @Test
    public void should_return_one_when_given_5s_5c_th_6c_7h_and_3d_3s_5c_kc_9d() {
        List<Card> firstPlayer = new ArrayList<>();
        List<Card> secondPlayer = new ArrayList<>();

        addCards(firstPlayer, "5s");
        addCards(firstPlayer, "5c");
        addCards(firstPlayer, "th");
        addCards(firstPlayer, "6c");
        addCards(firstPlayer, "7h");

        addCards(secondPlayer, "3d");
        addCards(secondPlayer, "3s");
        addCards(secondPlayer, "5c");
        addCards(secondPlayer, "kc");
        addCards(secondPlayer, "9d");
        assertEquals(1, pokerHandsCompare.getWinner(firstPlayer, secondPlayer));
    }

    @Test
    public void should_return_two_when_given_td_ts_5s_9c_kd_and_3c_3h_8c_8h_2c() {
        List<Card> firstPlayer = new ArrayList<>();
        List<Card> secondPlayer = new ArrayList<>();

        addCards(firstPlayer, "td");
        addCards(firstPlayer, "ts");
        addCards(firstPlayer, "5s");
        addCards(firstPlayer, "9c");
        addCards(firstPlayer, "kd");

        addCards(secondPlayer, "3c");
        addCards(secondPlayer, "3h");
        addCards(secondPlayer, "8c");
        addCards(secondPlayer, "8h");
        addCards(secondPlayer, "2c");
        assertEquals(2, pokerHandsCompare.getWinner(firstPlayer, secondPlayer));
    }
}