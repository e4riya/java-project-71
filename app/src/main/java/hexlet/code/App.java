package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(
    name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
    description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {
    @Parameters(index = "0", description = "path to first file", paramLabel = "filepath1")
    private String firstFilePath;
    @Parameters(index = "1", description = "path to second file", paramLabel = "filepath2")
    private String secondFilepath;

    public static void main(String[] args) throws Exception {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Option(
        names = {"-f", "--format"}, description = "output format ${DEFAULT-VALUE}",
        defaultValue = "stylish", paramLabel = "format")
    private String format;

    @Override
    public Integer call() throws Exception {
        System.out.println(
            Differ.generate(ParserJSON.getData(firstFilePath), ParserJSON.getData(secondFilepath))
        );
        return 0;
    }
}
