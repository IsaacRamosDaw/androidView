package com.example.tareavistas;

public class Deporte {
    // ⚠️ Se recomienda hacerlos private y usar Getters
    private final String name;
    private final String description;

    public Deporte(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

//    public int getImage() {
//        return image;
//    }
}
