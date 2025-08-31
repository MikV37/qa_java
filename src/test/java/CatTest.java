package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline felineMock;

    @InjectMocks
    private Cat cat;

    @Before
    public void setUp() {
        // Инициализация моков
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testPredatorInteraction() {
        try {
            cat.getFood();
            verify(felineMock).eatMeat();
        } catch (Exception e) {
            fail("Не ожидалось исключение: " + e.getMessage());
        }
    }
}

