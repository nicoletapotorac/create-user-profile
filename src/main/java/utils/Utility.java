package utils;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utility {
    public static boolean isDirEmpty(final String path) throws IOException {
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(Paths.get(path))) {
            return !dirStream.iterator().hasNext();
        }
    }
}