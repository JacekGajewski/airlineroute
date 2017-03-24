package com.asid.algorithms.database;

/**
 * Created by tnt9 on 15.03.17.
 */
public class Main {

    public static void main(String[] args) {

        shouldReadAllData();



    }
    public static void shouldReadAllData() {
        DataLoader loader = new DataLoaderImpl();

        //loader.loadAllData("/home/tnt9/Downloads/airlineroute/algorithms/resources/airports.dat",
         //       "/home/tnt9/Downloads/airlineroute/algorithms/resources/airlines.dat",
          //      "/home/tnt9/Downloads/airlineroute/algorithms/resources/routes.dat");
        loader.loadAirports("/home/tnt9/Downloads/airlineroute/algorithms/resources/airports.dat");

        //System.out.println(InmemmoryDataBase.getInstance().getAirports().size());
    }
}
