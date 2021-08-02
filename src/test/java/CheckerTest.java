import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CheckerTest {

    @Test //тест на чтение имеющегося файла и запись строки в него
    void test1() throws IOException {
        Path test1Path = Files.createTempFile("test1",".txt");
        String testString1Path = test1Path.toAbsolutePath().toString();
        String test1 = testString1Path+"\n2\nstring 4\n";
        byte[] test1Bytes = test1.getBytes();
        InputStream is1 = new ByteArrayInputStream(test1Bytes);
        Checker.check(is1);
        Files.delete(test1Path);
    }
    @Test //тест на чтение имеющегося файла и чтение информации из него, если файл пустой
    void test2() throws IOException {
        Path test2Path = Files.createTempFile("test2",".txt");
        String testString2Path = test2Path.toAbsolutePath().toString();
        String test2 = testString2Path+"\n1\n";
        byte[] test2Bytes = test2.getBytes();
        InputStream is2 = new ByteArrayInputStream(test2Bytes);
        Checker.check(is2);
        Files.delete(test2Path);
    }

    @Test //тест на создание файла и запись в него строки
    void test3() throws IOException {
        Path test3Path = Files.createTempFile("test3",".txt");
        String testString3Path = test3Path.toAbsolutePath().toString();
        String test3 = testString3Path+"\n2\ntest string\n";
        byte[] test3Bytes = test3.getBytes();
        InputStream is3 = new ByteArrayInputStream(test3Bytes);
        Checker.check(is3);
        Files.delete(test3Path);
    }

    @Test //тест на чтение имеющегося файла и чтение информации из него, если в файле есть строки
    void test4() throws IOException {
        Path test4Path = Files.createTempFile("test4",".txt");
        String testContent = "This is a test string;\nand this is a second test string;\nthird string.";
        Files.write(test4Path,testContent.getBytes(StandardCharsets.UTF_8));
        String testString4Path = test4Path.toAbsolutePath().toString();
        String test4 = testString4Path+"\n1\n";
        byte[] test4Bytes = test4.getBytes();
        InputStream is4 = new ByteArrayInputStream(test4Bytes);
        Checker.check(is4);
        Files.delete(test4Path);
    }
}
