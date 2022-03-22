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

    final String TEXT_OF_EXCEPTION = "Используйте допустимые значения пола животного - самей или самка";
    final String LION_SEX = "Неизвестный гендер";

    @Test
    //Проверяем, что getFood() возвращает верный список
    public void getFoodTestForLion() throws Exception{
        Lion lion = new Lion ("Самец", feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
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

    @Test
    // Проверяем, что при передаче в конструктор Lion некорректного названия пола возникает исключение
    public void lionConstructorExceptionTest() {
        try {
            Lion lion = new Lion(LION_SEX, feline);
            Assert.fail("Исключение не отработало");
        } catch (Exception thrown) {
            Assert.assertEquals(TEXT_OF_EXCEPTION, thrown.getMessage());
        }
    }
}
