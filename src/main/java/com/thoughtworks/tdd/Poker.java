package com.thoughtworks.tdd;

import java.util.*;
import java.util.stream.Collectors;

public class Poker {
    public static final String ORDERRULE = "123456789TJQKA";
    public List<Integer> getLevelListRule(Map countTrumpSameNumResult){
        List<Integer> levelList=new ArrayList<>();
        levelList.add(1);
        updateToLevelTwo(countTrumpSameNumResult, levelList);
        updateToLevelThree(countTrumpSameNumResult, levelList);
        return levelList;
    }

    private void updateToLevelTwo(Map countTrumpSameNumResult, List<Integer> levelList) {
        if(countTrumpSameNumResult.containsValue(2))
            levelList.add(2);
    }

    private void updateToLevelThree(Map countTrumpSameNumResult, List<Integer> levelList) {
        List<Integer> pokerNumCount=new ArrayList<Integer>(countTrumpSameNumResult.values());
        if(pokerNumCount.stream().filter(currentValue->currentValue==2).collect(Collectors.toList()).size()==2) levelList.add(3);
    }
}
