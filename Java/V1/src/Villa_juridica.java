import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

public class Villa_juridica {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws Exception {

        // Crear un objeto usando el constructor sin parámetros 
        EtapaKanban objKanban = new EtapaKanban();

         // Cargar datos usando el método set
         objKanban.setIdEtapaKanban(1);
         objKanban.setNombreEtapa("Ejecución");
         objKanban.setTipo("Expediente");
         objKanban.setCategoria("Procesal");

         // Se crea el objeto con el constructor sin parámteros 
        Expediente objExpediente = new Expediente();

        // Cargar datos usando el método set
        objExpediente.setIdExpediente(UUID.randomUUID());
        objExpediente.setTituloExpediente("Ejecutivo de Mínima Cuantía");
        objExpediente.setDescripcion("El cliente cuenta con una letra de cambio -válida- vencida que quiere cobrar.");
        objExpediente.setFechaApertura(new Timestamp(System.currentTimeMillis()));
        objExpediente.setFechaCierre(new Date(2024,12,10));
        objExpediente.setPrecio(new BigDecimal(1400000.00));
        objExpediente.setEstadoExpediente("Archivado");
        objExpediente.setPosicionExpediente(1);
        objExpediente.setCreadoPor(UUID.randomUUID());
        objExpediente.setEtapaKanban(objKanban);

        // Crear un objeto usando el constructor con parámetros
        EtapaKanban objKanban1 = new EtapaKanban(2, "En Progreso", "Tarea", "null");

        Tarea objTarea = new Tarea(UUID.randomUUID(), "Verificar con el cliente si recibió copia autentica de la Sentencia.", false, objKanban1, new Date(2024,03,20), UUID.randomUUID(), "Seguimiento - Cliente");

        TareaRelacion objRelacion = new TareaRelacion();
        objRelacion.setPosicionTarea(1);
        objRelacion.setIdRelacionTarea(UUID.randomUUID());
        objRelacion.setTarea(objTarea);
        objRelacion.setExpediente(objExpediente);

         // Devolver la información almacenada en los atributos 
         System.out.println("Resumen de Expediente Creado:");
         System.out.println("ID: " + objExpediente.getIdExpediente());
         System.out.println("Título: " + objExpediente.getTituloExpediente());
         System.out.println("Descripción: " + objExpediente.getDescripcion());
         System.out.println("Fecha de apertura: " + objExpediente.getFechaApertura());
         System.out.println("Fecha de cierre: " + objExpediente.getFechaCierre());
         System.out.println("Precio: " + objExpediente.getPrecio());
         System.out.println("Estado: " + objExpediente.getEstadoExpediente());
         System.out.println("Posición: " + objExpediente.getPosicionExpediente());
         System.out.println("Creado por: " + objExpediente.getCreadoPor());
         System.out.println("Etapa Actual: " + objExpediente.getEtapaKanban().getNombreEtapa());
         
         System.out.println("Tareas del Expediente: ");
         System.out.println(objRelacion.getPosicionTarea());
         System.out.println("Descripción: " + objRelacion.getTarea().getDescripcionTarea());
         System.out.println("Estado de Tarea: " + objTarea.getEtapaKanban().getNombreEtapa());
     }
 }