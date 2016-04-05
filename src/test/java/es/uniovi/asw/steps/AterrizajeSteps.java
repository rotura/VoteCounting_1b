package es.uniovi.asw.steps;

import cucumber.api.PendingException;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

public class AterrizajeSteps {

  @Cuando("^el cliente accede a /$")                                                   
  public void el_cliente_accede_a() throws Throwable {                                 
      System.out.println("Accediendo a /");                                                    
  }                                                                                    
                                                                                       
  @Entonces("^el cliente recibe el código (\\d+)$")                                    
  public void el_cliente_recibe_el_codigo(int codigo) throws Throwable {                 
      System.out.println("Verificar que se recibe " + codigo);                                                    
  }                                                                                    
                                                                                       
  @Entonces("^el resultado contiene la cadena \"([^\"]*)\"$")                          
  public void el_resultado_contiene_la_cadena(String cadena) throws Throwable {          
    System.out.println("Verificar que el resultado contiene " + cadena);                                                    
  }                                                                                    
  
}
