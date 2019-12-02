import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        try {
            boolean result = Main.validateXMLFile("D:\\Documents\\java_projects\\sources\\ValidationXMLFile\\src\\main\\resources\\correctFile.xml");
            System.out.println(result);
            boolean result1 = Main.validateXMLFile("D:\\Documents\\java_projects\\sources\\ValidationXMLFile\\src\\main\\resources\\withMistakeFile.xml");
            System.out.println(result1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean validateXMLFile(String path) throws IOException {
        CustomStek customStek = new CustomStek();
        Files.lines(Paths.get(path), StandardCharsets.UTF_8)
                .filter(line -> !line.startsWith("<"))
                .forEach(line -> {
                    String[] arr = line.split(" ");
                    Arrays.stream(arr)
                            .filter(item -> {
                                if (item.startsWith("<") && (item.endsWith(">"))) {
                                    return true;
                                }
                                return false;
                            })
                            .map((l) -> l.replace("/", ""))
                            .forEach(item -> {
                                customStek.add(item);
                            });
                });

        if (customStek.getSize() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
