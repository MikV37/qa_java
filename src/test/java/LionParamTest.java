package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.*;

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
        try {
            this.lion = new Lion(sex, felineMock);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @org.junit.Test
    public void testConstructor() {
        Assert.assertEquals(expectedMane, lion.doesHaveMane());
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }
}