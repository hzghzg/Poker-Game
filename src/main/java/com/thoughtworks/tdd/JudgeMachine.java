package com.thoughtworks.tdd;

import javax.print.DocFlavor;
import java.util.*;
import java.util.stream.Collectors;

public class JudgeMachine {

    public String  judgeTheWinner(PokerHands player1, PokerHands player2) {
        Poker poker=new Poker();
        String orderRule=Poker.ORDERRULE;
        List<String> trumps1=player1.getTrumps();
        List<String> trumps2=player2.getTrumps();
        Map countTrump1SameNumResult=new HashMap();
        Map countTrump2SameNumResult=new HashMap();
        //对牌组进行同数字计数
        CountTrumpSameNum(trumps1,countTrump1SameNumResult);
        CountTrumpSameNum(trumps2,countTrump2SameNumResult);
        List<Integer> trumps1Level=new ArrayList<>();
        List<Integer> trumps2Level=new ArrayList<>();
        //得出牌组拥有的等级
        trumps1Level=poker.getLevelListRule(countTrump1SameNumResult);
        trumps2Level=poker.getLevelListRule(countTrump2SameNumResult);
        return compareResult(trumps1Level,trumps2Level,trumps1,trumps2);

    }

    private String compareResult(List<Integer> trumps1Level, List<Integer> trumps2Level,List<String> trumps1,List<String> trumps2) {
        trumps1Level=trumps1Level.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        trumps2Level=trumps2Level.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for (int i = 0; i < trumps1Level.size(); i++) {
            if(trumps1Level.get(i)!=trumps2Level.get(i))//能通过等级直接判断出
                return trumps1Level.get(i)>trumps2Level.get(i)?"Player1 win!":"Player2 win!";
            if(trumps1Level.get(i)==1)//等级相等且等级为1，直接比大小
                return compareHighCard(trumps1,trumps2);
        }
        return null;
    }

    private String compareHighCard(List<String> trumps1,List<String> trumps2) {
        List<Integer> trumps1ToIntegerList= covertTrumpsToIntegerList(trumps1);
        List<Integer> trumps2ToIntegerList= covertTrumpsToIntegerList(trumps2);
        for (int i = 0; i <trumps1ToIntegerList.size() ; i++) {
            if(trumps1ToIntegerList.get(i)!=trumps2ToIntegerList.get(i))
                return trumps1ToIntegerList.get(i)>trumps2ToIntegerList.get(i)?"Player1 win!":"Player2 win!";
            if(i==trumps1ToIntegerList.size()-1)
                return "Game draw!";
        }
        return null;
    }

    private List<Integer> covertTrumpsToIntegerList(List<String> trumps) {
        return trumps.stream().map(currentValue -> Poker.ORDERRULE.indexOf(currentValue.charAt(0)) + 1)
                .collect(Collectors.toList())
                .stream().sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    private void CountTrumpSameNum(List<String> trumps,Map countTrumpSameNumResult ) {
        for (int i = 0; i <trumps.size() ; i++) {
            if(trumps.get(i)!="0"){
                char currentPokerNum=trumps.get(i).charAt(0);
                int count=trumps.stream().filter(currentValue->currentPokerNum==currentValue.charAt(0))
                        .collect(Collectors.toList()).size();
                trumps=trumps.stream().map(currentValue->{
                    if(currentValue.charAt(0)==currentPokerNum)
                        return currentValue="0";
                    return currentValue;
                }).collect(Collectors.toList());
                countTrumpSameNumResult.put(currentPokerNum,count);
            }
        }
    }
}
