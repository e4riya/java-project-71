package hexlet.code;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/argumentsForDifferTest.csv", numLinesToSkip = 1)
    void generate(String path1, String path2, String expectedPath, String format) throws Exception {
        String expected = readFixture(expectedPath);

        String actual = Differ.generate(getFixturePath(path1).toString(), getFixturePath(path2).toString(), format);
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
