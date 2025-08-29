package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {
        // Создаем экземпляр Feline без лишних моков
        feline = new Feline();
    }

    @Test
    public void testGetFamily() {
        // Проверяем, что метод возвращает правильное семейство
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testEatMeat() throws Exception {
        // Проверяем, что метод возвращает правильный список еды
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();

        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testGetKittensDefault() {
        // Проверяем значение по умолчанию для котят
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithCount() {
        // Проверяем, что метод корректно возвращает переданное количество котят
        int kittensCount = 3;
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}
