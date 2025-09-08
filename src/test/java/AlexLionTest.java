package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AlexLionTest {

    @Mock
    private Feline felineMock;

    private AlexLion alex;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        try {
            alex = new AlexLion(felineMock);
        } catch (Exception e) {
            fail("Constructor threw an exception: " + e.getMessage());
        }
    }


    @Test
    public void testDoesHaveMane() {
        assertTrue("У Алекса, как у самца льва, должна быть грива", alex.doesHaveMane());
    }

    @Test
    public void testGetKittens() {
        assertEquals("У Алекса не должно быть львят", 0, alex.getKittens());
    }

    // Тест: правильный список друзей
    @Test
    public void testGetFriends() {
        List<String> expectedFriends = Arrays.asList("Марти", "Глория", "Мелман");
        assertEquals("Список друзей Алекса должен соответствовать ожидаемому", expectedFriends, alex.getFriends());
    }


    @Test
    public void testGetPlaceOfLiving() {
        assertEquals("Алекс должен жить в Нью-Йоркском зоопарке", "Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void testGetFoodReturnsExpectedFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);

        List<String> actualFood = alex.getFood();

        assertEquals("Рацион Алекса должен соответствовать рациону хищника", expectedFood, actualFood);
    }

    @Test
    public void testGetFoodCallsFelineGetFoodOnce() throws Exception {

        when(felineMock.getFood("Хищник")).thenReturn(Arrays.asList("Животные"));

        alex.getFood();

        verify(felineMock, times(1)).getFood("Хищник");
    }
}