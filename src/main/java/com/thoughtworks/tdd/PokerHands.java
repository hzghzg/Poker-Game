package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class PokerHands {
    private List<String> trumps=new ArrayList<>();

    public void setTrumps(List<String> trumps) {
        this.trumps = trumps;
    }

    public List<String> getTrumps() {
        return trumps;
    }
}
