package starbank_cancelation;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;  

public class Class_Generator {

    public Natural_Client genNaturalClient(String client_id, String data){
        
        Natural_Client cliente = new Natural_Client();
        
        data = data.replace("{", "");
        data = data.replace("}", "");
        data = data.replace("[", "");
        data = data.replace("]", "");
        
        String[] dataArray;
        dataArray = data.split(",");
        
        String[] accounts;
        List<String> lista = new ArrayList<>();
        
        int i = 0;
        
        for(String aux : dataArray){
            
            if (aux.contains("accounts")) {
                String[] auxArray;
                auxArray = aux.split("=");
                
                lista.add(auxArray[1]);
                
                i++;
            } else {
                while ((dataArray[i].contains("phone")) == false) {
                    lista.add(dataArray[i].replace(" ", ""));
                    i++;
                }
            }
            
            if (aux.contains("phone")){
                String[] auxArray;
                auxArray = aux.split("=");
                
                cliente.setPhone(auxArray[1]);
            }
            
            if (aux.contains("client_name")){
                String[] auxArray;
                auxArray = aux.split("=");
                
                cliente.setClient_name(auxArray[1]);
            }
            
            if (aux.contains("client_occupation")){
                String[] auxArray;
                auxArray = aux.split("=");
                
                cliente.setClient_occupation(auxArray[1]);
            }
            
            if (aux.contains("client_address")){
                String[] auxArray;
                auxArray = aux.split("=");
                
                //dataArray.
                cliente.setClient_address(auxArray[1]+","+dataArray[dataArray.length-1]);
            }
        }
        
        accounts = lista.toArray(new String[0]);
        
        cliente.setClient_id(client_id);
        cliente.setAccounts(accounts);
        
        return cliente;
    }
    
    public Company_Client genCompanyClient(String nit, String data){
        
        Company_Client cliente = new Company_Client();
        
        data = data.replace("{", "");
        data = data.replace("}", "");
        data = data.replace("[", "");
        data = data.replace("]", "");
        
        String[] dataArray;
        dataArray = data.split(",");
        
        String[] accounts;
        List<String> lista = new ArrayList<>();
        
        int i = 0;
        
        for(String aux : dataArray){
            
            if (aux.contains("accounts")) {
                String[] auxArray;
                auxArray = aux.split("=");
                
                lista.add(auxArray[1]);
                
                i++;
            } else {
                while ((dataArray[i].contains("phone")) == false) {
                    lista.add(dataArray[i].replace(" ", ""));
                    i++;
                }
            }
            
            if (aux.contains("phone")){
                String[] auxArray;
                auxArray = aux.split("=");
                
                cliente.setPhone(auxArray[1]);
            }
            
            if (aux.contains("client_name")){
                String[] auxArray;
                auxArray = aux.split("=");
                
                cliente.setClient_name(auxArray[1]);
            }
            
            if (aux.contains("client_occupation")){
                String[] auxArray;
                auxArray = aux.split("=");
                
                cliente.setClient_occupation(auxArray[1]);
            }
            
            if (aux.contains("client_address")){
                String[] auxArray;
                auxArray = aux.split("=");
                
                //dataArray.
                cliente.setClient_address(auxArray[1]+","+dataArray[dataArray.length-1]);
            }
            
            if (aux.contains("client_id")){
                String[] auxArray;
                auxArray = aux.split("=");
                
                cliente.setClient_id(auxArray[1]);
            }
            
            if (aux.contains("company_name")){
                String[] auxArray;
                auxArray = aux.split("=");
                
                cliente.setCompany_name(auxArray[1]);
            }
            
            if (aux.contains("cluster")){
                String[] auxArray;
                auxArray = aux.split("=");
                
                cliente.setCluster(auxArray[1]);
            }
            
        }
        
        accounts = lista.toArray(new String[0]);
        
        cliente.setNit(nit);
        cliente.setAccounts(accounts);
        
        return cliente;
        
    }
    
}
