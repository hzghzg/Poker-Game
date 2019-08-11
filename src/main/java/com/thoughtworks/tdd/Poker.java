package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Poker {
    public static final String ORDERRULE = "123456789TJQKA";
    public List<Integer> getLevelListRule(Map trumpsHandleResult){
        List<Integer> levelList=new ArrayList<>();
        levelList.add(1);
        if(trumpsHandleResult.containsValue(2))
            levelList.add(2);
        return levelList;
    }
}
