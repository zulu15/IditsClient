package com.zulu.idits.fragmentos;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.zulu.idits.R;
import com.zulu.idits.adaptador.CursosAdaptador;
import com.zulu.idits.adaptador.SimpleDividerItemDecoration;
import com.zulu.idits.modelo.Curso;
import java.util.ArrayList;


public class Cursos extends Fragment implements CursosAdaptador.OnCursoSelectedListener {
    public RecyclerView rv;
    public CursosAdaptador adapter;
    public ArrayList<Curso> cursos = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        cursos.add(new Curso(1,"ADMINISTRACIÓN BÁSICA DE LINUX", "Mendoza", 10,
        "\n" +"\nCapitulo 1: Introducción a Linux.\n\n" +
                "   Conceptos Básicos.\n" +
                "   Introducción OEL.\n" +
                "   Creación VM.\n" +
                "   Configuraciones adicionales.\n\n" +
                "Capitulo 2: Shell's.\n\n" +
                "   Tipos de Shell's.\n\n" +
                "Capitulo 3: Usuarios y grupos.\n\n" +
                "   Gestión de usuarios y grupos.\n\n" +
                "Capitulo 4: File System's.\n\n" +
                "   Gestión de archivos y directorios.\n\n" +
                "Capitulo 5: Gestión de File System's.\n\n" +
                "   Tipos de File System's.\n" +
                "   Discos y particiones.\n" +
                "   LVM.\n" +
                "   Gestión LVM.\n\n" +
                "Capitulo 6: Procesos.\n\n" +
                "   Gestión de Procesos.\n\n" +
                "Capitulo 7: Permisos.\n\n" +
                "   Gestión de permisos.\n\n" +
                "Capitulo 8: Shell Scripts.\n\n" +
                "   Editor Vi.\n" +
                "   Entradas y Salidas.\n" +
                "   Variables.\n" +
                "   Filtros."));
        cursos.add(new Curso(2,"ADMINISTRACIÓN DE POSTGRESQL", "Buenos Aires", 20,
                "\n1. Introducción a PostgreSQL\n" +
                "2. SQL en General\n" +
                "3. Laboratorio de SQL\n" +
                "4. Arquitectura\n" +
                "5. Laboratorio de Arquitectura\n" +
                "6. Monitoreo y Mantenimiento\n" +
                "7. Laboratorio de Monitoreo y Mantenimiento\n" +
                "8. Configuración de Postgresql\n" +
                "9. Laboratorio de Configuración\n" +
                "10. http://comunidad.siu.edu.ar/foro/index.php?board=17.0\n" +
                "11. Movimientos de Datos\n" +
                "12. Backup Continuo PITR\n" +
                "13. Indices, Constraints y Vistas\n" +
                "14. Optimización de Consultas\n" +
                "15. Manejo de Fechas\n" +
                "16. Funciones y Triggers\n" +
                "17. Optimización de Consultas\n" +
                "18. Stored Procedures\n" +
                "19. Triggers"));
        cursos.add(new Curso(3,"ADMINISTRACIÓN DE PROYECTOS", "San Juan", 30,
                "\nConceptos básicos de Gestión de proyectos\n" +
                "1. ¿Qué es un proyecto?\n" +
                "2. ¿Qué es la dirección de proyectos?\n" +
                "3. Dirección de proyectos\n" +
                "4. Dirección de programas\n" +
                "5. Gestión del portfolio de proyectos\n" +
                "6. Rol del director de proyectos\n" +
                "7. Proyecto versus Producto/servicio.\n" +
                "8. Ciclo de vida de un proyecto\n" +
                "9. Proyectos y Tareas Operativas\n" +
                "10. La dirección de proyectos dentro de la organización\n" +
                "11. Cultura y estilos\n" +
                "12. Estructuras\n" +
                "13. Principales problemas o errores en la ejecución de proyectos\n" +
                "14. ¿Por qué fallan los proyectos?\n" +
                "15. Ejemplos de grandes….. fracasos\n" +
                "16. Mejores prácticas, buenas prácticas en la gestión de proyectos\n" +
                "17. Triple…cuádruple, quíntuple restricción.\n" +
                "18. ¿Qué es un PM? ¿Cuál es el Rol del PM?\n" +
                "19. ¿Qué es una PMO?"));
        cursos.add(new Curso(4,"ADMINISTRACION DE REDES  NIVEL 1", "Mendoza", 30,
                "1. Cronograma – Módulos o Unidad – Contenidos\n" +
                "2. Conceptos básicos de Redes y comunicaciones de datos.\n" +
                "3. Los estándares de referencia OSI y de implantación TCP/IP.\n" +
                "4. Protocolos de supervisión y control de redes.\n" +
                "5. Comunicaciones locales, metropolitanas y de área extendida.\n" +
                "6. Infraestructura moderna de comunicaciones.\n" +
                "7. Comunicaciones futuras: SDH e IP v6"));
        cursos.add(new Curso(5,"ADMINISTRACIÓN DE SQL SERVER", "Mendoza", 30,
                "1. Introducción a Bases de Datos\n" +
                        "2. Introducción al Lenguaje SQL\n" +
                        "3. Introducción a SQL Server\n" +
                        "4. Creación de Bases de Datos\n" +
                        "5. Creación de Tipos de Datos y Tablas\n" +
                        "6. Usando XML\n" +
                        "7. Índices\n" +
                        "8. Integridad de Datos\n" +
                        "9. Vistas\n" +
                        "10. Procedimientos Almacenados\n" +
                        "11. Funciones\n" +
                        "12. Transacciones y Bloqueos\n" +
                        "13. Código Manejado en la Base de Datos\n" +
                        "14. Mantenimiento\n" +
                        "15. Instalación y Configuración\n" +
                        "16. Recuperación de Desastres\n" +
                        "17. Manejo de Seguridad\n" +
                        "18. Monitoreo de SQL Server\n" +
                        "19. Automatización de Tareas Administrativas\n" +
                        "20. Replicación\n" +
                        "21. • Mantenimiento de Alta Disponibilidad"));
        cursos.add(new Curso(6,"ADMINISTRADOR DE BASE DE DATOS", "Mendoza", 30,
                "1. Módulo 1:\n" +
                        "2. Concepto de base de datos. Información integrada y compartida.\n" +
                        "3. Ventajas del enfoque de base de datos.\n" +
                        "4. Independencia de los datos.\n" +
                        "5. Los tres niveles de la arquitectura de un sistema de bases de datos.\n" +
                        "6. Lenguaje de definición de datos, lenguaje de manipulación de datos y lenguaje de control\n" +
                        "7. de datos.\n" +
                        "8. Acceso a bases de datos. Paginación, bloques y archivos.\n" +
                        "9. Indexación. Tipos de Índices. Técnica de Hashing.\n" +
                        "\n" +
                        "10. Módulo 2\n" +
                        "11. Diseño del modelo de Entidad Relación.\n" +
                        "12. Formas normales. Dependencias funcionales. Desnormalización.\n" +
                        "13. Diseño de Bases de datos relacionales.\n" +
                        "\n" +
                        "14. Módulo 3\n" +
                        "15. MySQL\n" +
                        "16. Lenguaje Estructurado de Consulta: SQL.\n" +
                        "17. Creando tablas. Tipos de datos. Insertar datos. Seleccionar datos. Modificar datos. Borrado\n" +
                        "18. de datos\n" +
                        "19. Consultas y vistas. Operadores en MySQL. Operadores de comparación. Operaciones con\n" +
                        "20. Cadenas. Operadores lógicos. Ordenando. Inner Joins. Left Joins\n" +
                        "21. Datos por defecto\n" +
                        "22. Optimización de consultas\n" +
                        "23. Seguridad de MySQL. Revocando privilegios\n" +
                        "24. Ejemplo\n" +
                        "25. Catálogos.\n" +
                        "\n" +
                        "26. Módulo 4\n" +
                        "27. Arquitecturas de procesamiento de base de datos multi-usuaios. Transacciones\n" +
                        "28. Confiabilidad: concurrencia, recuperación y seguridad."));
        cursos.add(new Curso(7,"ADMINISTRADOR DE SEGURIDAD INFORMÁTICA", "Mendoza", 30,
                "Capítulo 1.- SEGURIDAD DE LA INFORMACION\n" +
                        "Definición de Seguridad informática y Seguridad de la información\n" +
                        "Triangulo fundamental de la seguridad informática (CIA)\n" +
                        "Explicación de Bugs, Exploits, Amenazas, Contramedidas y Riesgo\n" +
                        "Tipos de atacantes\n" +
                        "Penetration Test vs Analisis de Vulnerabilidades\n" +
                        "Ambientes de testeo\n" +
                        "Metodología básica de Hacking\n" +
                        "Capítulo 2.- FUNDAMENTOS DE REDES Y SEGURIDAD\n" +
                        "Direcciones MAC y Direcciones IP\n" +
                        "Modelo OSI\n" +
                        "TCP/IP\n" +
                        "Protocolos: IP, TCP, UDP, HTTP, DHCP, HTTPS, Telnet, SSH\n" +
                        "Puertos y Servicios\n" +
                        "Switching\n" +
                        "VLAN\n" +
                        "Features de seguridad de Switches\n" +
                        "Proxy\n" +
                        "Anonimato en la Red\n" +
                        "Capítulo 3.- FOOTPRINTING Y SCANNING\n" +
                        "Definición de: Footprinting y Scanning\n" +
                        "Google Hacking\n" +
                        "Practicas de Footprinting (RIRs y NICs)\n" +
                        "Traceroute\n" +
                        "Escaneo de Puertos\n" +
                        "Detección de Servicios\n" +
                        "Escaneo de Vulnerabilidades\n" +
                        "Capítulo 4.- INGENIERIA SOCIAL Y MALWARE\n" +
                        "Ingeniería Social\n" +
                        "Phishing\n" +
                        "Definición de Malware\n" +
                        "Tipos de Malware\n" +
                        "Virus. Troyanos. Rootkits. Spyware. Keyloggers. Botnet\n" +
                        "Contramedidas: Seguridad EndPoint y NAC\n" +
                        "Capítulo 5.- WINDOWS HACKING\n" +
                        "Arquitectura de Windows\n" +
                        "SMB Null Sessions: Ataque y contramedidas\n" +
                        "Métodos de autenticación\n" +
                        "LM\n" +
                        "SAM\n" +
                        "Crackeo de Claves\n" +
                        "Contramedidas\n" +
                        "Capítulo 6.-WEB HACKING\n" +
                        "Arquitectura web\n" +
                        "Funcionamiento del Browser\n" +
                        "Protocolo HTTP\n" +
                        "Autenticación\n" +
                        "Protocolo HTTPS\n" +
                        "IIS\n" +
                        "Apache\n" +
                        "OWASP TOP 10\n" +
                        "Ataques: SQL Injection, XSS, Path Traversal\n" +
                        "Contramedidas\n" +
                        "Capítulo 7.- CONTRAMEDIDAS Y SGSI\n" +
                        "Seguridad perimetral: Firewall, IDS/IPS, WAF, UTM, VPN, DMZ\n" +
                        "WSUS\n" +
                        "Hardening\n" +
                        "SGSI: Sistema de Gestión de la seguridad de la Información\n" +
                        "Políticas, normas y procedimientos de seguridad\n" +
                        "CIO: Oficial de Seguridad\n" +
                        "Certificaciones Internacionales de Seguridad"));
        cursos.add(new Curso(8,"ALFABETIZACIÓN DIGITAL - NIVEL 1", "Mendoza", 30,
                "ABC de la Economía Digital: Principios y tendencias. Teletrabajo. Comercio Electrónico. Negocios Electrónicos. Diferencias entre Comercio y Negocios Electrónicos. Gobierno Electrónico. Nuevos Modelos de Negocios (B2B, B2C, etc.).\n" +
                        "Claves del éxito de los Negocios por Internet: Tasa de Conversión. Desarrollo de Canales Alternativos. Decisión de Compra Online. Orientación al Cliente: Web 2.0.\n" +
                        "Elementos Vitales para tener un Negocio Online: Tecnología, Marketing, Logística y Operaciones.\n" +
                        "Introducción al Marketing en Buscadores y Posicionamiento Web: SEO (Search Engine Optimization) y SEM (Search Engine Marketing)."));
        cursos.add(new Curso(9,"ALFABETIZACIÓN DIGITAL - NIVEL 2", "Mendoza", 30,
        "1. Presentación del curso y metodología de trabajo. Partes de una computadora. Uso del ratón. Creación carpetas.\n" +
                "2. Identificar los distintos programas y sus funciones. Abrir y cerrar programas. Crear archivos, guardarlos, cambiar nombre, administrarlos y buscarlos.\n" +
                "3. Nociones básicas de internet. Conocer los navegadores, criterios de búsqueda, creación de cuentas de correo electrónico.\n" +
                "4. Visión general de editor de gráficos. Conocer Microsoft Paint, pintar formas y líneas, hacer cambios a imágenes y formas.\n" +
                "5. Visión general editor de dibujos. Usar herramientas de dibujo en word, cambiar aspecto de líneas y formas, agregar palabras a un cuadro de texto, agregar imágenes.\n" +
                "6. Visión general procesador de textos. Conocer Microsoft Word, digitar y modificar palabras, cambiar el aspecto del texto y los párrafos, agregar imágenes y efectos especiales.\n" +
                "7. Visión general del administrador de hojas de cálculo. Conocer Microsoft excel, seleccionar celdas, filas y columnas, agregar y trabajar con información, operaciones y funciones básicas.\n" +
                "8. Visión general del presentador multimedial. Conocer Microsoft Power Point. Visualizar y trabajar con diapositivas. Crear presentaciones. Mejorar el aspecto de las diapositivas. Agregar palabras, imágenes, videos. Agregar animaciones y efectos especiales.\n" +
                "9. Profundización, integración y práctica del editor de gráficos y administrador de hoja de cálculos en actividades de un docente. Herramientas de dibujo,diseño de páginas, trabajar con tablas y columnas, cálculos matemátios (sumas, restas, promedios)\n" +
                "10. Profundización, integración y práctica del procesador de texto y hojas de cálculo en actividades de un profesional de la salud. Cambiar aspecto de palabras, diseño de página, características preconfiguradas y avanzadas. Cálculos matemáticos (sumas, restas, promedios)\n" +
                "11. Profundización, integración y práctica del editor de dibujos y gráficos, presentador multimedial, cálculos matemáticos y nociones de administración de proyectos en actividades de un ingeniero.\n" +
                "12. Profundización, integración y práctica del editor de dibujos y gráficos, presentador multimedial, cálculos matemáticos y nociones de administración de proyectos en actividades de un ingeniero.\n" +
                "13. Profundización, integración y práctica de todos los programas utilizados y nociones generales de armado de proyectos en actividades de un emprendedor.\n" +
                "14. Profundización, integración y práctica de todos los programas utilizados y nociones generales de armado de proyectos en actividades de un emprendedor.\n" +
                "15. Repaso general. Diseño de proyecto final de integración en equipos de 2 personas.\n" +
                "16. Ejecución de proyecto final de integración en equipos de 2 personas.\n" +
                "17. Finalización y puesta en común de los proyectos. Cierre del curso. "));
        cursos.add(new Curso(10,"ANALISTA CONTABLE CON SISTEMA DE GESTIÓN SAP", "Mendoza", 30,
                "1. Presentación del curso y metodología de trabajo. Repaso de lo visto en 1er nivel. Crear y Administrar Archivos (crearlos, guardarlos, buscarlos)\n" +
                        "2. Repaso de Funciones Básicas del Microsoft Paint.\n" +
                        "3. Repaso de Funciones Básicas de Microsoft Word.\n" +
                        "4. Repaso de Funciones básicas de Microsoft Excel.\n" +
                        "5. Repaso de Funciones básicas de Power Point.\n" +
                        "6. Utilización de Internet. Correo Electrónico, buscar información, descargar, adjuntar archivos.\n" +
                        "7. Utilización de Internet. Correo Electrónico, buscar información, descargar, adjuntar archivos.\n" +
                        "8. Profundización de Word: efectos especiales, agrupar, uso del corrector ortográfico. Diseño y redacción de textos formales (CV, carta de presentación, solicitudes, reclamos, etc). Introducción a la creación páginas web. Funciones avanzadas de Diseño de Párrafo (texto en columnas, letra capital, etc.)\n" +
                        "9. Creación de Paginas Web y Funciones avanzadas de diseño de parrafo (letra capital, texto en columnas, etc). Profundicación de Excel. Funciones avanzadas (condiciones -.si-), estadísticas, gráficos avanzados (cambios de apariencia, tramas, colores selectivos,etc), armado de presupuestos, cálculo de costos, caja diaria.\n" +
                        "10. Continuamos con funciones avanzadas de la Hoja de cálculo\n" +
                        "11. Profundización de Power Point/ Presentador Multimedial: agregar sonidos, películas, vínculos y animaciónes.\n" +
                        "12. Creación de un Proyecto de Integración de los conceptos trabajados hasta el momento.\n" +
                        "13. Ejecución y Revisión del Proyecto.\n" +
                        "14. Diseño de un proyecto vinculado a la comunidad o al trabajo a elección.\n" +
                        "15. ejecución del Proyecto.\n" +
                        "16. Revisión\n" +
                        "Puesta en común y cierre."));


