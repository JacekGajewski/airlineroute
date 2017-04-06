package com.aisd.apps.sorting;

import com.asid.algorithms.database.DataLoader;
import com.asid.algorithms.database.DataLoaderImpl;
import com.asid.algorithms.database.InmemmoryDataBase;
import com.asid.algorithms.entity.Route;
import com.asid.algorithms.mapper.RouteMapper;
import com.asid.algorithms.sorting.*;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * Sorting algorithms performance test.
 */
public class SortingAlgorithmComparison {

    public static void main(String[] args) {

        Comparator<Route> comparator = getComparator();
        List<Route> list1 = getTarget();

        InsertionSortService insertionSortService = new InsertionSortService();
        SortResultDs sortResultDs = insertionSortService.sort(list1, comparator);
        System.out.println("InsertSort: " + sortResultDs.getEstimatedTime());


        List<Route> list2 = getTarget();

        SelectionSortService selectionSortService = new SelectionSortService();
        SortResultDs selectionSort = selectionSortService.sort(list2, comparator);
        System.out.println("SelectionSort: " + selectionSort.getEstimatedTime());

        List<Route> list5 = getTarget();

        MergeSortService mergeSortService = new MergeSortService();
        SortResultDs mergeSort = mergeSortService.sort(list5, comparator);
        System.out.println("MergeSort: " + mergeSort.getEstimatedTime());

        List<Route> list6 = getTarget();

        QuickSortService quickSortService = new QuickSortService();
        SortResultDs quickSort = quickSortService.sort(list6, comparator);
        System.out.println("QuickSort: " + quickSort.getEstimatedTime());

        List<Route> list7 = getTarget();

        HeapSortService heapSortService = new HeapSortService();
        SortResultDs heapSort = heapSortService.sort(list7, comparator);
        System.out.println("HeapSort: " + heapSort.getEstimatedTime());


        List<Route> list3 = getTarget();
        Collections.sort(list3, getComparator());
        System.out.println("POSORTOWANE OPTYMISTYCZNIE");

        SortResultDs sortResultDs3 = insertionSortService.sort(list3, comparator);
        System.out.println("InsertSort: " + sortResultDs3.getEstimatedTime());
        SortResultDs mergeSort3 = mergeSortService.sort(list3, comparator);
        System.out.println("MergeSort: " + mergeSort3.getEstimatedTime());
        SortResultDs quickSort3 = quickSortService.sort(list3, comparator);
        System.out.println("QuickSort: " + quickSort3.getEstimatedTime());
        SortResultDs heapSort3 = heapSortService.sort(list3, comparator);
        System.out.println("HeapSort: " + heapSort3.getEstimatedTime());
        SortResultDs selectionSort3 = selectionSortService.sort(list3, comparator);
        System.out.println("SelectionSort: " + selectionSort3.getEstimatedTime());

        List<Route> list4 = getTarget();
        Collections.sort(list4, getComparatorReverse());
        System.out.println("POSORTOWANE PESYMISTYCZNIE");

        SortResultDs sortResultDs4 = insertionSortService.sort(list4, comparator);
        System.out.println("InsertSort: " + sortResultDs4.getEstimatedTime());
        SortResultDs mergeSort4 = mergeSortService.sort(list4, comparator);
        System.out.println("MergeSort: " + mergeSort4.getEstimatedTime());
        SortResultDs quickSort4 = quickSortService.sort(list4, comparator);
        System.out.println("QuickSort: " + quickSort4.getEstimatedTime());
        SortResultDs heapSort4 = heapSortService.sort(list4, comparator);
        System.out.println("HeapSort: " + heapSort4.getEstimatedTime());
        SortResultDs selectionSort4 = selectionSortService.sort(list4, comparator);
        System.out.println("SelectionSort: " + selectionSort4.getEstimatedTime());

    }
    public static List<Route> getTarget(){

        DataLoader loader = new DataLoaderImpl();

        loader.loadAllData("/home/tnt9/Downloads/airlineroute/algorithms/resources/airports.dat",
                "/home/tnt9/Downloads/airlineroute/algorithms/resources/airlines.dat",
                "/home/tnt9/Downloads/airlineroute/algorithms/resources/routes.dat");

        RouteMapper routeMapper = new RouteMapper();
        List<Route> target = new LinkedList<>();

        routeMapper.toRoutes(InmemmoryDataBase.getInstance().getRoutes(), target); // Nie ładuje ostatniego

        return target;
    }

