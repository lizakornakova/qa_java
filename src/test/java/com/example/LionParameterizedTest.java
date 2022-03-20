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
    private final String textOfException;

    public LionParameterizedTest(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
        this.textOfException = "Используйте допустимые значения пола животного - самей или самка";
    }

    @Parameterized.Parameters
    public static Object[][] lionConstructorData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Неизвестный гендер", false}
        };
    }

    @Test
    //Проверка, что конструктор класса Lion работает корректно
    //Если пол мужской, то гривы есть
    //Если пол женский, то гривы нет
    //Если пол задан неккоректно, то ждем ошибку
    public void lionConstructorTest() throws Exception {
        try {
            Lion lion = new Lion(sex, new Feline());
            boolean actualMane = lion.hasMane;
            Assert.assertEquals(expectedMane, actualMane);
        } catch (Exception exception) {
            Assert.assertEquals(textOfException, exception.getMessage());
        }
    }

    @Test
    //Проверка, что метод doesHaveMane() возвращает верное значение пола
    //Если в конструкторе передали мужской пол, то метод вернет мужской пол
    //Если в конструкторе передали женский пол, то метод вернет женский пол
    //Если пол задан неккоректно, то ждем ошибку
    public void testDoesHaveMane() throws Exception {
        try {
            Lion lion = new Lion(sex, new Feline());
            boolean actual = lion.doesHaveMane();
            Assert.assertEquals(expectedMane, actual);
        } catch (Exception exception) {
            Assert.assertEquals(textOfException, exception.getMessage());
        }
    }
}
