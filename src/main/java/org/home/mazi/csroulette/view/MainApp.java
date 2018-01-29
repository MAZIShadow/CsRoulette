package org.home.mazi.csroulette.view;

import org.home.mazi.csroulette.model.IMainAppModel;

import javax.swing.*;

public class MainApp extends JFrame {
    private JButton btnSpin;
    private JPanel mainPanel;
    private JImagePanel imagePanel;

    private void prepareFrame() {
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public MainApp(IMainAppModel model)  {
        super("CsRoulette App");
        prepareFrame();
    }

    public JButton getSpinButton() {
        return btnSpin;
    }

    public JImagePanel getImagePanel() {
        return imagePanel;
    }
}
