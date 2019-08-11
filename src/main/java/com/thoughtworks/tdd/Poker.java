package com.thoughtworks.tdd;

import java.util.*;
import java.util.stream.Collectors;

public class Poker {
    public static final String ORDERRULE = "123456789TJQKA";
    public List<Integer> getLevelListRule( List<String> trumps,Map countTrumpSameNumResult){
        List<Integer> levelList=new ArrayList<>();
        levelList.add(1);
        updateToLevelTwo(countTrumpSameNumResult, levelList);
        updateToLevelThree(countTrumpSameNumResult, levelList);
        updateToLevelFour(countTrumpSameNumResult, levelList);
        updateToLevelFive(trumps, levelList);
        updateToLevelSix(trumps, levelList);
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

    private void updateToLevelFour(Map countTrumpSameNumResult, List<Integer> levelList) {
        if(countTrumpSameNumResult.containsValue(3))
            levelList.add(4);
    }

    private void updateToLevelFive(List<String> trumps, List<Integer> levelList) {
        List<Integer> trumps1ToIntegerList=covertTrumpsToIntegerList(trumps);
        int count=0;
        for (int i = 1; i <trumps1ToIntegerList.size() ; i++) {
            if(trumps1ToIntegerList.get(i-1)-trumps1ToIntegerList.get(i)==1) count++;
        }
        if(count==4) levelList.add(5);
    }

    private void updateToLevelSix(List<String> trumps, List<Integer> levelList) {
        List<String> pokerTypeList=getTypeList(trumps);
        if(pokerTypeList.stream().filter(currentValue->currentValue.equals(pokerTypeList.get(0))).collect(Collectors.toList()).size()==5)
            levelList.add(6);
    }

    private List<String> getTypeList(List<String> trumps) {
        return trumps.stream().map(currentValue->String.valueOf(currentValue.charAt(1))).collect(Collectors.toList());
    }

    private List<Integer> covertTrumpsToIntegerList(List<String> trumps) {
        return trumps.stream().map(currentValue -> Poker.ORDERRULE.indexOf(currentValue.charAt(0)) + 1)
                .collect(Collectors.toList())
                .stream().sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
