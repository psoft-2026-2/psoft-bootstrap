package atividade05;

import java.util.ArrayList;
import java.util.List;

/**
 * Logger modifiquei pq estava central fachada e não ficou bom.
 */
public class Logger {
    private  static Logger instancia; 
    private  List<String> historico;
   
    public Logger() {
        this.historico = new ArrayList<>(); 
    } 

    public static  synchronized Logger getInstancia(){
        if (instancia == null) {
            instancia = new  Logger(); 
            
        }
        return instancia; 
    }

    public void registrar(String mensagem){
        this.historico.add(mensagem);
        System.out.println("[LOG CENTRAL] " + mensagem); 
    }

    public  void  exibirHistorico(){
        System.out.println("\n--- Historico Completo de Logs ---");
        for (String log : historico ){
            System.out.println("- " + log);
        }
    }

    

}
