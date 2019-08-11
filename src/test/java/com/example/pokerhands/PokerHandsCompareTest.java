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

        firstPlayer = addCards(firstPlayer, "3d");
        firstPlayer = addCards(firstPlayer, "2h");

        secondPlayer = addCards(secondPlayer, "5s");
        secondPlayer = addCards(secondPlayer, "9c");
        assertEquals(2, pokerHandsCompare.getWinner(firstPlayer, secondPlayer));
    }
}