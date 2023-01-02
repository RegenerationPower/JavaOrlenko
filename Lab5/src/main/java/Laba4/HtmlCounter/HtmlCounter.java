package Laba4.HtmlCounter;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class HtmlCounter implements Serializable {
    private final BufferedReader bufferedReader;
    private final String html;

    public HtmlCounter(String link) throws IOException {
        URL url = new URL(link);
        URLConnection connection = url.openConnection();
        bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        html = readHtml();
    }
    // Reading html page
    private String readHtml() throws IOException {
        StringBuilder html = new StringBuilder();
        String htmlLine;
        while ((htmlLine = bufferedReader.readLine()) != null) {
            html.append(htmlLine).append("\n");
        }
        return html.toString();
    }

    public String getHtml(){
        return html;
    }

    public void close() throws IOException {
        bufferedReader.close();
    }
}
