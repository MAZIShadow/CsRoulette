package org.home.mazi.csroulette.model;

import org.home.mazi.csroulette.repository.IRouletteResultRepository;

import java.util.ArrayList;
import java.util.Random;

public class MainAppModel implements IMainAppModel {

    private IRouletteResultRepository repository;
    private ArrayList<RouletteResult> events;
    private ArrayList<RouletteResult> drawnItems;

    public MainAppModel(IRouletteResultRepository rouletteResultRepository) {
        repository = rouletteResultRepository;
        events = repository.getDataItems();
        drawnItems = new ArrayList<>();
    }

    @Override
    public RouletteResult getRandomResult() {

        if (events.size() <= 0 && drawnItems.size() <= 0) {
            return null;
        }

        if (drawnItems.size() > events.size() / 2 + 1) {
            events.addAll(drawnItems);
            drawnItems.clear();
        }

        Random r = new Random();
        int index = r.nextInt(events.size());
        RouletteResult result = index >= events.size() ? null : events.get(index);

        if (result != null) {
            events.remove(result);
            drawnItems.add(result);
        }

        return result;
    }
}
