package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FelineParamTest {
    private Feline feline;
    private int expectedKittens;

    public FelineParamTest(int expectedKittens) {
        this.expectedKittens = expectedKittens;
    }

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1},
                {2},
                {3},
                {4}
        });
    }

    @org.junit.Test
    public void testKittensWithCount() {
        Assert.assertEquals(expectedKittens, feline.getKittens(expectedKittens));
    }
}
