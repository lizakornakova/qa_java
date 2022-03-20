package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
//Класс с тестированием методов класса Lion
//Используется мок, чтобы тесты не зависели от корректности работы другого класса
@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    //Проверяем, что getFood() возвращает верный список
    public void getFoodTestForLion() throws Exception{
        Lion lion = new Lion ("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expectedFood, lion.getFood());
    }

    @Test
    //Проверяем, что getKittens() возвращает именно то количество, которое возвращает feline.getKittens()
    public void getKittensTestForLion() throws Exception{
        Lion lion = new Lion ("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedNumber = 1;
        Assert.assertEquals(expectedNumber, lion.getKittens());
    }
}
