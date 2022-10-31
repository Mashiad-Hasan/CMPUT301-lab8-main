package com.example.cmput301_lab8_main;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;


    @Test
    public void addCityTest(){
        list = new CustomList(null, new ArrayList<City>());
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize+1);
    }

    @Test
    public void hasCityTest(){
        list = new CustomList(null, new ArrayList<City>());
        list.addCity(new City("Kelowna", "BC"));
        int listSize = list.getCount();
        City city = list.getCity(listSize -1);
        boolean ans = list.hasCity(city);
        assertTrue(ans);

    }

    @Test
    public void deleteCityTest() throws Exception {

        CustomList list = new CustomList(null, new ArrayList<City>());

        City city = new City("Kamloops", "BC");
        try {
            list.deleteCity(city);
        } catch (Exception e) {
            assertEquals("City not in the list", e.getMessage());
        }

        list.addCity(new City("Kelowna", "BC"));
        int listSize = list.getCount();
        city = list.getCity(listSize -1);
        list.deleteCity(city);
        assertEquals(list.getCount(), 0);
    }
}