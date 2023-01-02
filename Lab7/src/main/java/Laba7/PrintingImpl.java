package Laba7;

public class PrintingImpl implements Printing {
    @Override
    public String printing(String printed) {
        System.out.println(printed);
        return printed;
    }
}
