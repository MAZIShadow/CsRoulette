package org.home.mazi.csroulette.repository;

import com.google.gson.Gson;
import org.home.mazi.csroulette.model.RouletteResult;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class RouletteResultRepository implements IRouletteResultRepository {

    @Override
    public ArrayList<RouletteResult> getDataItems() {

        ArrayList<RouletteResult> list = new ArrayList<>();

        File files = new File("./data/");

        if (!files.exists() || !files.isDirectory()) {
            return list;
        }

        Arrays.stream(files.listFiles((directory, fileName) -> fileName.endsWith(".json"))).forEach(f -> {
            Gson json = new Gson();

            try (FileReader fileReader = new FileReader(f)) {

                RouletteResult rouletteResult = json.fromJson(fileReader, RouletteResult.class);
                rouletteResult.loadImage(f);
                list.add(rouletteResult);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return list;
    }
}
