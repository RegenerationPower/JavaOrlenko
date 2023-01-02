package Laba4.Encoding;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Encoding extends FilterInputStream {
    private final char keySymbol;

    public Encoding(InputStream in, char keySymbol) {
        super(in);
        this.keySymbol = keySymbol;
    }

    @Override
    public int read() throws IOException {
        int startingSymbol = super.read();

        if(startingSymbol == -1){
            return -1; //return nothing
        }
        return startingSymbol + (int) keySymbol;
    }

}
