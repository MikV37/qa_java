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
        alex = new AlexLion(felineMock);
    }

    // Тесты базовых характеристик
    @Test
    public void testBasicCharacteristics() {
        assertTrue(alex.doesHaveMane()); // Алекс - самец, должен иметь гриву
        assertEquals(0, alex.getKittens()); // У Алекса нет котят
    }

    // Тест друзей
    @Test
    public void testFriends() {
        List<String> expectedFriends = Arrays.asList("Марти", "Глория", "Мелман");
        assertEquals(expectedFriends, alex.getFriends());
    }

    // Тест места проживания
    @Test
    public void testPlaceOfLiving() {
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    // Тесты с моками Feline
    @Test
    public void testGetFood() throws Exception {
        when(felineMock.getFood("Хищник"))
                .thenReturn(Arrays.asList("мясо", "рыба", "птица"));

        List<String> food = alex.getFood();
        assertEquals(3, food.size());
        assertTrue(food.contains("мясо"));
    }

    // Тест обработки исключений
    @Test(expected = NullPointerException.class)
    public void testNullFeline() {
        new AlexLion(null);
    }

    // Тест переопределенного метода getKittens
    @Test
    public void testGetKittensOverride() {
        // Проверяем, что переопределенный метод всегда возвращает 0
        assertEquals(0, alex.getKittens());

        // Проверяем, что метод родителя не вызывается
        verify(felineMock, never()).getKittens();
    }

    // Тест создания объекта
    @Test
    public void testConstructor() {
        assertNotNull(alex);
        assertTrue(alex instanceof Lion);
        assertTrue(alex instanceof AlexLion);
    }
}
