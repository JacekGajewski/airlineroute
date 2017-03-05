package com.asid.algorithms.database;

public class DataLoaderImpl implements DataLoader {
    @Override
    public void loadAirports(String pathToFile) {
         /* (TODO Lab No. 1) Please introduce a sensible implementation */
    }

    @Override
    public void loadAirline(String pathToFile) {
         /* (TODO Lab No. 1) Please introduce a sensible implementation */
    }

    @Override
    public void loadRoute(String pathToFile) {
         /* (TODO Lab No. 1) Please introduce a sensible implementation */
    }

    @Override
    public void loadAllData(String pathToAirportsFile, String pathToAirlinesFile, String pathToRoutesFile) {
        loadAirports(pathToAirportsFile);
        loadAirline(pathToAirlinesFile);
        loadRoute(pathToRoutesFile);
    }
}
