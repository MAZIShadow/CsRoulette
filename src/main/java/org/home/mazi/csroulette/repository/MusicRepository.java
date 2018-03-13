package org.home.mazi.csroulette.repository;

import javazoom.jl.player.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MusicRepository {

    public void playSound() {

        Thread t = new Thread(() -> {
            try (InputStream inputStream = ResourcesRepository.Instance.getInputStreamForResourceName("GameShowWheelSpin.mp3")) {
                Player p = new Player(inputStream);
                p.play();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        t.start();
    }

    public void playMp3(String path) {

        if (!new File(path).exists()) {
            return;
        }

        Thread t = new Thread(() -> {
            try (InputStream inputStream = new FileInputStream(path)) {
                Player p = new Player(inputStream);
                p.play();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        t.start();
    }
}
