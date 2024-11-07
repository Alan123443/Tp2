Tp2

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un paciente que ingresa a la Sala de Emergencia
 */
public class Paciente {

    public String nombre;
    public String apellido;
    public String diagnostico;

    public Paciente(String nombre, String apellido, String diagnostico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.diagnostico = diagnostico;
    }

    @Override
    public String toString() {
        return this.nombre + " " + this.apellido + "( " + this.diagnostico + " )";
    }

    /**
     * Lee los pacientes almacenados en el archivo "pacientes.txt"
     * 
     * @return Lista de pacientes por orden de llegada.
     */
    public static List<Paciente> leerPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("./pacientes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] parts = linea.split(",");
                String nombre = parts[0].trim();
                String apellido = parts[1].trim();
                String diagnostico = parts[2].trim();
                pacientes.add(new Paciente(nombre, apellido, diagnostico));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    /**
     * Devuelve un número representando la Clasificación de Emergencia del paciente
     * a partir de su
     * diagnóstico.
     * Número del 1 al 5 donde:
     * - 1 es Emergencia (Rojo)
     * - 2 es Urgencia (Naranja)
     * - ...
     * - 5 es No Urgente (Azul)
     * 
     * @return Clasificación de emergencia
     */
    public int clasificacionEmergencia() {
        // TODO Completar según la escala de la consigna
        // el color de Triaje está en el atributo diagnostico, con la primera letra en
        // mayúscula
        int valor = 0;
        if(diagnostico.equals("Rojo")){valor = 1 ;}
        if(diagnostico.equals("Naranja")){valor = 2 ;}
        if(diagnostico.equals("Amarillo")){valor = 3 ;}
        if(diagnostico.equals("Verde")){valor = 4 ;}
        if(diagnostico.equals("Azul")){valor = 5 ;}
        return valor;
    }

}

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


public interface ColaPrioridad<T> {

    /**
     * Inserta un elemento en la cola de prioridad con una prioridad específica.
     *
     * @param elem      El elemento a insertar
     * @param prioridad La prioridad del elemento
     */
    void insertar(T elem, int prioridad);

    /**
     * Elimina y devuelve el elemento con la prioridad más alta.
     *
     * @return el elemento con la prioridad más alta, o null si la cola está vacía
     */
    T eliminar();

    /**
     * Devuelve (sin eliminar) el elemento con la prioridad más alta.
     *
     * @return el elemento con la prioridad más alta, o null si la cola está vacía
     */
    T observar();

    /**
     * Verifica si la cola de prioridad está vacía.
     *
     * @return true si la cola está vacía, de lo contrario false
     */
    boolean estaVacia();

    /**
     * Devuelve el tamaño de la cola de prioridad.
     *
     * @return el número de elementos almacenados en la cola de prioridad
     */
    int tamanio();

}


import java.util.List;

public class SalaDeEmergencia {

    /**
     * Calcula el N-ésimo paciente en ser atendido
     * 
     * @param n N-ésimo paciente a buscarimport java.util.List;

public class SalaDeEmergencia {

    /**
     * Calcula el N-ésimo paciente en ser atendido
     * 
     * @param n N-ésimo paciente a buscar
     * @pre n >= 1
     * @return El n-ésimo paciente o null si no existe
     */
    public static Paciente calcularAtencionN(int n) {
        if(n < 1) throw new IllegalArgumentException("Numero no valido");
        List<Paciente> pacientesPorLlegada = Paciente.leerPacientes();
        ColaPrioridad<Paciente> colaPrioridad = new ColaPrioridadArray<>();
        
        
        
        // TODO clasificar y priorizar los pacientes usando el TAD implementado
        for(Paciente paciente : pacientesPorLlegada){
        int p = paciente.clasificacionEmergencia();
        colaPrioridad.insertar(paciente, p );
        }
        
        
        
        
        // TODO calcular el N paciente a ser atendido
        for(int a = 1; a < n-1; a++){
            colaPrioridad.eliminar();
        }
        
        Paciente paciente = pacientesPorLlegada.get(n-1);
        // .....

        return paciente;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Pasar el número de paciente a calcular");
            return;
        }
        int n = Integer.parseInt(args[0]);
        Paciente resultado = calcularAtencionN(n);
        System.out.print("Paciente: ");
        System.out.println(resultado);
    }
}

public class SalaDeEmergenciaTest {
    // Metodo auxiliar
    public static void assertEquals(Object expected, Object actual, String message) {
        if (!expected.equals(actual)) {
            System.err.println(message + " Expected: " + expected + ", but got: " + actual);
            System.exit(1);
        }
    }

    // Metodo auxiliar
    public static void assertNull(Object object, String message) {
        if (object != null) {
            System.err.println(message);
            System.exit(1);
        }
    }

