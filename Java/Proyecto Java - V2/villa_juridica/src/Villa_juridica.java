import java.math.BigDecimal;
import java.net.ConnectException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

public class Villa_juridica {
    public static void main(String[] args) throws SQLException {

         // Prueba de Conexión
        SQLconnection.connect();
        Scanner entrada=new Scanner(System.in);

        /*/ ----- EtapaKanban ------
        System.out.println("Ingrese el nombre de la Etapa: ");
        String nombreEtapa=entrada.nextLine();
        entrada.nextLine();

        System.out.println("Ingrese el tipo de Etapa (pueder ser 'expediente', 'cliente potencial','tarea', 'nota', 'evento', 'documento'): ");
        String tipo=entrada.nextLine();
        entrada.nextLine();

        System.out.println("Ingrese la categoria a la que pertenece la Etapa: ");
        String categoria=entrada.nextLine();

        //Crear el Objeto
        EtapaKanban objetapa = new EtapaKanban(nombreEtapa, tipo, categoria);

        //Crear el Objeto para insertar Datos
        EtapaKanbanCRUD objetapacrudd = new EtapaKanbanCRUD();

        //Crear el Objeto de la Conexión
        Connection connection = SQLconnection.connect();
        objetapacrudd.addEtapa(objetapa,connection);

        //Metodo para Consultar Etapas
        System.out.println("LISTA DE ETAPAS:");
        objetapacrudd.searchEtapa(connection);

        //Metodo para Actualizar Datos
        System.out.println("Ingrese el código de Etapa para actualizar: ");
        int codConsult= entrada.nextInt();
        entrada.nextLine();

        System.out.println("Ingrese la nueva Etapa: ");
        String newNombre= entrada.nextLine();

        System.out.println("Ingrese el nuevo Tipo de Etapa: ");
        String newTipo= entrada.nextLine();

        System.out.println("Ingrese la nueva Categoría de la Etapa: ");
        String newCategoria= entrada.nextLine();

        objetapacrudd.updateEtapa(codConsult, newNombre, newTipo, newCategoria, connection);

        System.out.println("Lista de Etapas (Actualizada)");
        objetapacrudd.searchEtapa(connection);

        //Metodo para Eliminar Datos
        System.out.println("Ingrese el código de Etapa para eliminar: ");
        int codDelete= entrada.nextInt();

        objetapacrudd.deleteEtapa(codDelete, connection);

        System.out.println("NUEVA LISTA DE ETAPAS");
        objetapacrudd.searchEtapa(connection);

        SQLconnection.connect();

        // ----- Roles -----
        System.out.println("Ingrese el Rol: ");
        String nombreRol=entrada.nextLine();

        //Crear el Objeto
        Roles objrol = new Roles(nombreRol);

        //Crear el Objeto para insertar Datos
        RolesCRUD objrolcrudd = new RolesCRUD();

        //Crear el Objeto de la Conexión
        Connection connection = SQLconnection.connect();
        objrolcrudd.insertarRoles(objrol,connection);

        //Metodo para Consultar Roles
        System.out.println("LISTA DE ROLES");
        objrolcrudd.searchRoles(connection);

        //Metodo para Actualizar Datos
        System.out.println("Ingrese el código de Rol para actualizar: ");
        Integer codConsult= entrada.nextInt();
        entrada.nextLine();

        System.out.println("Ingrese el nuevo Rol: ");
        String newNombre= entrada.nextLine();

        objrolcrudd.updateRoles(codConsult, newNombre, connection);

        System.out.println("Lista de Roles (Actualizada)");
        objrolcrudd.searchRoles(connection);

        //Metodo para Eliminar Datos
        System.out.println("Ingrese el código de Rol para eliminar: ");
        int codDelete= entrada.nextInt();

        objrolcrudd.deleteRoles(codDelete, connection);

        System.out.println("NUEVA LISTA DE ROLES");
        objrolcrudd.searchRoles(connection);

        SQLconnection.connect();

        // ----- Contactos -----

        System.out.println("Ingrese el Tipo de Persona: ");
        String persona = entrada.nextLine();

        System.out.println("Ingrese el Número de Documento: ");
        String documento = entrada.nextLine();

        System.out.println("Ingrese el Nombre del Contacto: ");
        String nombre = entrada.nextLine();

        System.out.println("Ingrese el Tipo de Contacto: ");
        String tipoContacto = entrada.nextLine();

        System.out.println("Ingrese la Etapa del Contacto: ");
        Integer idEtapaKanban = entrada.nextInt();

        //Metodo para mostrar los usuarios disponibles
        ContactosCRUD objContactoscrudd = new ContactosCRUD();
        Connection connection = SQLconnection.connect();
        objContactoscrudd.mostrarUsuariosConUUID(connection);

        //Ingresar el dato "creadoPor"
        System.out.println("Ingrese el Id de Usuario (UUID) para crear este contacto (copie uno de los id mostrados): ");
        entrada.nextLine();
        String uuidInput = entrada.nextLine();
        UUID creadoPor = UUID.fromString(uuidInput);

        //Objeto para referenciar FK
        EtapaKanban etapaKanban = new EtapaKanban();
        etapaKanban.setIdEtapaKanban(idEtapaKanban);

        //Crear el Objeto
        Contactos objContacto = new Contactos();

        objContacto.setPersona(persona);
        objContacto.setDocumento(documento);
        objContacto.setNombre(nombre);
        objContacto.setTipoContacto(tipoContacto);
        objContacto.setEtapaKanban(etapaKanban);
        objContacto.setCreadoPor(creadoPor);

        //Crear el Objeto para insertar Datos
        objContactoscrudd.addContacto(objContacto, connection);

        //Metodo para actualizar datos

        // Seleccionar contacto
        System.out.println("\nIngrese el UUID del contacto que desea actualizar:");
        String uuidStr = entrada.nextLine();
        UUID idContacto = UUID.fromString(uuidStr);

        // Solicitar nuevos valores

        System.out.println("Ingrese el nuevo segundo nombre:");
        String newSegundoNombre = entrada.nextLine();

        System.out.println("Ingrese el nuevo apellido:");
        String newApellido = entrada.nextLine();

        System.out.println("Ingrese el nuevo correo:");
        String newCorreo = entrada.nextLine();

        System.out.println("Ingrese el nuevo teléfono:");
        String newTel = entrada.nextLine();

        System.out.println("Ingrese la nueva dirección:");
        String newDireccion = entrada.nextLine();

        System.out.println("Ingrese la nueva ciudad:");
        String newCiudad = entrada.nextLine();

        objContactoscrudd.updateContacto(idContacto, newSegundoNombre, newApellido, newCorreo, newTel, newDireccion, newCiudad, connection);
        System.out.println("Lista de Contactos (Actualizada)");
        objContactoscrudd.searchContactos(connection);

        //Metodo para Eliminar Datos (Main)
        System.out.println("Ingrese el UUID del contacto que desea eliminar: ");
        String codDelete= entrada.nextLine();

        objContactoscrudd.deleteContacto(UUID.fromString(codDelete), connection);

        System.out.println("NUEVA LISTA DE ETAPAS");
        objContactoscrudd.searchContactos(connection);

        SQLconnection.connect();

        // ----- Expediente -----
        System.out.println("Ingrese el Título del nuevo Expediente: ");
        String tituloExp = entrada.nextLine();

        System.out.println("Ingrese el área del Expediente: ");
        String areaExpediente = entrada.nextLine();

        System.out.println("Ingrese la descripción del Expediente: ");
        String descripcion = entrada.nextLine();

        System.out.println("Ingrese el precio del servicio: ");
        BigDecimal precio = entrada.nextBigDecimal();
        entrada.nextLine();

        System.out.println("Ingrese la ciudad del Expediente: ");
        String ciudadExp = entrada.nextLine();

        System.out.println("Ingrese el Id de Usuario (UUID) para crear este caso   (copie uno de los id mostrados): ");
        String uuidInput = entrada.nextLine();
        UUID creadoPor = UUID.fromString(uuidInput);

        //Crear el Objeto
        Expediente objExpediente = new Expediente();

        objExpediente.setTituloExpediente(tituloExp);
        objExpediente.setAreaExpediente(areaExpediente);
        objExpediente.setDescripcion(descripcion);
        objExpediente.setPrecio(precio);
        objExpediente.setCiudadExp(ciudadExp);
        objExpediente.setCreadoPor(creadoPor);

        //Crear el Objeto para insertar Datos
        ExpedienteCRUD objExpedientecrudd = new ExpedienteCRUD();

        Connection connection = SQLconnection.connect();
        objExpedientecrudd.addExpediente(objExpediente, connection);

        //Metodo para consultar Expedientes
        System.out.println("Lista de Expedientes:");
        objExpedientecrudd.searchExpediente(connection);

        // Metodo para actualizar datos
        System.out.println("\nIngrese el UUID del expediente que desea actualizar:");
        String uuidStr = entrada.nextLine();
        UUID idExpediente = UUID.fromString(uuidStr);

        System.out.println("Ingrese la nueva fecha de cierre del Expediente (yyyy-mm-dd):");
        String fechaCierreStr = entrada.nextLine();
        Date newFechaCierre = Date.valueOf(fechaCierreStr);

        System.out.println("Ingrese el nuevo No. Radicado:");
        String newRadicado = entrada.nextLine();

        System.out.println("Ingrese la fecha del Radicado:");
        String fechaRadicadoStr = entrada.nextLine();
        Date newFechaRadicado = Date.valueOf(fechaRadicadoStr);

        objExpedientecrudd.updateExpediente(idExpediente, newFechaCierre, newRadicado, newFechaRadicado, connection);

        System.out.println("Lista de Expedientes (Actualizada)");
        objExpedientecrudd.searchExpediente(connection);

        //Metodo para Eliminar Datos (Main)
        System.out.println("Ingrese el UUID del expediente que desea eliminar: ");
        String codDelete= entrada.nextLine();

        objExpedientecrudd.deleteExpediente(UUID.fromString(codDelete), connection);

        System.out.println("NUEVA LISTA DE ETAPAS");
        objExpedientecrudd.searchExpediente(connection);

        SQLconnection.connect();

        // ----- ExpedienteContrato -----
        //Agregar nueva RelacionEC
        System.out.println("Ingrese el UUID del expediente:");
        UUID uuidExpediente = UUID.fromString(entrada.nextLine());

        System.out.println("Ingrese el UUID del contacto:");
        UUID uuidContacto = UUID.fromString(entrada.nextLine());

        System.out.println("Ingrese el rol del contacto (Demandante, Abogado, etc):");
        String rolContacto = entrada.nextLine();

        Expediente expediente = new Expediente();
        expediente.setIdExpediente(uuidExpediente);

        Contactos contacto = new Contactos();
        contacto.setIdContacto(uuidContacto);

        ExpedienteContacto expedienteContacto = new ExpedienteContacto(rolContacto, contacto, expediente);

        ExpedienteContactoCRUD objExpedienteContactoCRUD = new ExpedienteContactoCRUD();

        Connection connection = SQLconnection.connect();
        objExpedienteContactoCRUD.addExpedienteContacto(expedienteContacto, connection);

        //Metodo para consultar RelacionEC
        System.out.println("\n--- Lista de ExpedienteContacto ---");
        objExpedienteContactoCRUD.searchExpedienteCliente(connection);

        //Metodo para actualizar RelacionEC
        System.out.println("Ingrese el UUID del registro (idRelacionEC) que desea actualizar:");
        UUID codConsult = UUID.fromString(entrada.nextLine());

        System.out.println("Ingrese el nuevo UUID del expediente:");
        UUID nuevoIdExpediente = UUID.fromString(entrada.nextLine());

        System.out.println("Ingrese el nuevo UUID del contacto:");
        UUID nuevoIdContacto = UUID.fromString(entrada.nextLine());

        System.out.println("Ingrese el nuevo rol del contacto:");
        String nuevoRol = entrada.nextLine();

        objExpedienteContactoCRUD.updateExpedienteContacto(codConsult, nuevoIdExpediente, nuevoIdContacto, nuevoRol, connection);

        System.out.println("\n--- Lista de ExpedienteContacto (Actualizada) ---");
        objExpedienteContactoCRUD.searchExpedienteCliente(connection);

        //Metodo para eliminar Registros
        System.out.println("Ingrese el UUID del registro (idRelacionEC) que desea eliminar:");
        String codDelete= entrada.nextLine();

        objExpedienteContactoCRUD.deleteExpedienteContacto(UUID.fromString(codDelete), connection);

        System.out.println("Nueva lista de RelacionEC");
        objExpedienteContactoCRUD.searchExpedienteCliente(connection);

        SQLconnection.connect();

        // ----- Documentos -----
        // Ingresar Datos
        System.out.println("Ingrese el título del documento:");
        String nombreDocumento = entrada.nextLine();

        System.out.println("Ingrese el origen del documento:");
        String origenDocumento = entrada.nextLine();

        System.out.println("Ingrese el enlace del documento:");
        String enlaceDocumento = entrada.nextLine();

        System.out.println("Ingrese el UUID del creador del documento:");
        UUID creadoPor = UUID.fromString(entrada.nextLine());

        Documento objDocumento= new Documento();
        objDocumento.setNombreDocumento(nombreDocumento);
        objDocumento.setOrigenDocumento(origenDocumento);
        objDocumento.setEnlaceDocumento(enlaceDocumento);
        objDocumento.setCreadoPor(creadoPor);

        DocumentoCRUD objDocumentoCRUD = new DocumentoCRUD();

        Connection connection = SQLconnection.connect();
        objDocumentoCRUD.addDocumento(objDocumento, connection);

        //Mostrar Datos
        System.out.println("\nLISTA DE DOCUMENTOS");
        objDocumentoCRUD.searchDocumento(connection);

        //Actualizar Datos
        System.out.println("Ingrese el UUID del documento a actualizar:");
        UUID idDocumento = UUID.fromString(entrada.nextLine());

        System.out.println("Ingrese el nuevo título:");
        String newNombreDocumento = entrada.nextLine();

        System.out.println("Ingrese el nuevo origen:");
        String newOrigenDocumento = entrada.nextLine();

        System.out.println("Ingrese el nuevo enlace:");
        String newEnlaceDocumento = entrada.nextLine();

        objDocumentoCRUD.updateDocumento(idDocumento, newNombreDocumento, newOrigenDocumento, newEnlaceDocumento, connection);

        System.out.println("Lista de Documentos (Actualizada)");
        objDocumentoCRUD.searchDocumento(connection);

        //Eliminar Datos
        System.out.println("Ingrese el UUID del documento a eliminar:");
        UUID codDelete = UUID.fromString(entrada.nextLine());

        objDocumentoCRUD.deleteDocumento(codDelete, connection);

        System.out.println("\nLista de Documentos (Actualizada)");
        objDocumentoCRUD.searchDocumento(connection);

        SQLconnection.connect();

        // ----- DocumentoExpediente -----
        //Agregar Datos
        System.out.println("Ingrese el UUID del expediente:");
        UUID uuidExpediente = UUID.fromString(entrada.nextLine());

        System.out.println("Ingrese el UUID del documento:");
        UUID uuidDocumento = UUID.fromString(entrada.nextLine());

        Expediente expediente = new Expediente();
        expediente.setIdExpediente(uuidExpediente);

        Documento documento = new Documento();
        documento.setIdDocumento(uuidDocumento);

        DocumentoExpediente documentoExpediente = new DocumentoExpediente(documento, expediente);

        DocumentoExpedienteCRUD objDocumentoExpedienteCRUD = new DocumentoExpedienteCRUD();

        Connection connection = SQLconnection.connect();
        objDocumentoExpedienteCRUD.addDocumentoExpediente(documentoExpediente, connection);

        //Metodo para mostrar datos
        System.out.println("\n--- Lista de Expedientes y Documentos ---");
        objDocumentoExpedienteCRUD.searchDocumentoExpediente(connection);

        //Metodo para actualizar Datos
        System.out.println("Ingrese el UUID del registro (idRelacionEC) que desea actualizar:");
        UUID codConsult = UUID.fromString(entrada.nextLine());

        System.out.println("Ingrese el nuevo UUID del expediente:");
        UUID newIdExpediente = UUID.fromString(entrada.nextLine());

        System.out.println("Ingrese el nuevo UUID del documento:");
        UUID newIdDocumento = UUID.fromString(entrada.nextLine());

        objDocumentoExpedienteCRUD.updateDocumentoExpediente(codConsult, newIdExpediente, newIdDocumento, connection);

        System.out.println("\n--- Lista de Expedientes y Documentos (Actualizada) ---");
        objDocumentoExpedienteCRUD.searchDocumentoExpediente(connection);

        //Metodo para eliminar Registros
        System.out.println("Ingrese el UUID del registro (idRelacionEC) que desea eliminar:");
        String codDelete= entrada.nextLine();

        objDocumentoExpedienteCRUD.deleteDocumentoExpediente(UUID.fromString(codDelete), connection);

        System.out.println("Nueva lista de RelacionEC");
        objDocumentoExpedienteCRUD.searchDocumentoExpediente(connection);

        SQLconnection.connect();

        // ----- Notas -----
        //Agregar Datos
        System.out.println("Ingrese el título de la nota:");
        String tituloNota = entrada.nextLine();

        System.out.println("Ingrese el contenido de la nota:");
        String contenidoNota = entrada.nextLine();

        System.out.println("Ingrese el UUID del creador de la nota:");
        UUID creadoPor = UUID.fromString(entrada.nextLine());

        System.out.println("Ingrese el tipo de nota (personal/relacionada):");
        String tipoNota = entrada.nextLine();

        System.out.println("Ingrese el ID de la Etapa Kanban (o presione Enter si no aplica):");
        String etapaInput = entrada.nextLine();
        EtapaKanban etapaKanban = null;
        if (!etapaInput.isBlank()) {
            etapaKanban = new EtapaKanban();
            etapaKanban.setIdEtapaKanban(Integer.parseInt(etapaInput));
        }

        Nota objNota = new Nota(tituloNota, contenidoNota, creadoPor, tipoNota, etapaKanban);
        NotaCRUD objNotaCRUD = new NotaCRUD();

        Connection connection=SQLconnection.connect();
        objNotaCRUD.addNota(objNota, connection);

        // Mostrar Datos
        System.out.println("\nLISTA DE NOTAS");
        objNotaCRUD.searchNota(connection);

        // Actualizar Datos
        System.out.println("\nIngrese el UUID de la nota a actualizar:");
        UUID idNota = UUID.fromString(entrada.nextLine());

        System.out.println("Ingrese el nuevo título:");
        String newTitulo = entrada.nextLine();

        System.out.println("Ingrese el nuevo contenido:");
        String newContenido = entrada.nextLine();

        System.out.println("Ingrese el nuevo tipo de nota:");
        String newTipo = entrada.nextLine();

        System.out.println("Ingrese el nuevo ID de la Etapa Kanban (o presione Enter si no aplica):");
        String newEtapaInput = entrada.nextLine();
        EtapaKanban newEtapa = null;
        if (!newEtapaInput.isBlank()) {
            newEtapa = new EtapaKanban();
            newEtapa.setIdEtapaKanban(Integer.parseInt(newEtapaInput));
        }

        objNotaCRUD.updateNota(idNota, newTitulo, newContenido, newTipo, newEtapa, connection);

        System.out.println("\nLista de Notas (Actualizada)");
        objNotaCRUD.searchNota(connection);

        // Eliminar Datos
        System.out.println("\nIngrese el UUID de la nota a eliminar:");
        UUID codDelete = UUID.fromString(entrada.nextLine());

        objNotaCRUD.deleteNota(codDelete, connection);

        System.out.println("\nLista de Notas (Actualizada)");
        objNotaCRUD.searchNota(connection);

        SQLconnection.connect();

        // ----- NotaRelacion -----
        // Agregar Datos
        System.out.println("Ingrese el UUID de la nota:");
        UUID idNota = UUID.fromString(entrada.nextLine());

        System.out.println("Ingrese el UUID del expediente (o ENTER si no aplica):");
        String inputExpediente = entrada.nextLine();
        UUID idExpediente = inputExpediente.isEmpty() ? null : UUID.fromString(inputExpediente);

        System.out.println("Ingrese el UUID del contacto (o ENTER si no aplica):");
        String inputContacto = entrada.nextLine();
        UUID idContacto = inputContacto.isEmpty() ? null : UUID.fromString(inputContacto);

        Nota nota = new Nota();
        nota.setIdNota(idNota);

        Expediente expediente = null;
        if (idExpediente != null) {
            expediente = new Expediente();
            expediente.setIdExpediente(idExpediente);
        }

        Contactos contacto = null;
        if (idContacto != null) {
            contacto = new Contactos();
            contacto.setIdContacto(idContacto);
        }

        NotaRelacion objNotaRelacion = new NotaRelacion(nota, expediente, contacto);
        NotaRelacionCRUD objNotaRelacionCRUD = new NotaRelacionCRUD();

        Connection connection = SQLconnection.connect();
        objNotaRelacionCRUD.addNotaRelacion(objNotaRelacion, connection);


        // Mostrar Datos
        System.out.println("\n--- Lista de Notas ---");
        objNotaRelacionCRUD.searchNotaRelacion(connection);

        // Actualizar Datos
        System.out.println("\nIngrese el UUID del registro (idRelacionN) que desea actualizar:");
        UUID codConsult = UUID.fromString(entrada.nextLine());

        System.out.println("Ingrese el nuevo UUID de la nota:");
        UUID newIdNota = UUID.fromString(entrada.nextLine());

        System.out.println("Ingrese el nuevo UUID del expediente (o ENTER si no aplica):");
        String newExpInput = entrada.nextLine();
        UUID newIdExpediente = newExpInput.isEmpty() ? null : UUID.fromString(newExpInput);

        System.out.println("Ingrese el nuevo UUID del contacto (o ENTER si no aplica):");
        String newContInput = entrada.nextLine();
        UUID newIdContacto = newContInput.isEmpty() ? null : UUID.fromString(newContInput);

        objNotaRelacionCRUD.updateNotaRelacion(codConsult, newIdNota, newIdExpediente, newIdContacto, connection);

        System.out.println("\n--- Lista de Notas Relacionadas (Actualizada) ---");
        objNotaRelacionCRUD.searchNotaRelacion(connection);

        // Eliminar Datos
        System.out.println("\nIngrese el UUID del registro (idRelacionN) que desea eliminar:");
        UUID codDelete = UUID.fromString(entrada.nextLine());

        objNotaRelacionCRUD.deleteNotaRelacion(codDelete, connection);

        System.out.println("\n--- Lista de Notas Relacionadas (Actualizada) ---");
        objNotaRelacionCRUD.searchNotaRelacion(connection);

        // ----- Tareas -----
        // Agregar Datos
        System.out.println("¿La tarea es privada? (true/false):");
        boolean esPrivado = Boolean.parseBoolean(entrada.nextLine());

        System.out.println("Ingrese el nombre de la tarea:");
        String nombre = entrada.nextLine();

        System.out.println("Ingrese la descripción de la tarea:");
        String descripcion = entrada.nextLine();

        System.out.println("Ingrese la fecha de vencimiento (YYYY-MM-DD):");
        Date fechaVencimiento = Date.valueOf(entrada.nextLine());

        System.out.println("Ingrese la prioridad ('Baja', 'Media', 'Alta', 'Urgente'):");
        String prioridad = entrada.nextLine();

        System.out.println("Ingrese el UUID del creador de la tarea:");
        UUID creadoPor = UUID.fromString(entrada.nextLine());

        System.out.println("Ingrese el ID de la Etapa Kanban (o presione Enter si no aplica):");
        String etapaInput = entrada.nextLine();
        EtapaKanban etapaKanban = null;
        if (!etapaInput.isBlank()) {
            etapaKanban = new EtapaKanban();
            etapaKanban.setIdEtapaKanban(Integer.parseInt(etapaInput));
        }

        Tarea objTarea = new Tarea(esPrivado, nombre, descripcion, fechaVencimiento, prioridad, creadoPor, etapaKanban);
        TareaCRUD objTareaCRUD = new TareaCRUD();

        Connection connection = SQLconnection.connect();
        objTareaCRUD.addTarea(objTarea, connection);

        // Mostrar Datos
        System.out.println("\nLISTA DE TAREAS");
        objTareaCRUD.searchTarea(connection);

        // Actualizar Datos
        System.out.println("\nIngrese el UUID de la tarea a actualizar:");
        UUID codConsult = UUID.fromString(entrada.nextLine());

        System.out.println("¿Nuevo valor de privacidad? (true/false):");
        boolean newEsPrivado = Boolean.parseBoolean(entrada.nextLine());

        System.out.println("Nuevo nombre:");
        String newNombre = entrada.nextLine();

        System.out.println("Nueva descripción:");
        String newDescripcion = entrada.nextLine();

        System.out.println("Nueva fecha de vencimiento (YYYY-MM-DD):");
        Date newFecha = Date.valueOf(entrada.nextLine());

        System.out.println("Nueva prioridad:");
        String newPrioridad = entrada.nextLine();

        System.out.println("Nuevo ID de Etapa Kanban (o presione Enter si no aplica):");
        String nuevoEtapaInput = entrada.nextLine();
        Integer nuevaEtapaId = null;
        if (!nuevoEtapaInput.isBlank()) {
            nuevaEtapaId = Integer.parseInt(nuevoEtapaInput);
        }

        objTareaCRUD.updateTarea(codConsult, newEsPrivado, newNombre, newDescripcion, newFecha, newPrioridad, nuevaEtapaId, connection);

        System.out.println("\nLISTA DE TAREAS (ACTUALIZADA)");
        objTareaCRUD.searchTarea(connection);

        // Eliminar Tarea
        System.out.println("\nIngrese el UUID de la tarea a eliminar:");
        UUID codDelete = UUID.fromString(entrada.nextLine());

        objTareaCRUD.deleteTarea(codDelete, connection);

        System.out.println("\nLISTA DE TAREAS (ACTUALIZADA)");
        objTareaCRUD.searchTarea(connection);

        // ----- Tarea Relacion -----
        // Agregar Datos
        System.out.println("Ingrese el UUID de la tarea:");
        UUID idTarea = UUID.fromString(entrada.nextLine());

        System.out.println("Ingrese el UUID del expediente (o ENTER si no aplica):");
        String inputExpediente = entrada.nextLine();
        UUID idExpediente = inputExpediente.isEmpty() ? null : UUID.fromString(inputExpediente);

        System.out.println("Ingrese el UUID del contacto (o ENTER si no aplica):");
        String inputContacto = entrada.nextLine();
        UUID idContacto = inputContacto.isEmpty() ? null : UUID.fromString(inputContacto);

        System.out.println("Ingrese el nombre de la persona asignada a la tarea:");
        String rolAsignado = entrada.nextLine();

        Tarea tarea = new Tarea();
        tarea.setIdTarea(idTarea);

        Expediente expediente = null;
        if (idExpediente != null) {
            expediente = new Expediente();
            expediente.setIdExpediente(idExpediente);
        }

        Contactos contacto = null;
        if (idContacto != null) {
            contacto = new Contactos();
            contacto.setIdContacto(idContacto);
        }

        TareaRelacion objTareaRelacion = new TareaRelacion(tarea, expediente, contacto, rolAsignado);
        TareaRelacionCRUD objTareaRelacionCRUD = new TareaRelacionCRUD();

        Connection connection=SQLconnection.connect();
        objTareaRelacionCRUD.addTareaRelacion(objTareaRelacion, connection);

        // Mostrar Datos
        System.out.println("\n--- Lista de Tareas Relacionadas ---");
        objTareaRelacionCRUD.searchTareaRelacion(connection);

        // Actualizar Datos
        System.out.println("\nIngrese el UUID del registro (idRelacionT) que desea actualizar:");
        UUID codConsult = UUID.fromString(entrada.nextLine());

        System.out.println("Ingrese el nuevo UUID de la tarea:");
        UUID newIdTarea = UUID.fromString(entrada.nextLine());

        System.out.println("Ingrese el nuevo UUID del expediente (o ENTER si no aplica):");
        String newExpInput = entrada.nextLine();
        UUID newIdExpediente = newExpInput.isEmpty() ? null : UUID.fromString(newExpInput);

        System.out.println("Ingrese el nuevo UUID del contacto (o ENTER si no aplica):");
        String newContInput = entrada.nextLine();
        UUID newIdContacto = newContInput.isEmpty() ? null : UUID.fromString(newContInput);

        System.out.println("Ingrese el nuevo nombre asignado:");
        String newRolAsignado = entrada.nextLine();

        objTareaRelacionCRUD.updateTareaRelacion(codConsult, newIdTarea, newIdExpediente, newIdContacto, newRolAsignado, connection);

        System.out.println("\n--- Lista de Tareas Relacionadas (Actualizada) ---");
        objTareaRelacionCRUD.searchTareaRelacion(connection);

        // Eliminar Datos
        System.out.println("\nIngrese el UUID del registro (idRelacionT) que desea eliminar:");
        UUID codDelete = UUID.fromString(entrada.nextLine());

        objTareaRelacionCRUD.deleteTareaRelacion(codDelete, connection);

        System.out.println("\n--- Lista de Tareas Relacionadas (Actualizada) ---");
        objTareaRelacionCRUD.searchTareaRelacion(connection);

        SQLconnection.connect();

        // ----- Eventos -----
        // Agregar Datos
        System.out.println("Ingrese el título del evento:");
        String titulo = entrada.nextLine();

        System.out.println("Ingrese la descripción del evento:");
        String descripcion = entrada.nextLine();

        System.out.println("Ingrese la fecha y hora de inicio (YYYY-MM-DDTHH:MM,  ej. 2024-04-15T10:00):");
        LocalDateTime fechaInicio = LocalDateTime.parse(entrada.nextLine());

        System.out.println("Ingrese la fecha y hora de fin (YYYY-MM-DDTHH:MM,  ej. 2024-04-15T10:00):");
        LocalDateTime fechaFin = LocalDateTime.parse(entrada.nextLine());

        System.out.println("¿Es un evento de todo el dia? (true/false):");
        Boolean allDay = Boolean.parseBoolean(entrada.nextLine());

        System.out.println("Ingrese la fecha y hora de recordatorio (YYYY-MM-DDTHH:MM), ej. 2024-04-15T10:00):");
        LocalDateTime recordatorio = LocalDateTime.parse(entrada.nextLine());

        System.out.println("Ingrese el tipo de evento (Reunion, Audiencia, Intake, otro, Sin Asignar):");
        String tipoEvento = entrada.nextLine();

        System.out.println("Ingrese el lugar del evento:");
        String lugar = entrada.nextLine();

        System.out.println("Ingrese el enlace o archivo adjunto del evento:");
        String adjunto = entrada.nextLine();

        System.out.println("Ingrese el UUID de quien creó el evento:");
        UUID creadoPor = UUID.fromString(entrada.nextLine());

        System.out.println("Ingrese el ID de etapa Kanban (o ENTER si no aplica):");
        String etapaInput = entrada.nextLine();
        EtapaKanban etapaKanban = null;
        if (!etapaInput.isEmpty()) {
            etapaKanban = new EtapaKanban();
            etapaKanban.setIdEtapaKanban(Integer.parseInt(etapaInput));
        }

        Evento objEvento = new Evento(titulo, descripcion, fechaInicio, fechaFin, allDay, recordatorio, tipoEvento, lugar, adjunto, creadoPor, etapaKanban);

        EventoCRUD objEventoCRUD = new EventoCRUD();

        Connection connection = SQLconnection.connect();
        objEventoCRUD.addEvento(objEvento, connection);


        // Mostrar eventos
        System.out.println("\n--- Lista de Eventos ---");
        objEventoCRUD.searchEvento(connection);

        // Actualizar evento
        System.out.println("\nIngrese el UUID del evento que desea actualizar:");
        UUID codConsult = UUID.fromString(entrada.nextLine());

        System.out.println("Ingrese el nuevo título del evento:");
        String newTitulo = entrada.nextLine();

        System.out.println("Ingrese la nueva descripción:");
        String newDescripcion = entrada.nextLine();

        System.out.println("Ingrese la nueva fecha y hora de inicio (YYYY-MM-DDTHH:MM):");
        LocalDateTime newFechaInicio = LocalDateTime.parse(entrada.nextLine());

        System.out.println("Ingrese la nueva fecha y hora de fin (YYYY-MM-DDTHH:MM):");
        LocalDateTime newFechaFin = LocalDateTime.parse(entrada.nextLine());

        System.out.println("¿Es todo el dia? (true/false):");
        Boolean newAllDay = Boolean.parseBoolean(entrada.nextLine());

        System.out.println("Ingrese el nuevo recordatorio (YYYY-MM-DDTHH:MM):");
        LocalDateTime newRecordatorio = LocalDateTime.parse(entrada.nextLine());

        System.out.println("Ingrese el nuevo tipo de evento:");
        String newTipoEvento = entrada.nextLine();

        System.out.println("Ingrese el nuevo lugar:");
        String newLugar = entrada.nextLine();

        System.out.println("Ingrese el nuevo adjunto:");
        String newAdjunto = entrada.nextLine();

        System.out.println("Ingrese el nuevo ID de etapa Kanban (o ENTER si no aplica):");
        String newEtapaInput = entrada.nextLine();
        EtapaKanban newEtapaKanban = null;
        if (!newEtapaInput.isEmpty()) {
            newEtapaKanban = new EtapaKanban();
            newEtapaKanban.setIdEtapaKanban(Integer.parseInt(newEtapaInput));
        }

        Evento eventoActualizado = new Evento(newTitulo, newDescripcion, newFechaInicio, newFechaFin, newAllDay, newRecordatorio, newTipoEvento, newLugar, newAdjunto, creadoPor, newEtapaKanban);

        objEventoCRUD.updateEvento(codConsult, eventoActualizado, connection);

        // Lista actualizada
        System.out.println("\n--- Lista de Eventos (Actualizada) ---");
        objEventoCRUD.searchEvento(connection);

        // Eliminar evento
        System.out.println("\nIngrese el UUID del evento que desea eliminar:");
        UUID codDelete = UUID.fromString(entrada.nextLine());

        objEventoCRUD.deleteEvento(codDelete, connection);

        System.out.println("\n--- Lista de Eventos (Actualizada) ---");
        objEventoCRUD.searchEvento(connection);

        SQLconnection.connect();

        // ----- Evento Relacion -----
        // Agregar Datos
        System.out.println("Ingrese el UUID del evento:");
        UUID idEvento = UUID.fromString(entrada.nextLine());

        System.out.println("Ingrese el UUID del expediente (o ENTER si no aplica):");
        String inputExpediente = entrada.nextLine();
        UUID idExpediente = inputExpediente.isEmpty() ? null : UUID.fromString(inputExpediente);

        System.out.println("Ingrese el UUID del contacto (o ENTER si no aplica):");
        String inputContacto = entrada.nextLine();
        UUID idContacto = inputContacto.isEmpty() ? null : UUID.fromString(inputContacto);

        // Crear objetos
        Evento evento = new Evento();
        evento.setIdEvento(idEvento);

        Expediente expediente = null;
        if (idExpediente != null) {
            expediente = new Expediente();
            expediente.setIdExpediente(idExpediente);
        }

        Contactos contacto = null;
        if (idContacto != null) {
            contacto = new Contactos();
            contacto.setIdContacto(idContacto);
        }

        EventoRelacion objEventoRelacion = new EventoRelacion(evento, expediente, contacto);
        EventoRelacionCRUD objEventoRelacionCRUD = new EventoRelacionCRUD();

        Connection connection = SQLconnection.connect();
        objEventoRelacionCRUD.addEventoRelacion(objEventoRelacion, connection);

        // Mostrar Datos
        System.out.println("\n--- Lista de Eventos Relacionados ---");
        objEventoRelacionCRUD.searchEventoRelacion(connection);

        // Actualizar Datos
        System.out.println("\nIngrese el UUID del registro (idRelacionE) que desea actualizar:");
        UUID codConsult = UUID.fromString(entrada.nextLine());

        System.out.println("Ingrese el nuevo UUID del evento:");
        UUID newIdEvento = UUID.fromString(entrada.nextLine());

        System.out.println("Ingrese el nuevo UUID del expediente (o ENTER si no aplica):");
        String newExpInput = entrada.nextLine();
        UUID newIdExpediente = newExpInput.isEmpty() ? null : UUID.fromString(newExpInput);

        System.out.println("Ingrese el nuevo UUID del contacto (o ENTER si no aplica):");
        String newContInput = entrada.nextLine();
        UUID newIdContacto = newContInput.isEmpty() ? null : UUID.fromString(newContInput);

        objEventoRelacionCRUD.updateEventoRelacion(codConsult, newIdEvento, newIdExpediente, newIdContacto, connection);

        System.out.println("\n--- Lista de Eventos Relacionados (Actualizada) ---");
        objEventoRelacionCRUD.searchEventoRelacion(connection);

        // Eliminar Datos
        System.out.println("\nIngrese el UUID del registro (idRelacionE) que desea eliminar:");
        UUID codDelete = UUID.fromString(entrada.nextLine());

        objEventoRelacionCRUD.deleteEventoRelacion(codDelete, connection);

        System.out.println("\n--- Lista de Eventos Relacionados (Actualizada) ---");
        objEventoRelacionCRUD.searchEventoRelacion(connection);

        connection.close();*/

        // ----- Notificaciones -----
        // Agregar Datos
        System.out.println("Ingrese el UUID del contacto:");
        UUID idContacto = UUID.fromString(entrada.nextLine());

        System.out.println("Ingrese el tipo de notificación (ej. Sistema, Evento, Alerta):");
        String tipo = entrada.nextLine();

        System.out.println("Ingrese el mensaje de la notificación:");
        String mensaje = entrada.nextLine();

        System.out.println("¿Está leída? (true/false):");
        boolean leida = Boolean.parseBoolean(entrada.nextLine());

        Contactos contacto = new Contactos();
        contacto.setIdContacto(idContacto);

        Notificaciones objNotificaciones = new Notificaciones(contacto, tipo, mensaje, leida);
        NotificacionesCRUD objNotificacionesCRUD = new NotificacionesCRUD();

        Connection connection = SQLconnection.connect();

        objNotificacionesCRUD.addNotificacion(objNotificaciones, connection);

        // Mostrar Datos
        System.out.println("\n--- Lista de Notificaciones ---");
        objNotificacionesCRUD.searchNotificaciones(connection);

        // Actualizar Datos
        System.out.println("\nIngrese el UUID de la notificación que desea actualizar:");
        UUID codConsult = UUID.fromString(entrada.nextLine());

        System.out.println("Ingrese el nuevo tipo de notificación:");
        String newTipo = entrada.nextLine();

        System.out.println("Ingrese el nuevo mensaje:");
        String newMensaje = entrada.nextLine();

        System.out.println("¿Está leída? (true/false):");
        boolean newLeida = Boolean.parseBoolean(entrada.nextLine());

        Notificaciones nuevaNotificacion = new Notificaciones(contacto, newTipo, newMensaje, newLeida);
        objNotificacionesCRUD.updateNotificacion(codConsult, nuevaNotificacion, connection);

        System.out.println("\n--- Lista de Notificaciones (Actualizada) ---");
        objNotificacionesCRUD.searchNotificaciones(connection);

        // Eliminar Datos
        System.out.println("\nIngrese el UUID de la notificación que desea eliminar:");
        UUID codDelete = UUID.fromString(entrada.nextLine());

        objNotificacionesCRUD.deleteNotificacion(codDelete, connection);

        System.out.println("\n--- Lista de Notificaciones (Final) ---");
        objNotificacionesCRUD.searchNotificaciones(connection);
    }
 }