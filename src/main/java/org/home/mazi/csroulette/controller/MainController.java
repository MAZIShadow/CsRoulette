package org.home.mazi.csroulette.controller;

import javazoom.jl.player.Player;
import org.home.mazi.csroulette.model.IMainAppModel;
import org.home.mazi.csroulette.model.RouletteResult;
import org.home.mazi.csroulette.repository.ResourcesRepository;
import org.home.mazi.csroulette.view.MainApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.List;

public class MainController {
	private MainApp view;
	private IMainAppModel model;

	public MainController(MainApp view, IMainAppModel model) {
		this.model = model;
		this.view = view;
		this.view.getSpinButton().addActionListener(new SpinRouletteListener());
	}

	private class SpinRouletteListener implements ActionListener {

		private void playSound() {

			Thread t = new Thread(() -> {
				try (FileInputStream fis = new FileInputStream(ResourcesRepository.Instance.getPathForResource("GameShowWheelSpin.mp3"))) {
					Player p = new Player(fis);
					p.play();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
			t.start();
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			SwingWorker swingWorker = new SwingWorker<RouletteResult, RouletteResult>() {
				@Override
				protected RouletteResult doInBackground() throws Exception {


					view.getSpinButton().setEnabled(false);
					RouletteResult randomResult = null;
					int sleepTime = 100;
					final int SLEEP_TIME_LIMIT = 820;
					int sleepTimeStep = 10;
					final int BEGIN_COUNT_STEP = 5;
					int count = BEGIN_COUNT_STEP;
					int countStep = 0;

					while (sleepTime <= SLEEP_TIME_LIMIT) {

						randomResult = model.getRandomResult();
						publish(randomResult);
						playSound();
						Thread.sleep(sleepTime);
						sleepTime += sleepTimeStep;

						if (count-- <= 0) {
							sleepTimeStep *= 2;
							count = BEGIN_COUNT_STEP - ++countStep;
						}

						view.getImagePanel().printDebugText(Integer.toString(sleepTime));
					}

					return randomResult;
				}

				@Override
				protected void process(List<RouletteResult> chunks) {
					super.process(chunks);

					RouletteResult rouletteResult = chunks.get(chunks.size() - 1);

					if (rouletteResult == null) {
						return;
					}


					view.getImagePanel().setRouletteResult(rouletteResult);

				}

				@Override
				protected void done() {
					super.done();
					view.getSpinButton().setEnabled(true);
					JOptionPane.showConfirmDialog(null, "New task", null, JOptionPane.PLAIN_MESSAGE);
				}
			};

			swingWorker.execute();
		}
	}
}
