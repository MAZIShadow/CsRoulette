package org.home.mazi.csroulette.model;

import org.home.mazi.csroulette.repository.IRouletteResultRepository;
import java.util.ArrayList;
import java.util.Random;

public class MainAppModel implements IMainAppModel {

    private IRouletteResultRepository repository;
    private ArrayList<RouletteResult> events;

    public MainAppModel(IRouletteResultRepository rouletteResultRepository) {
        repository = rouletteResultRepository;
        events = repository.getDataItems();
    }

    @Override
    public RouletteResult getRandomResult() {

        if (events.size() <= 0) {
            return null;
        }

        Random r = new Random();
        int index = r.nextInt(events.size());

        return events.size() >= index ? null : events.get(index);
    }
}
