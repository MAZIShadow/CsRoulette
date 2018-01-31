package org.home.mazi.csroulette.repository;

import com.google.gson.Gson;
import org.home.mazi.csroulette.model.RouletteResult;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class RouletteResultRepository implements IRouletteResultRepository {

    @Override
    public ArrayList<RouletteResult> getDataItems() {

        ArrayList<RouletteResult> list = new ArrayList<>();

        File file = new File("./data/");

        if (!file.exists() || !file.isDirectory()) {
            return list;
        }

        Arrays.stream(file.listFiles()).forEach(f -> {
            Gson json = new Gson();

            try (FileReader fileReader = new FileReader(f)) {
                list.add(json.fromJson(fileReader, RouletteResult.class));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return list;
    }
}
