import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.io.IOException;

import static org.mockito.Mockito.mock;

public class MainTest {

    @Test
    public void testMethodValidateXMLFile() {
        //Проверяем, что валидация вернет true, если у xml файла правильная структура
        Main mock = mock(Main.class);
        String path = "D:\\Documents\\java_projects\\sources\\ValidationXMLFile\\src\\main\\resources\\correctFile.xml";
        try {
            Assertions.assertEquals(mock.validateXMLFile(path), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Проверяем, что валидация вернет false, если у xml файла неправильная структура
        String pathWithMistake = "D:\\Documents\\java_projects\\sources\\ValidationXMLFile\\src\\main\\resources\\withMistakeFile.xml";
        try {
            Assertions.assertEquals(mock.validateXMLFile(pathWithMistake), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RepeatedTest(10)
    void repeatedTest(TestInfo testInfo) {
        //Проверяем, что при нескольких вызовх метода с одинм и тем же файлом результат будет одинаковый
        Main mock = mock(Main.class);
        String path = "D:\\Documents\\java_projects\\sources\\ValidationXMLFile\\src\\main\\resources\\correctFile.xml";
        try {
            Assertions.assertEquals(mock.validateXMLFile(path), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testExpectedException() {
        //Проверяем, что при вызове метода не будет ошибки времени выполнения
        Main mock = mock(Main.class);
        String path = "D:\\Documents\\java_projects\\sources\\ValidationXMLFile\\src\\main\\resources\\correctFile.xml";
        try {
            Assertions.assertEquals(mock.validateXMLFile(path), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}