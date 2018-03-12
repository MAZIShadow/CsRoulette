package org.home.mazi.csroulette.model;

import org.home.mazi.csroulette.repository.IRouletteResultRepository;

import java.util.ArrayList;
import java.util.Random;

public class MainAppModel implements IMainAppModel {

    private IRouletteResultRepository repository;
    private ArrayList<RouletteResult> events;
    private ArrayList<RouletteResult> drawnItems;
    private RouletteResult selectedRouletteResult;

    public MainAppModel(IRouletteResultRepository rouletteResultRepository) {
        repository = rouletteResultRepository;
        events = repository.getDataItems();
        drawnItems = new ArrayList<>();
    }

    public RouletteResult getSelectedRouletteResult() {
        return selectedRouletteResult;
    }

    @Override
    public boolean IsEventsEmpty() {
        return events.isEmpty();
    }

    @Override
    public RouletteResult getRandomResult() {

        if (events.size() <= 0 && drawnItems.size() <= 0) {
            return null;
        }

        if (drawnItems.size() > events.size() / 2 + 1) {
            events.addAll(drawnItems);
            RouletteResult stayElement = drawnItems.stream().reduce((a, b) -> b).orElse(null);
            drawnItems.clear();
            drawnItems.add(stayElement);
            events.remove(stayElement);
        }

        Random r = new Random();
        int index = r.nextInt(events.size());
        selectedRouletteResult = index >= events.size() ? null : events.get(index);

        if (selectedRouletteResult != null) {
            events.remove(selectedRouletteResult);
            drawnItems.add(selectedRouletteResult);
        }

        return selectedRouletteResult;
    }
}
