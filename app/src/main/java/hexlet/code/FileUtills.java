package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtills {
    public static String readFile(String path) throws Exception{
        Path filePath = Paths.get(path);
        if(!Files.exists(filePath)){
            throw new Exception("File '" + path + "' does not exist");
        }
        String content = Files.readString(filePath);
        return content;
    }
}
