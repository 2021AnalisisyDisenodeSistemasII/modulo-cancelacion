package starbank_cancelation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class HashMap_JSON_Loader {
    
    public HashMap_JSON_Loader(){
        
    }
    
    public HashMap create(String directorio){
        
        String json = "";
        
        try (BufferedReader br = new BufferedReader(new FileReader(directorio))){
            String line;
            while ((line = br.readLine()) != null) {
                json+= line;
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        
        return gson.fromJson(json, HashMap.class);
    }
    
}
