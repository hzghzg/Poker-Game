package com.thoughtworks.tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JudgeMachineTest {

    @Test
    void shouldReturnPlayer2Win_whenJudgeTheWinner_givenPlayer1Trumps2HAndPlayer2Trumps3D() {
        List<String> trumps1= Arrays.asList("2H");
        PokerHands player1=new PokerHands();
        player1.setTrumps(trumps1);
        List<String> trumps2= Arrays.asList("3D");
        PokerHands player2=new PokerHands();
        player2.setTrumps(trumps2);
        JudgeMachine judgeMachine=new JudgeMachine();
        String winnerMessage=judgeMachine.judgeTheWinner(player1,player2);
        assertEquals("Player2 win!",winnerMessage);
    }

    @Test
    void shouldReturnGameDraw_whenJudgeTheWinner_givenPlayer1TrumpsKCAndPlayer2TrumpsKD() {
        List<String> trumps1= Arrays.asList("KC");
        PokerHands player1=new PokerHands();
        player1.setTrumps(trumps1);
        List<String> trumps2= Arrays.asList("KD");
        PokerHands player2=new PokerHands();
        player2.setTrumps(trumps2);
        JudgeMachine judgeMachine=new JudgeMachine();
        String winnerMessage=judgeMachine.judgeTheWinner(player1,player2);
        assertEquals("Game draw!",winnerMessage);
    }

    @Test
    void shouldReturnPlayer1Win_whenJudgeTheWinner_givenPlayer1Trumps3H3DAndPlayer2TrumpsKDAC() {
        List<String> trumps1= Arrays.asList("3H","3D");
        PokerHands player1=new PokerHands();
        player1.setTrumps(trumps1);
        List<String> trumps2= Arrays.asList("KD","AC");
        PokerHands player2=new PokerHands();
        player2.setTrumps(trumps2);
        JudgeMachine judgeMachine=new JudgeMachine();
        String winnerMessage=judgeMachine.judgeTheWinner(player1,player2);
        assertEquals("Player1 win!",winnerMessage);
    }

    @Test
    void shouldReturnPlayer2win_whenJudgeTheWinner_givenPlayer1Trumps3H3D6DAndPlayer2Trumps5S5C2C() {
        List<String> trumps1= Arrays.asList("3H","3D","6D");
        PokerHands player1=new PokerHands();
        player1.setTrumps(trumps1);
        List<String> trumps2= Arrays.asList("5S","5C","2C");
        PokerHands player2=new PokerHands();
        player2.setTrumps(trumps2);
        JudgeMachine judgeMachine=new JudgeMachine();
        String winnerMessage=judgeMachine.judgeTheWinner(player1,player2);
        assertEquals("Player2 win!",winnerMessage);
    }

    @Test
    void shouldReturnPlayer2Win_whenJudgeTheWinner_givenPlayer1TrumpsKHKD3D5CACAndPlayer2Trumps2S2C3H3D4C() {
        List<String> trumps1= Arrays.asList("KH","KD","3D","5C","AC");
        PokerHands player1=new PokerHands();
        player1.setTrumps(trumps1);
        List<String> trumps2= Arrays.asList("2S","2C","3H","3D","4C");
        PokerHands player2=new PokerHands();
        player2.setTrumps(trumps2);
        JudgeMachine judgeMachine=new JudgeMachine();
        String winnerMessage=judgeMachine.judgeTheWinner(player1,player2);
        assertEquals("Player2 win!",winnerMessage);
    }

    @Test
    void shouldReturnPlayer1Win_whenJudgeTheWinner_givenPlayer1Trumps2H2D2D5C6CAndPlayer2TrumpsKSKCJHJDAC() {
        List<String> trumps1= Arrays.asList("2H","2D","2D","5C","6C");
        PokerHands player1=new PokerHands();
        player1.setTrumps(trumps1);
        List<String> trumps2= Arrays.asList("KS","KC","JH","JD","AC");
        PokerHands player2=new PokerHands();
        player2.setTrumps(trumps2);
        JudgeMachine judgeMachine=new JudgeMachine();
        String winnerMessage=judgeMachine.judgeTheWinner(player1,player2);
        assertEquals("Player1 win!",winnerMessage);
    }

    @Test
    void shouldReturnPlayer1Win_whenJudgeTheWinner_givenPlayer1Trumps4H4D4D5C6CAndPlayer2Trumps3S3C3HJDAC() {
        List<String> trumps1= Arrays.asList("4H","4D","4D","5C","6C");
        PokerHands player1=new PokerHands();
        player1.setTrumps(trumps1);
        List<String> trumps2= Arrays.asList("3S","3C","3H","JD","AC");
        PokerHands player2=new PokerHands();
        player2.setTrumps(trumps2);
        JudgeMachine judgeMachine=new JudgeMachine();
        String winnerMessage=judgeMachine.judgeTheWinner(player1,player2);
        assertEquals("Player1 win!",winnerMessage);
    }

    @Test
    void shouldReturnPlayer2Win_whenJudgeTheWinner_givenPlayer1TrumpsKHKDKDACJCAndPlayer2Trumps3S4C5H6D7C() {
        List<String> trumps1= Arrays.asList("KH","KD","KD","AC","JC");
        PokerHands player1=new PokerHands();
        player1.setTrumps(trumps1);
        List<String> trumps2= Arrays.asList("3S","4C","5H","6D","7C");
        PokerHands player2=new PokerHands();
        player2.setTrumps(trumps2);
        JudgeMachine judgeMachine=new JudgeMachine();
        String winnerMessage=judgeMachine.judgeTheWinner(player1,player2);
        assertEquals("Player2 win!",winnerMessage);
    }
}