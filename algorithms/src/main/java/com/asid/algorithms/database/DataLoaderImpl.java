package com.asid.algorithms.database;


import com.asid.algorithms.entity.Airline;
import com.asid.algorithms.entity.Airport;
import com.asid.algorithms.entity.Route;
import com.asid.foundation.datastructure.list.CustomArrayList;
import com.asid.foundation.datastructure.list.CustomLinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class DataLoaderImpl implements DataLoader {
    @Override
    public void loadAirports(String pathToFile) {
        try{
            CustomLinkedList<Airport> list = new CustomLinkedList<>();
            InmemmoryDataBase.getInstance().setAirports(list);
            Scanner scanner = new Scanner(new File(pathToFile), "Cp852");

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
            CustomLinkedList<Airline> list = new CustomLinkedList<>();
            InmemmoryDataBase.getInstance().setAirlines(list);
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
        if (!InmemmoryDataBase.getInstance().getAirlines().isEmpty()  &&
                !InmemmoryDataBase.getInstance().getAirports().isEmpty()) {
            try {

                InmemmoryDataBase.getInstance().setRoutes(new CustomArrayList<>());
                Scanner scanner = new Scanner(new File(pathToFile));

                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    String name1 = null;
                    if (line.startsWith("#")) {
                        continue;
                    }
                    for (Airline o : InmemmoryDataBase.getInstance().getAirlines()) {
                        if (o.getCode().equals(line.substring(0, 2))) {
                            name1 = o.getName();
                        }
                    }

                    Airline airline = new Airline(line.substring(0, 2), name1);

                    double a1 = 0;
                    double a2 = 0;
                    String a3 = null;
                    for (Airport o : InmemmoryDataBase.getInstance().getAirports()) {
                        if (o.getIataCode().equals(line.substring(3, 6))) {
                            a1 = o.getLatitude();
                            a2 = o.getLongitude();
                            a3 = o.getName();
                            break;
                        }
                    }
                    Airport airport1 = new Airport(line.substring(3, 6), a1, a2, a3);

                    double a4 = 0;
                    double a5 = 0;
                    String a6 = null;
                    for (Airport o : InmemmoryDataBase.getInstance().getAirports()) {
                        if (o.getIataCode().equals(line.substring(7, 10))) {
                            a4 = o.getLatitude();
                            a5 = o.getLongitude();
                            a6 = o.getName();
                            break;
                        }
                    }
                    Airport airport2 = new Airport(line.substring(7, 10), a4, a5, a6);

                    Route route = new Route(airline, airport1, airport2);
                    int q = 0;
                    for(Route r : InmemmoryDataBase.getInstance().getRoutes()){
                        if (r.equals(route)){
                            q=1;
                            break;
                        }
                    }
                    if(q == 0) {
                        InmemmoryDataBase.getInstance().appendRoutes(route);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }
    }

    @Override
    public void loadAllData(String pathToAirportsFile, String pathToAirlinesFile, String pathToRoutesFile) {
        loadAirports(pathToAirportsFile);
        loadAirline(pathToAirlinesFile);
        loadRoute(pathToRoutesFile);
    }
}
