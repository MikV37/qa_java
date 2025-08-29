package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
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
    public void testConstructorMale() {
        lion = new Lion("самец", felineMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testConstructorFemale() {
        lion = new Lion("самка", felineMock);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testInvalidSex() {
        try {
            new Lion("неизвестный пол", felineMock);
            fail("Должен был выбросить исключение");
        } catch (IllegalArgumentException e) {
            // ожидаемое поведение
        }
    }

    @Test
    public void testNullSex() {
        try {
            new Lion(null, felineMock);
            fail("Должен был выбросить исключение");
        } catch (NullPointerException e) {
            // ожидаемое поведение
        }
    }

    @Test
    public void testNullFeline() {
        try {
            new Lion("самец", null);
            fail("Должен был выбросить исключение");
        } catch (NullPointerException e) {
            // ожидаемое поведение
        }
    }

    @Test
    public void testGetKittens() {
        when(felineMock.getKittens()).thenReturn(3);
        lion = new Lion("самец", felineMock);
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        when(felineMock.getFood("Хищник"))
                .thenReturn(List.of("мясо", "птица", "рыба"));

        lion = new Lion("самец", felineMock);
        List<String> food = lion.getFood();
        assertEquals(3, food.size());
        assertTrue(food.contains("мясо"));
    }
}