    public static Comparator<Route> getComparator(){
        Comparator<Route> comparator = new Comparator<Route>() {
            @Override
            public int compare(Route o1, Route o2) {
                if(Math.sqrt(Math.pow((o1.getOrigin().getLongitude() - o1.getDestination().getLongitude()), 2) +
                        Math.pow((o1.getOrigin().getLatitude() - o1.getDestination().getLatitude()), 2)) >
                        Math.sqrt(Math.pow((o2.getOrigin().getLongitude() - o2.getDestination().getLongitude()), 2) +
                                Math.pow((o2.getOrigin().getLatitude() - o2.getDestination().getLatitude()), 2))) {
                    return 1;
                }else if(Math.sqrt(Math.pow((o1.getOrigin().getLongitude() - o1.getDestination().getLongitude()), 2) +
                        Math.pow((o1.getOrigin().getLatitude() - o1.getDestination().getLatitude()), 2)) <
                        Math.sqrt(Math.pow((o2.getOrigin().getLongitude() - o2.getDestination().getLongitude()), 2) +
                                Math.pow((o2.getOrigin().getLatitude() - o2.getDestination().getLatitude()), 2))){
                    return -1;
                }
                return 0;
            }
        };

        return comparator;
    }
    public static Comparator<Route> getComparatorReverse(){
        Comparator<Route> comparator = new Comparator<Route>() {
            @Override
            public int compare(Route o1, Route o2) {
                if(Math.sqrt(Math.pow((o1.getOrigin().getLongitude() - o1.getDestination().getLongitude()), 2) +
                        Math.pow((o1.getOrigin().getLatitude() - o1.getDestination().getLatitude()), 2)) >
                        Math.sqrt(Math.pow((o2.getOrigin().getLongitude() - o2.getDestination().getLongitude()), 2) +
                                Math.pow((o2.getOrigin().getLatitude() - o2.getDestination().getLatitude()), 2))) {
                    return -1;
                }else if(Math.sqrt(Math.pow((o1.getOrigin().getLongitude() - o1.getDestination().getLongitude()), 2) +
                        Math.pow((o1.getOrigin().getLatitude() - o1.getDestination().getLatitude()), 2)) <
                        Math.sqrt(Math.pow((o2.getOrigin().getLongitude() - o2.getDestination().getLongitude()), 2) +
                                Math.pow((o2.getOrigin().getLatitude() - o2.getDestination().getLatitude()), 2))){
                    return 1;
                }
                return 0;
            }
        };

        return comparator;
    }
    public static Comparator<Route> newComparator(){
        Comparator<Route> comparator = new Comparator<Route>() {
            @Override
            public int compare(Route o1, Route o2) {
                if(o1.getOrigin().getLongitude() > o2.getOrigin().getLongitude()){

                    return 1;
                }else if(o1.getOrigin().getLongitude() < o2.getOrigin().getLongitude()){
                    return -1;
                }
                return 0;
            }
        };

        return comparator;
    }
    public static Comparator<Route> newReverseComparator(){
        Comparator<Route> comparator = new Comparator<Route>() {
            @Override
            public int compare(Route o1, Route o2) {
                if(o1.getOrigin().getLongitude() > o2.getOrigin().getLongitude()){

                    return -1;
                }else if(o1.getOrigin().getLongitude() < o2.getOrigin().getLongitude()){
                    return 1;
                }
                return 0;
            }
        };

        return comparator;
    }




    public <T> List<Route> sort(List<T> list, Comparator<? super T> comparator){

        return null;
    }


}
