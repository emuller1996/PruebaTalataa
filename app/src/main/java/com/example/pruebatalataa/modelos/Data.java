package com.example.pruebatalataa.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Data {
    public  int element_count;
    public Map<String, List<Asteroide>> near_earth_objects  ;

    public int getElement_count() {
        return element_count;
    }

    public void setElement_count(int element_count) {
        this.element_count = element_count;
    }

    public Map<String, List<Asteroide>> getNear_earth_objects() {
        return near_earth_objects;
    }

    public void setNear_earth_objects(Map<String, List<Asteroide>> near_earth_objects) {
        this.near_earth_objects = near_earth_objects;
    }
}
