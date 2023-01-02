package Laba4.WordsCounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class File {

    private final Stream<String> stream;
    private final Counter counter = new Counter();

    public File(String file) throws IOException {
        this.stream = Files.lines(Paths.get(file));
        calculateMaxWordsInLine();
    }

    public void calculateMaxWordsInLine() {
        stream.forEach(new Consumer<>() {
            @Override
            public void accept(String line) {
                int maxWords = Counter.getWordsInLine(line);
                if (maxWords > counter.getMaxWordsInLine()) {
                    counter.setMaxWordsInLine(maxWords);
                    counter.setMaxLine(line);
                }
            }
        });
    }

    public String getMaxLine() {
        return counter.getMaxLine();
    }
    public int getMaxWordsInLine() {
        return counter.getMaxWordsInLine();
    }

    public void close() {
        this.stream.close();
    }
}