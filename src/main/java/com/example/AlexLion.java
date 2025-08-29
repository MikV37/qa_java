package com.example;

import java.util.Arrays;
import java.util.List;

public class AlexLion extends Lion {
    // Друзья Алекса
    private static final List<String> FRIENDS = Arrays.asList("Марти", "Глория", "Мелман");
    private static final String PLACE_OF_LIVING = "Нью-Йоркский зоопарк";

    public AlexLion(Feline feline) {

        super("самец", feline);
    }


    public List<String> getFriends() {
        return FRIENDS;
    }


    public String getPlaceOfLiving() {
        return PLACE_OF_LIVING;
    }

    @Override
    public int getKittens() {
        return 0;
    }
}
