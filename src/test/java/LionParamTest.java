package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;  // Добавляем импорт Collection

@RunWith(Parameterized.class)
public class LionParamTest {
    @Mock
    private Feline felineMock;
    private Lion lion;
    private String sex;
    private boolean expectedMane;

    public LionParamTest(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        lion = new Lion(sex, felineMock);
    }

    @Parameters
    public static Collection<Object[]> data() {  // Исправляем Object на Object[]
        return Arrays.asList(new Object[][]{
                {"самец", true},
                {"самка", false}
        });
    }

    @org.junit.Test
    public void testConstructor() {
        Assert.assertEquals(expectedMane, lion.doesHaveMane());
    }
}

