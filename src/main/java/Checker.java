import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class Checker {

    static void check(InputStream inputStream) throws IOException {
        System.out.println("Введите имя файла, включая путь, для проверки его существования.");

        Scanner sc = new Scanner(inputStream);
        Path path = Paths.get(sc.nextLine());
        int answer;
        if (Files.exists(path)) {
            System.out.println("Файл найден!");
            readOrWrite(sc, path);
        } else {
            System.out.println("Файл не найден! Создать?\n1 - да, 2 - нет");
            boolean choice = false;
            do {
                answer = sc.nextInt();
                switch (answer) {
                    case 1:
                        choice = true;
                        try {
                            Files.createFile(path);
                            System.out.println("Файл создан!");
                            readOrWrite(sc, path);
                        } catch (IOException e) {
                            System.out.println("Неверно указан путь к файлу.");
                        }
                        break;
                    case 2:
                        choice = true;
                        break;
                    default:
                        System.out.println("Некорректный выбор команды. Повторите попытку.");
                }
            }
            while (!choice);
        }
        System.out.println("Выход из программы...\n");
    }

    static void readOrWrite(Scanner scanner, Path path) throws IOException {
        int choice;
        boolean correctChoice = false;
        while (!correctChoice) {
            System.out.println("Выберите действие с файлом:\n1. Прочитать содержимое.\n2. Дописать строку в конец файла.");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Содержимое файла: {");
                    List<String> lines = Files.readAllLines(path);
                    for (String s : lines) {
                        System.out.println(s);
                    }
                    System.out.println("}");
                    correctChoice = true;
                    break;
                case 2:
                    System.out.println("Введитек строку, которую хотите дописать в файл и нажмите Enter.");
                    String line = scanner.nextLine();
                    Files.write(path, line.getBytes(), StandardOpenOption.APPEND);
                    System.out.println("Строка \"" + line + "\" дописана в конец файла.");
                    correctChoice = true;
                    break;
                default:
                    System.out.println("Некорректный выбор команды. Повторите попытку.");
                    break;
            }
        }
    }
}
