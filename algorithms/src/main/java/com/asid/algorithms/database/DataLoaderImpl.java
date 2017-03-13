package com.asid.algorithms.database;


import com.asid.algorithms.entity.Airline;
import com.asid.algorithms.entity.Airport;
import com.asid.algorithms.entity.Route;
import com.asid.foundation.datastructure.list.CustomArrayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataLoaderImpl implements DataLoader {
    @Override
    public void loadAirports(String pathToFile) {
        try{
            InmemmoryDataBase.getInstance().setAirports(new CustomArrayList<>());
            Scanner scanner = new Scanner(new File(pathToFile));

            while(scanner.hasNext()){
                String line = scanner.nextLine();
                if(line.startsWith("#")) {
                    continue;
                }
                String[] tempArr = line.split("\\t");
                Airport airport = new Airport(tempArr[0], Double.parseDouble(tempArr[1]), Double.parseDouble(tempArr[2]), tempArr[3]);
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
            InmemmoryDataBase.getInstance().setAirlines(new CustomArrayList<>());
            Scanner scanner = new Scanner(new File(pathToFile));

            while(scanner.hasNext()){
                String line = scanner.nextLine();
                if(line.startsWith("#")) {
                    continue;
                }
                Airline airline = new Airline(line.substring(0, 2), line.substring(3));
                InmemmoryDataBase.getInstance().appendAirline(airline);
            }
        }
         catch(FileNotFoundException e){
             System.out.println("File not found");
         }
    }

    @Override
    public void loadRoute(String pathToFile) {
        try{
            InmemmoryDataBase.getInstance().setRoutes(new CustomArrayList<>());
            Scanner scanner = new Scanner(new File(pathToFile));

            while(scanner.hasNext()){
                String line = scanner.nextLine();
                if(line.startsWith("#")) {
                    continue;
                }
                Airline airline = new Airline();
                airline.setCode(line.substring(0, 2));

                Airport airport1 = new Airport();
                airport1.setIataCode(line.substring(3, 6));

                Airport airport2 = new Airport();
                airport1.setIataCode(line.substring(7, 10));

                Route route = new Route(airline, airport1, airport2);
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
