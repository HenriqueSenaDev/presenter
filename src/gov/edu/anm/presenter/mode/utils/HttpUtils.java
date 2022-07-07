package gov.edu.anm.presenter.mode.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class HttpUtils {
    
    public static String getRequestInputStream(HttpURLConnection conn) 
            throws IOException {
        StringBuilder result = new StringBuilder();
        
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null;) {
                result.append(line);
            }
            return result.toString();
        }
        catch (IOException e) {
            throw new IOException("Erro na leitura da resposta:\n" + e.getMessage());
        }
    }
    
}
