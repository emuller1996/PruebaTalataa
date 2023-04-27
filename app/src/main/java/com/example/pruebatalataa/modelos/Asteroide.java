package com.example.pruebatalataa.modelos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Asteroide {

    String id;
    String name;
    double absolute_magnitude_h;
    boolean is_potentially_hazardous_asteroid;
    boolean is_sentry_object;
    int usuario_id;


    public boolean isIs_sentry_object() {
        return is_sentry_object;
    }

    public void setIs_sentry_object(boolean is_sentry_object) {
        this.is_sentry_object = is_sentry_object;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAbsolute_magnitude_h() {
        return absolute_magnitude_h;
    }

    public void setAbsolute_magnitude_h(double absolute_magnitude_h) {
        this.absolute_magnitude_h = absolute_magnitude_h;
    }

    public boolean isIs_potentially_hazardous_asteroid() {
        return is_potentially_hazardous_asteroid;
    }

    public void setIs_potentially_hazardous_asteroid(boolean is_potentially_hazardous_asteroid) {
        this.is_potentially_hazardous_asteroid = is_potentially_hazardous_asteroid;
    }


}
