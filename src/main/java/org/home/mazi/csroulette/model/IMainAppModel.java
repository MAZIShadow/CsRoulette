package org.home.mazi.csroulette.model;

public interface IMainAppModel {
    RouletteResult getRandomResult();
    RouletteResult getSelectedRouletteResult();
    boolean IsEventsEmpty();
}
