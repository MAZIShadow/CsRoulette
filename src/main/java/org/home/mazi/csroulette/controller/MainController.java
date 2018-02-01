package org.home.mazi.csroulette.controller;

import org.home.mazi.csroulette.model.IMainAppModel;
import org.home.mazi.csroulette.model.RouletteResult;
import org.home.mazi.csroulette.view.MainApp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    private MainApp view;
    private IMainAppModel model;
    private RouletteResult rouletteResult;

    public MainController(MainApp view, IMainAppModel model) {
        this.model = model;
        this.view = view;
        this.view.getSpinButton().addActionListener(new SpinRouletteListener());
    }

    private class SpinRouletteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            RouletteResult randomResult = model.getRandomResult();

            if (randomResult == null) {
                return;
            }

            view.getImagePanel().setRouletteResult(randomResult);
        }
    }
}
