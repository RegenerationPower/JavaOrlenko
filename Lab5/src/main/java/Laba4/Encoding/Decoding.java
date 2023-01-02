package Laba4.Encoding;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Decoding extends FilterOutputStream {
    private final char keySymbol;

    public Decoding(OutputStream out, char keySymbol) {
        super(out);
        this.keySymbol = keySymbol;
    }

    @Override
    public void write(int finalSymbol) throws IOException {
        super.write(finalSymbol - (int) keySymbol);
    }

}
