import java.util.*;
public class ColaPrioridadArray<T> implements ColaPrioridad<T> {
    ArrayList<T> colaPrioridad = new ArrayList<T>();
    ArrayList<T> cola = new ArrayList<T>();
    ArrayList<T> cola2 = new ArrayList<T>();
    ArrayList<T> cola3 = new ArrayList<T>();
    ArrayList<T> cola4 = new ArrayList<T>();
    ArrayList<T> cola5 = new ArrayList<T>();
    
    int contador1 = 0;
    int contador2 = 0;
    int contador3 = 0;
    int contador4 = 0;
    int contador5 = 0;
    int length = 0;
    @SuppressWarnings("unchecked")
    public ColaPrioridadArray() {
        
        
    }
    
    
     
    public void insertar(T elem, int prioridad) {
        // TODO Completar y eliminar el throw
        if(elem == null || prioridad < 1) throw new IllegalArgumentException("Valores no validos");
        if(search(elem) == true) throw new IllegalArgumentException("Ya se ingreso el paciente");
               
        if(prioridad != 1){
            if(prioridad != 2){
                if(prioridad != 3){
                    if(prioridad != 4){
                        cola5.add(contador5 , elem);
                        contador5++;
                        length++;
                    }else{
                        cola4.add(contador4, elem);
                        contador4++;
                        length++;
                    }
                }else{
                    cola3.add(contador3, elem);
                    contador3++;
                    length++;
                }
            }else{
                cola2.add(contador2, elem);
                contador2++;
                length++;
            }
        }else{
            cola.add(contador1, elem);
            contador1++;
            length++;
        }
        
        
        
    }
    
    private void listaA(){
      colaPrioridad.clear();
      
      for(int n = 0 ; n < cola.size(); n ++){
            if(cola.get(n)== null){
                break;
            }  
            colaPrioridad.add(cola.get(n));
            
        }      
      for(int n = 0 ; n < cola2.size(); n++){
        if(cola2.get(n) == null){
                break;
            }
        colaPrioridad.add(cola2.get(n));
        
        }  
      for(int n = 0 ; n < cola3.size(); n++){
        if(cola3.get(n) == null){
                break;
            }
        colaPrioridad.add(cola3.get(n));
        
        }
      for(int n = 0 ; n < cola4.size(); n++){
        if(cola4.get(n) == null){
                break;
            }
        colaPrioridad.add(cola4.get(n));
           
        }
      for(int n = 0 ; n < cola5.size(); n++){
        if(cola5.get(n) == null){
                break;
            }
        colaPrioridad.add(cola5.get(n));
           
       }   
    }
    
     private boolean search(T elem){
      listaA();
      return length == 0;
    }
    
    public T eliminar() {
        // TODO Completar y eliminar el throw
        if(estaVacia() == true) throw new NullPointerException("La lista esta vacio");
        T elem = colaPrioridad.get(0);
        
        if(colaPrioridad.get(0) == cola.get(0)){ cola.remove(0);}
        if(colaPrioridad.get(0) == cola2.get(0)){ cola2.remove(0);}
        if(colaPrioridad.get(0) == cola3.get(0)){ cola3.remove(0);}
        if(colaPrioridad.get(0) == cola4.get(0)){ cola4.remove(0);}
        if(colaPrioridad.get(0) == cola5.get(0)){ cola5.remove(0);}
        
        colaPrioridad.remove(0);
        length--;
        return elem;
    
    }

    public T observar() {
        // TODO Completar y eliminar el throw
        if(estaVacia()== true)throw new NullPointerException("La lista esta vacia");
        
        listaA();
        
        return colaPrioridad.get(0);
    }

    public boolean estaVacia() {
        
        return colaPrioridad.size() == 0 ; 
     }

    public int tamanio() {
        
        return length;    
    }

}

