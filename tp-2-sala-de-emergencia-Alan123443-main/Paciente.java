
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
