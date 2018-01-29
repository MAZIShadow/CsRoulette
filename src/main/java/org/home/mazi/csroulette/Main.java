package org.home.mazi.csroulette;


import org.home.mazi.csroulette.controller.MainController;
import org.home.mazi.csroulette.model.IMainAppModel;
import org.home.mazi.csroulette.model.MainAppModel;
import org.home.mazi.csroulette.view.MainApp;

public class Main {

    public static void main(String[] args) {
        IMainAppModel model = new MainAppModel();
        MainApp view = new MainApp(model);
        MainController controller = new MainController(view, model);
    }
}
