package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    @Test
    void generate() throws Exception {
        String path1 = "file1.yml";
        String path2 = "file2.yml";
        String expected = readFixture("expectedStylish");

        String actual = Differ.generate(Parser.getData(getFixturePath(path1).toString()),
                                        Parser.getData(getFixturePath(path2).toString()
                                        ), "stylish");
        assertEquals(expected, actual);

        path1 = "file1.json";
        path2 = "file2.json";
        expected = readFixture("expectedForNesting");
        actual = Differ.generate(Parser.getData(getFixturePath(path1).toString()),
                                 Parser.getData(getFixturePath(path2).toString()
                                 ), "stylish");
        assertEquals(expected, actual);

        path1 = "file1.json";
        path2 = "file2.json";
        expected = readFixture("expectedPlain");
        actual = Differ.generate(Parser.getData(getFixturePath(path1).toString()),
                                 Parser.getData(getFixturePath(path2).toString()
                                 ), "plain");
        assertEquals(expected, actual);

        path1 = "file1.json";
        path2 = "file2.json";
        expected = readFixture("expectedForJSON");
        actual = Differ.generate(Parser.getData(getFixturePath(path1).toString()),
                                 Parser.getData(getFixturePath(path2).toString()
                                 ), "json");
        assertEquals(expected, actual);


    }

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", fileName)
                    .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        var path = getFixturePath(fileName);
        return Files.readString(path).trim();
    }
}
