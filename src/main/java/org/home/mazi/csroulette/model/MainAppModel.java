package org.home.mazi.csroulette.model;

import java.util.ArrayList;
import java.util.Random;

public class MainAppModel implements IMainAppModel {

    private ArrayList<RouletteResult> events;

    public MainAppModel() {
        events = new ArrayList<>();
    }

    @Override
    public RouletteResult getRandomResult() {

        Random r = new Random();
        int index = r.nextInt(events.size());

        return events.get(index);
    }
}
