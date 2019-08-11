package com.thoughtworks.tdd;

import javax.print.DocFlavor;
import java.util.List;

public class JudgeMachine {
    public String  judgeTheWinner(PokerHands player1, PokerHands player2) {
        String orderRule=Poker.ORDERRULE;
        List<String> trumps1=player1.getTrumps();
        List<String> trumps2=player2.getTrumps();
        if(orderRule.indexOf(trumps1.get(0).charAt(0))==orderRule.indexOf(trumps2.get(0).charAt(0))) return "Game draw!";
        return orderRule.indexOf(trumps1.get(0).charAt(0))>orderRule.indexOf(trumps2.get(0).charAt(0))?"Player1 win!":"Player2 win!";
    }
}
