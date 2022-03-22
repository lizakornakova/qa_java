package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
//Класс с тестированием методов класса Cat
//Используется мок, чтобы тесты не зависели от корректности работы другого класса
@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline felineTest;

    @Test
    // Проверяем, что getSound() возвращает нужное значение
    public void getSoundTestForCat() {
        Cat catTest = new Cat(felineTest);
        String expectedName = "Мяу";
        String actualName = catTest.getSound();
        Assert.assertEquals(actualName, expectedName);
    }

    @Test
    // Проверяем, что getFood() возвращает нужное значение
    public void getFoodTestForCat() throws Exception {
        Cat catTest = new Cat(felineTest);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineTest.eatMeat()).thenReturn(expected);
        List<String> actual = catTest.getFood();
        Assert.assertEquals(actual, expected);
    }
}
