package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
//Класс для тестирования класса Feline, где НЕ требуется параметризация
public class FelineTest {
    Feline felineTest = new Feline();

    @Test
    // Проверка, что eatMeat() возвращает нужный список
    public void eatMeatForFelineTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = felineTest.eatMeat();
        Assert.assertEquals(actual, expected);
    }

    @Test
    // Проверка, что getFamily() возвращает правильное название семьи
    public void getFamilyTest(){
        String expectedName = "Кошачьи";
        String actualName = felineTest.getFamily();
        Assert.assertEquals(actualName, expectedName);
    }

    @Test
    // Проверка, что getKittens() возвращает всегда 1, если на вход методу не подается значение
    public void getKittensNoArgumentTest(){
        int expectedNum = 1;
        int actualNum = felineTest.getKittens();
        Assert.assertEquals(actualNum, expectedNum);
    }



}