        View cursosView = inflater.inflate(R.layout.layout_recycler_view, container, false);

        rv = (RecyclerView) cursosView.findViewById(R.id.recyclerViewCursos);
        rv.setHasFixedSize(true);

        //Le pasamos el contexto al adaptador y el listener que escuchara cuando
        //un curso sea seleccionado
        adapter = new CursosAdaptador(cursos,getActivity(),this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(mLayoutManager);
        rv.addItemDecoration(new SimpleDividerItemDecoration(rv.getContext()));
        rv.setAdapter(adapter);

        return cursosView;
    }


    @Override
    public void onCursoSelected(CursosAdaptador.CursoViewHolder cursoViewHolder, Curso curso) {

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.addToBackStack(this.toString()); //Se agrega el objeto a la pila para poder regresar a la lista de cursos

        CursoDetalle fragmentoCursoDetalle = new CursoDetalle(); //Se crea dinámicamente el fragmento

        Bundle b = new Bundle();
        b.putInt("idcurso", curso.retornaId());
        b.putString("nombre",curso.retornaNombre());
        b.putString("contenido", curso.retornaContenido());

        fragmentoCursoDetalle.setArguments(b);

//        Toast.makeText(getActivity(),"Se selecciono el curso: "+curso.retornaNombre(),Toast.LENGTH_SHORT).show();
        ft.replace(R.id.fragment_container, fragmentoCursoDetalle);

        ft.commit();
    }

}
