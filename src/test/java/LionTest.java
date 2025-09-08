package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {
    @Mock
    private Feline felineMock;

    private Lion lion;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testConstructorMale() throws Exception {
        lion = new Lion("Самец", felineMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testConstructorFemale() throws Exception {
        lion = new Lion("Самка", felineMock);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testInvalidSex() {
        try {
            new Lion("Неизвестный пол", felineMock);
            fail("Должен был выбросить исключение");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }

    @Test
    public void testGetKittens() throws Exception {
        when(felineMock.getKittens()).thenReturn(3);
        lion = new Lion("Самец", felineMock);
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        when(felineMock.getFood("Хищник"))
                .thenReturn(List.of("мясо", "птица", "рыба"));

        lion = new Lion("Самец", felineMock);
        List<String> food = lion.getFood();
        assertEquals(3, food.size());
        assertTrue(food.contains("мясо"));
    }
}