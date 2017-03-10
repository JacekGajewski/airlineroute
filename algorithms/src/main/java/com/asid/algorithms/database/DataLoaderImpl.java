package com.asid.algorithms.database;


import com.asid.algorithms.entity.Airline;
import com.asid.algorithms.entity.Airport;
import com.asid.algorithms.entity.Route;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataLoaderImpl implements DataLoader {
    @Override
    public void loadAirports(String pathToFile) {
        try{

            Scanner scanner = new Scanner(new File(pathToFile));
            scanner.nextLine();
            while(scanner.hasNext()){

                Airport airport = new Airport(scanner.next(), scanner.nextDouble(),scanner.nextDouble(), scanner.next());
                InmemmoryDataBase.getInstance().appendAirport(airport);

            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }

    }

    @Override
    public void loadAirline(String pathToFile){
        try{

            Scanner scanner = new Scanner(new File(pathToFile));
            scanner.nextLine();
            while(scanner.hasNext()){
                Airline airline = new Airline(scanner.next(), scanner.next());
                InmemmoryDataBase.getInstance().appendAirline(airline);

            }
        }
         catch(FileNotFoundException e){
             System.out.println("File not found");
         }
    }

    @Override
    public void loadRoute(String pathToFile) { //????
        try{

            Scanner scanner = new Scanner(new File(pathToFile));
            scanner.nextLine();
            scanner.nextLine();
            while(scanner.hasNext()){
                Route route = new Route();
                InmemmoryDataBase.getInstance().appendRoutes(route);

            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }


    @Override
    public void loadAllData(String pathToAirportsFile, String pathToAirlinesFile, String pathToRoutesFile) {
        loadAirports(pathToAirportsFile);
        loadAirline(pathToAirlinesFile);
        loadRoute(pathToRoutesFile);
    }
}
