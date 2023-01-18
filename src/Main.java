import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
public class Main {
    public static String readFileAsString(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
    public static void main(String[] args) throws IOException {
        // Terminal: new-item -path .\text.txt -value 'Hello world!'
        // Reading Files
        File file = new File("C:\\Users\\user\\IdeaProjects\\ReadingFiles\\text.txt");
        Scanner scanner = new Scanner(file);
        try {
            while(scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println(e.getCause());
        }

        File file2 = new File("C:\\system.tmp");
        // Канонический пример
        try (Scanner scanner2 = new Scanner(file2)) {
            while (scanner2.hasNext()) {
                System.out.println(scanner2.nextLine() + " ");
            }
        } catch(FileNotFoundException e) {
            System.out.println("No file found! " + file2);
        }


        // работаем с многостроковым текстом
        String pathToFileInUsers = ("C:\\Users\\user\\folderForFiles\\text.txt");
        System.out.println(readFileAsString(pathToFileInUsers));
        System.out.println(" ");


        // Вызываем непосредственно
        try {
            System.out.println(new String(Files.readAllBytes(Paths.get(pathToFileInUsers))));
        } catch (Exception e) {
            System.out.println(e.getCause());
        }


        // Запись в файл
        String message = "Added text";
        Path path = Path.of("C:\\Users\\user\\folderForFiles\\text.txt");
        Files.writeString(path, message);

    }
}