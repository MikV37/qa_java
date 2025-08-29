package com.example;

import java.util.List;

    public class Lion {
        private final boolean hasMane;
        private final Feline feline;

        public Lion(String sex, Feline feline) {
            if (sex == null) {
                throw new NullPointerException("Пол не может быть null");
            }
            if (feline == null) {
                throw new NullPointerException("Feline не может быть null");
            }

            this.feline = feline;

            if ("самец".equalsIgnoreCase(sex)) {
                hasMane = true;
            } else if ("самка".equalsIgnoreCase(sex)) {
                hasMane = false;
            } else {
                throw new IllegalArgumentException("Используйте допустимые значения пола животного - самец или самка");
            }
        }

        public int getKittens() {
            return feline.getKittens();
        }

        public boolean doesHaveMane() {
            return hasMane;
        }

        public List<String> getFood() throws Exception {
            return feline.getFood("Хищник");
        }
    }

