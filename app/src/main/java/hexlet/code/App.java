package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * Main application class that compares two configuration files and shows differences.
 * Uses Picocli for command-line interface handling.
 */
@Command(
    name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
    description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {
    /**
     * Path to the first file to compare.
     */
    @Parameters(index = "0", description = "path to first file", paramLabel = "filepath1")
    private String firstFilePath;

    /**
     * Path to the second file to compare.
     */
    @Parameters(index = "1", description = "path to second file", paramLabel = "filepath2")
    private String secondFilepath;

    /**
     * Output format for the differences (default: stylish).
     */
    @Option(
        names = {"-f", "--format"}, description = "output format ${DEFAULT-VALUE}",
        defaultValue = "stylish", paramLabel = "format")
    private String format;

    /**
     * Main entry point for the application.
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    /**
     * Compares the files and outputs the difference.
     * @return Exit code (0 for success)
     * @throws Exception if file processing fails
     */
    @Override
    public Integer call() throws Exception {
        System.out.println(
            Differ.generate(firstFilePath, secondFilepath, format)
        );
        return 0;
    }
}
