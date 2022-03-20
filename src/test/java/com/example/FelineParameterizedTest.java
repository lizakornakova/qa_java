package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
//Класс для тестирования класса Feline, где требуется параметризация
//Параметризация для проверки разного количества котят
@RunWith(Parameterized.class)
public class FelineParameterizedTest {
    private final int inputNumber;
    private final int expectedNumber;

    public FelineParameterizedTest(int inputNumber, int expectedNumber) {
        this.inputNumber = inputNumber;
        this.expectedNumber = expectedNumber;
    }

    @Parameterized.Parameters
    public static Object[][] getKittensNumber() {
        return new Object[][] {
                { 1, 1},
                { 0, 0},
                {5, 5},
                {20, 20}
        };
    }
    @Test
    // Проверяем, что getKittens(int) возвращает то же число, что ему было отдано
    public void getKittensWithArgumentTest(){
        Feline felineTest = new Feline();
        int actualNum = felineTest.getKittens(inputNumber);
        Assert.assertEquals(actualNum, expectedNumber);
    }


}
