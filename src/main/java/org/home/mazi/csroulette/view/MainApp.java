package org.home.mazi.csroulette.view;

import org.home.mazi.csroulette.model.IMainAppModel;

import javax.swing.*;

public class MainApp extends JFrame {
    private JButton btnSpin;
    private JPanel mainPanel;
    private JRouletteResultPanel imagePanel;
    private IMainAppModel model;

    private void prepareFrame() {
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        btnSpin.setEnabled(!model.IsEventsEmpty());
    }

    public MainApp(IMainAppModel model)  {
        super("CsRoulette App");
        this.model = model;
        prepareFrame();
    }

    public JButton getSpinButton() {
        return btnSpin;
    }

    public JRouletteResultPanel getImagePanel() {
        return imagePanel;
    }
}
