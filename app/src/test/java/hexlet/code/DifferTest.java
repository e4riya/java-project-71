package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class DifferTest {

    @Test
    void generate() throws Exception {
        String path1 = "file1.json";
        String path2 = "file2.json";
        String expected = readFixture("expected");

        String actual = Differ.generate(ParserJSON.getData(getFixturePath(path1).toString()),
                                        ParserJSON.getData(getFixturePath(path2).toString())
        );

        Assertions.assertEquals(expected, actual);
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
