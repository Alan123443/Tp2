import java.util.List;

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
