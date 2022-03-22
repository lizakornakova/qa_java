package com.example;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
//Класс для тестирования класса Lion, где требуется параметризация
//Параметризация для проверки разного значения пола
@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final String sex;
    private final boolean expectedMane;

    public LionParameterizedTest(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }

    @Parameterized.Parameters
    public static Object[][] lionConstructorData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    //Проверка, что конструктор класса Lion работает корректно
    //Если пол мужской, то гривы есть
    //Если пол женский, то гривы нет
    public void lionConstructorTest() throws Exception {
        Lion lion = new Lion(sex, new Feline());
        boolean actualMane = lion.hasMane;
        Assert.assertEquals(expectedMane, actualMane);
    }

    @Test
    //Проверка, что метод doesHaveMane() возвращает верное значение пола
    //Если в конструкторе передали мужской пол, то метод вернет мужской пол
    //Если в конструкторе передали женский пол, то метод вернет женский пол
    public void testDoesHaveMane() throws Exception {
        Lion lion = new Lion(sex, new Feline());
        boolean actual = lion.doesHaveMane();
        Assert.assertEquals(expectedMane, actual);

    }
}