    public static void testPrimerPaciente() {
        Paciente resultado = SalaDeEmergencia.calcularAtencionN(1);

        assertEquals("Juan", resultado.nombre, "El nombre del primer paciente es incorrecto");
        assertEquals("Perez", resultado.apellido, "El apellido del primer paciente es incorrecto");
    }

    public static void testPacienteNoExistente() {
        Paciente resultado = SalaDeEmergencia.calcularAtencionN(40);

        assertNull(resultado, "Se espera que el 40-ésimo paciente no exista.");
    }

    public static void testPaciente102030() {
        Paciente r10 = SalaDeEmergencia.calcularAtencionN(10);
        Paciente r20 = SalaDeEmergencia.calcularAtencionN(20);
        Paciente r30 = SalaDeEmergencia.calcularAtencionN(30);

        assertEquals("Pedro", r10.nombre, "El nombre del 10-ésimo paciente es incorrecto");
        assertEquals("Rodriguez", r10.apellido, "El apellido del 10-ésimo paciente es incorrecto");

        assertEquals("Marta", r20.nombre, "El nombre del 20-ésimo paciente es incorrecto");
        assertEquals("Gutierrez", r20.apellido, "El apellido del 20-ésimo paciente es incorrecto");

        assertEquals("Valeria", r30.nombre, "El nombre del 30-ésimo paciente es incorrecto");
        assertEquals("Ibanez", r30.apellido, "El apellido del 30-ésimo paciente es incorrecto");
    }

    public static void main(String[] args) {
        testPrimerPaciente();
        testPacienteNoExistente();
        testPaciente102030();
    }
}

     * @pre n >= 1
     * @return El n-ésimo paciente o null si no existe
     */
    public static Paciente calcularAtencionN(int n) {
        if(n < 1) throw new IllegalArgumentException("Numero no valido");
        List<Paciente> pacientesPorLlegada = Paciente.leerPacientes();
        ColaPrioridad<Paciente> colaPrioridad = new ColaPrioridadArray<>();
        
        
        
        // TODO clasificar y priorizar los pacientes usando el TAD implementado
        for(Paciente paciente : pacientesPorLlegada){
        int p = paciente.clasificacionEmergencia();
        colaPrioridad.insertar(paciente, p );
        }
        
        
        
        
        // TODO calcular el N paciente a ser atendido
        for(int a = 1; a < n-1; a++){
            colaPrioridad.eliminar();
        }
        
        Paciente paciente = pacientesPorLlegada.get(n-1);
        // .....

        return paciente;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Pasar el número de paciente a calcular");
            return;
        }
        int n = Integer.parseInt(args[0]);
        Paciente resultado = calcularAtencionN(n);
        System.out.print("Paciente: ");
        System.out.println(resultado);
    }
}

public class SalaDeEmergenciaTest {
    // Metodo auxiliar
    public static void assertEquals(Object expected, Object actual, String message) {
        if (!expected.equals(actual)) {
            System.err.println(message + " Expected: " + expected + ", but got: " + actual);
            System.exit(1);
        }
    }

    // Metodo auxiliar
    public static void assertNull(Object object, String message) {
        if (object != null) {
            System.err.println(message);
            System.exit(1);
        }
    }

    public static void testPrimerPaciente() {
        Paciente resultado = SalaDeEmergencia.calcularAtencionN(1);

        assertEquals("Juan", resultado.nombre, "El nombre del primer paciente es incorrecto");
        assertEquals("Perez", resultado.apellido, "El apellido del primer paciente es incorrecto");
    }

    public static void testPacienteNoExistente() {
        Paciente resultado = SalaDeEmergencia.calcularAtencionN(40);

        assertNull(resultado, "Se espera que el 40-ésimo paciente no exista.");
    }

    public static void testPaciente102030() {
        Paciente r10 = SalaDeEmergencia.calcularAtencionN(10);
        Paciente r20 = SalaDeEmergencia.calcularAtencionN(20);
        Paciente r30 = SalaDeEmergencia.calcularAtencionN(30);

        assertEquals("Pedro", r10.nombre, "El nombre del 10-ésimo paciente es incorrecto");
        assertEquals("Rodriguez", r10.apellido, "El apellido del 10-ésimo paciente es incorrecto");

        assertEquals("Marta", r20.nombre, "El nombre del 20-ésimo paciente es incorrecto");
        assertEquals("Gutierrez", r20.apellido, "El apellido del 20-ésimo paciente es incorrecto");

        assertEquals("Valeria", r30.nombre, "El nombre del 30-ésimo paciente es incorrecto");
        assertEquals("Ibanez", r30.apellido, "El apellido del 30-ésimo paciente es incorrecto");
    }

    public static void main(String[] args) {
        testPrimerPaciente();
        testPacienteNoExistente();
        testPaciente102030();
    }
}
