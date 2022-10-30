package LabCodeJava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class CommentRemover {
    public static void main(String[] args) throws IOException {
        final var lines = Files.readAllLines(Path.of("myfile.txt"));

        var result = new ArrayList<String>();
        boolean blockComment = false;

        for (final String line : lines) {
            if (line.contains("//")) {
                var index = line.indexOf("//");
                if (index == 0) {
                    // do nothing.
                } else {
                    final var newline = line.substring(0, index);
                    result.add(newline);
                }
            } else {
                if (line.contains("/*")) {
                    blockComment = true;
                    var firstIndex = line.indexOf("/*");
                    if (line.contains("*/")) {
                        var lastIndex = line.indexOf("*/");
                        var newline = line.substring(0, firstIndex) + line.substring(lastIndex + 2);
                        result.add(newline);
                        blockComment = false;
                    }
                } else if (!line.contains("*/") && blockComment) {
                    //do nothing .
                } else if (line.contains("*/") && blockComment) {
                        var lastIndex = line.indexOf("*/");
                        var newline = line.substring(lastIndex + 2);
                        result.add(newline);
                        blockComment = false;
                } else {
                    result.add(line);
                }
            }
        }
        final var outputContents = String.join("\n", result);
        Files.writeString(Path.of("output.txt"), outputContents);

        System.out.println(" Program run successfully. \n Check output.txt file. ");
    }
}