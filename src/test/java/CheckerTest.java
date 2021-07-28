import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CheckerTest {

    @Test //тест на чтение имеющегося файла и запись строки в него
    void test1() throws IOException {
        String test1 = "C:\\\\Users\\\\79268\\\\IdeaProjects\\\\FileChecker2\\\\src\\\\main\\\\java\\\\test.txt\n2\nstring 4\n";
        byte[] test1Bytes = test1.getBytes();
        InputStream is1 = new ByteArrayInputStream(test1Bytes);
        Checker.check(is1);
    }
    @Test //тест на чтение имеющегося файла и чтение информации из него
    void test2() throws IOException {
        String test2 = "C:\\\\Users\\\\79268\\\\IdeaProjects\\\\FileChecker2\\\\src\\\\main\\\\java\\\\test.txt\n1\n";
        byte[] test2Bytes = test2.getBytes();
        InputStream is2 = new ByteArrayInputStream(test2Bytes);
        Checker.check(is2);
    }

    @Test //тест на создание файла и запись в него строки
    void test3() throws IOException {
        String test3 = "C:\\\\Users\\\\79268\\\\IdeaProjects\\\\FileChecker2\\\\src\\\\main\\\\java\\\\test1.txt\n1\n2\ntest string\n";
        byte[] test3Bytes = test3.getBytes();
        InputStream is3 = new ByteArrayInputStream(test3Bytes);
        Checker.check(is3);
        Path path3 = Paths.get("C:\\Users\\79268\\IdeaProjects\\FileChecker2\\src\\main\\java\\test1.txt");
        Files.delete(path3);
    }
}
