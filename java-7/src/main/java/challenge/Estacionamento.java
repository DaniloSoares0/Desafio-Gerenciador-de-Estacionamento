package challenge;


import java.util.ArrayList;
import java.util.List;


public class Estacionamento {

    List<Carro> ListaDecarrosEstacionados = new ArrayList<>();


    public void estacionar(Carro carro) {
	
	   if(carro.getMotorista() == null) {
		   
		   throw new EstacionamentoException("N�o s�o permitidos carros aut�nomos");
	  
	   }else
		   
	      if(carro.getMotorista().getIdade() < 18){
	    	  
	   	   throw new EstacionamentoException("N�o s�o permitidos motoristas menores de idades");
	
	   }else
		   
		  if(carro.getMotorista().getPontos() == 30){
		   	  
		   throw new EstacionamentoException("N�o s�o permitidos motoristas sem pontua��o");
	
	   }else
	
		  if(ListaDecarrosEstacionados.size() == 10 && verficarIdades(ListaDecarrosEstacionados) ) {
		    	 
		   throw new EstacionamentoException("N�o h� mais vagas no estacionamento");

	   }else
		   
	      if(ListaDecarrosEstacionados.size() <= 10 ) {
	    	 
	    	 ListaDecarrosEstacionados.add(carro);
	     }
     
	
    }

    public int carrosEstacionados() {
   	
    	try {
    		if(ListaDecarrosEstacionados.size() == 1 ) {

    			return  ListaDecarrosEstacionados.size();
    		}else {

    			return  ListaDecarrosEstacionados.size() - 1;
    		}
    	} catch (Exception e) {

    		throw new RuntimeException(e);
    	}

    }

    
    
    public boolean carroEstacionado(Carro carro) {

    	if(ListaDecarrosEstacionados.contains(carro) && carro.getMotorista().getIdade() != 60) {
    		
    		ListaDecarrosEstacionados.remove(carro);
    	}
    	
    	return  ListaDecarrosEstacionados.contains(carro);
    }
    
    
    
    public static Boolean verficarIdades(List<Carro> ListaDecarrosEstacionados) {

    	Boolean validador = true;

    	for (Carro carro : ListaDecarrosEstacionados) {
    		
    		if(carro.getMotorista().getIdade() != 60) {

    			validador = false;
    		}

    	}
     
    	return validador;
    }
    
    
}
