
-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 08-11-2016 a las 03:56:45
-- Versión del servidor: 10.0.20-MariaDB-log
-- Versión de PHP: 5.2.17

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `u315318447_idits`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE IF NOT EXISTS `cursos` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion` text COLLATE utf8_spanish2_ci NOT NULL,
  `carga_horaria` tinyint(3) unsigned NOT NULL,
  `contenidos` text COLLATE utf8_spanish2_ci NOT NULL,
  `requisitos` text COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci AUTO_INCREMENT=11 ;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`id`, `nombre`, `descripcion`, `carga_horaria`, `contenidos`, `requisitos`) VALUES
(1, 'ADMINISTRACIÓN BÁSICA DE LINUX', 'Es un curso diseñado para quienes deseen adquirir rápidamente capacidades prácticas de administración Linux', 80, 'Capitulo 1: Introducción a Linux.\r\n\r\n   Conceptos Básicos.\r\n\r\n   Introducción OEL.\r\n\r\n   Creación VM.\r\n\r\n   Configuraciones adicionales.\r\n\r\nCapitulo 2: Shell''s.\r\n\r\n   Tipos de Shell''s.\r\n\r\nCapitulo 3: Usuarios y grupos.\r\n\r\n   Gestión de usuarios y grupos.\r\n\r\nCapitulo 4: File System''s.\r\n\r\n   Gestión de archivos y directorios.\r\n\r\nCapitulo 5: Gestión de File System''s.\r\n\r\n   Tipos de File System''s.\r\n\r\n   Discos y particiones.\r\n\r\n   LVM.\r\n\r\n   Gestión LVM.\r\n\r\nCapitulo 6: Procesos.\r\n\r\n   Gestión de Procesos.\r\n\r\nCapitulo 7: Permisos.\r\n\r\n   Gestión de permisos.\r\n\r\nCapitulo 8: Shell Scripts.\r\n\r\n   Editor Vi.\r\n\r\n   Entradas y Salidas.\r\n\r\n   Variables.\r\n\r\n   Filtros.', 'Conocimientos en Herramientas Office y sistema Operativo Windows\r\n\r\n'),
(2, 'ADMINISTRACIÓN DE POSTGRESQL', 'Curso de conceptos básicos de bases de datos y de administración del poderoso motor de software libre PostgreSQL.\r\n\r\n', 80, '1. Introducción a PostgreSQL\r\n2. SQL en General\r\n3. Laboratorio de SQL\r\n4. Arquitectura\r\n5. Laboratorio de Arquitectura\r\n6. Monitoreo y Mantenimiento\r\n7. Laboratorio de Monitoreo y Mantenimiento\r\n8. Configuración de Postgresql\r\n9. Laboratorio de Configuración\r\n10. http://comunidad.siu.edu.ar/foro/index.php?board=17.0\r\n11. Movimientos de Datos\r\n12. Backup Continuo PITR\r\n13. Indices, Constraints y Vistas\r\n14. Optimización de Consultas\r\n15. Manejo de Fechas\r\n16. Funciones y Triggers\r\n17. Optimización de Consultas\r\n18. Stored Procedures\r\n19. Triggers', 'Conocimientos en Herramientas Office y sistema Operativo Windows\r\n\r\n'),
(3, 'ADMINISTRACIÓN DE PROYECTOS', 'El Programa propone brindar las herramientas y la metodología propuesta por el Project Management Institute (PMI) para administrar proyectos como un Gerente de Proyectos Profesional (Project Manager). Las organizaciones viven de y por los proyectos. Estos nacen, se desarrollan y cumplen con objetivos determinados y de su correcta planificación y control depende si son exitosos o no. En este curso se proporcionarán los conocimientos necesarios para la gestión profesional de proyectos y conocerás en detalle los procesos que la componen, lo que te permitirá dirigir proyectos, sin importar su tipo o la industria en la que te desempeñas, aplicando las mejoras prácticas del mercado. Durante la cursada se elaborarán todos los documentos necesarios para gestionar profesionalmente de principio a fin un proyecto. Asimismo, el programa comprende la utilización del Microsoft Project, el software más utilizado para la administración profesional de proyectos. Por último se brindarán nociones de Fundamentos de Liderazgo y herramientas interpersonales, que todo gerente de proyecto debe dominar.', 80, 'Conceptos básicos de Gestión de proyectos\r\n1. ¿Qué es un proyecto?\r\n2. ¿Qué es la dirección de proyectos?\r\n3. Dirección de proyectos\r\n4. Dirección de programas\r\n5. Gestión del portfolio de proyectos\r\n6. Rol del director de proyectos\r\n7. Proyecto versus Producto/servicio.\r\n8. Ciclo de vida de un proyecto\r\n9. Proyectos y Tareas Operativas\r\n10. La dirección de proyectos dentro de la organización\r\n11. Cultura y estilos\r\n12. Estructuras\r\n13. Principales problemas o errores en la ejecución de proyectos\r\n14. ¿Por qué fallan los proyectos?\r\n15. Ejemplos de grandes….. fracasos\r\n16. Mejores prácticas, buenas prácticas en la gestión de proyectos\r\n17. Triple…cuádruple, quíntuple restricción.\r\n18. ¿Qué es un PM? ¿Cuál es el Rol del PM?\r\n19. ¿Qué es una PMO?\r\n20. Diferentes tipos de oficinas de gestión de proyectos Cuestiones “blandas” en la gestión de un\r\n21. proyecto\r\n22. ¿Quién es el Sponsor?\r\n23. ¿Quién es el usuario?\r\n24. ¿A quiénes afecta este proyecto?\r\n25. Interesados de un proyecto\r\n26. Cómo identificar para gestionar los requerimientos y las expectativas de cada interesado\r\n27. Errores más comunes relacionados a la “no gestión de los interesados”\r\n28. Gestión de los recursos humanos: como armar para gestionar un equipo de trabajo y no fracasar en el\r\n29. intento (y que no fracase el proyecto…)\r\n30. Calidad del proyecto versus Calidad del producto Cuestiones “duras” en la gestión de un proyecto\r\n31. Definir los objetivos\r\n32. Definir el alcance de un proyecto\r\n33. Requerimientos y Requisitos\r\n34. Riesgos dentro de un proyecto: Yo no creo en brujas, pero que las hay…. las hay!-\r\n35. Entregables, tareas, actividades\r\n36. Planificación de un proyecto; errores más comunes\r\n37. Control y ejecución de un proyecto\r\n38. Cierre del proyecto; Lecciones aprendidas\r\n39. Introducción al Liderazgo\r\n40. Qué es el Liderazgo\r\n41. Liderazgo versus Poder\r\n42. ¿Se hace o se nace?\r\n43. Diferencia entre Management y Liderazgo\r\n44. Tareas fundamentales del líder\r\n45. Características del líder\r\n46. Estilos de Liderazgo\r\n47. Características de líderes exitosos\r\n48. La actitud y el entorno\r\n49. Competencias clave de los líderes\r\n50. Comunicación y el poder de la palabra\r\n51. El líder que escucha y entiende a las personas\r\n52. Negociación y resolución de conflictos\r\n53. Líder desarrollador de líderes\r\n54. Introducción al Liderazgo Personal\r\n55. Qué es el liderazgo personal\r\n56. Efectividad Personal\r\n57. Proactividad y responsabilidad\r\n58. Tomar la iniciativa\r\n59. Lenguaje reactivo versus lenguaje proactivo www.educacionIT.com.ar | Tel. (54) (011) 4328-0457\r\n60. Página 2\r\n61. Lavalle 648 – 8to Piso – Capital Federal\r\n62. Copyright 2014-Actualidad, educacionIT. Todos los derechos están reservados\r\n63. Educación IT\r\n64. Los círculos de preocupación e influencia\r\n65. Técnicas de persuasión\r\n66. Objetivos Personales\r\n67. Definición de objetivos personales\r\n68. El master plan\r\n69. Roles y metas\r\n70. El manejo del tiempo\r\n71. El valor de la asertividad\r\n72. Introducción al Liderazgo de Equipos\r\n73. La diferencia entre jefe y líder\r\n74. Qué debe hacer un líder de equipos\r\n75. La inteligencia emocional y el liderazgo\r\n76. Liderar con el ejemplo\r\n77. La función clásica del gerente\r\n78. Tareas delegables e indelegables del Líder\r\n79. ¿Qué hace trabajar a las personas?\r\n80. Impacto del líder en el equipo de trabajo\r\n81. Definición de objetivos de equipo\r\n82. El valor del feedback\r\n83. El tiempo del líder y la delegación\r\n84. El líder motivador\r\n85. El líder coach\r\n86. Manejo de relaciones hacia arriba\r\n87. La red de contactos del líder\r\n88. Introducción al Liderazgo de Organizaciones\r\n89. Ley de la navegación\r\n90. La alineación estratégica\r\n91. Visión, misión y valores\r\n92. La claridad de objetivos\r\n93. Construcción de la confianza\r\n94. El líder que conecta con la gente\r\n95. Claridad de comunicación\r\n96. El círculo íntimo del líder\r\n97. La ley del apoyo al líder\r\n98. El valor del sacrificio\r\n99. Decisiones difíciles del líder\r\n100. Project Management: Introducción\r\n101. ¿Qué es un proyecto?\r\n102. ¿Qué es la dirección de proyectos?\r\n103. PMI y PMBOK\r\n104. Dirección de proyectos\r\n105. Dirección de programas\r\n106. Gestión del portfolio de proyectos\r\n107. Rol del director de proyectos\r\n108. Proyecto versus Producto/servicio\r\n109. Ciclo de vida de un proyecto\r\n110. Proyectos y Tareas Operativas\r\n111. La dirección de proyectos dentro de la organización\r\n112. Cultura y estilos\r\n113. Estructuras\r\n114. Mapa de procesos\r\n115. Triple restricción\r\n116. Gestión del Alcance\r\n117. Iniciación de un proyecto, redacción del Acta de constitución del proyecto\r\n118. Recolección de requisitos y requerimientos\r\n119. Identificación de Supuestos\r\n120. Identificación de los riesgos principales de un proyecto\r\n121. Identificar el producto del proyecto\r\n122. Entregables\r\n123. Del producto del proyecto\r\n124. De la Gestión del proyecto\r\n125. Estructuración del proyecto\r\n126. Segregación de entregables en tareas y paquetes de trabajo\r\n127. Confección de una EDT o estructura de desglose de trabajo Actividades, Recursos y Cronograma\r\n128. Definición de Actividades, tareas, paquetes de trabajo.\r\n129. Definir la secuencia de las actividades;\r\n130. Tipos de relación entre actividades\r\n131. www.educacionIT.com.ar | Tel. (54) (011) 4328-0457\r\n132. Página 3\r\n133. Lavalle 648 – 8to Piso – Capital Federal\r\n134. Copyright 2014-Actualidad, educacionIT. Todos los derechos están reservados\r\n135. Educación IT\r\n136. Estimación de duración\r\n137. Estimación de Costos\r\n138. Técnicas de compresión del cronograma\r\n139. Camino o Ruta critica\r\n140. Confección del cronograma\r\n141. Línea base del tiempo\r\n142. Gestión del Costo\r\n143. Estimación de costos\r\n144. Determinación del presupuesto\r\n145. Control del presupuesto\r\n146. Estimación de costos por Actividad\r\n147. Gestión de la Calidad\r\n148. Planificando la calidad del proyecto\r\n149. Asegurando la Calidad del proyecto\r\n150. Controlando la Calidad\r\n151. Distintas Metodologías, técnicas y herramientas de Calidad\r\n152. Mejora continua\r\n153. Plan de Calidad del Proyecto\r\n154. Gestión de los Recursos Humanos\r\n155. Desarrollo del plan de gestión de los recursos humanos\r\n156. Armado del equipo de trabajo\r\n157. Desarrollo del equipo de trabajo\r\n158. Gestión del equipo de trabajo\r\n159. Plan de Gestión de los Recursos Humanos\r\n160. Matriz de roles y responsabilidades\r\n161. Gestión de las Comunicaciones\r\n162. Identificación de Interesados de un proyecto\r\n163. Planificación de las necesidades de comunicación de y para el equipo.\r\n164. Gestionando a los interesados\r\n165. Reuniones efectivas\r\n166. Registro de Interesados\r\n167. Matriz de comunicaciones\r\n168. Plan de Comunicaciones\r\n169. Gestión del Riesgo\r\n170. ¿Por qué hay que planificar la gestión de riesgos?\r\n171. Planificación de Riesgos\r\n172. Distintos tipos de respuesta a riesgos\r\n173. Gestión de riesgos\r\n174. Identificación, clasificación, cuantificación, respuesta a riesgos\r\n175. Monitoreo y control\r\n176. Plan de Gestión de Riesgos\r\n177. Registro de riesgos\r\n178. Gestión de las Adquisiciones\r\n179. Planificación de las adquisiciones\r\n180. Gestionar las adquisiciones\r\n181. Plan de adquisiciones\r\n182. Gestión de la Integración de un proyecto\r\n183. Procesos de Integración del proyecto\r\n184. Plan Integral de Gestión del proyecto\r\n185. Dirección integral del proyecto\r\n186. Monitoreo del proyecto\r\n187. Gestión de cambios\r\n188. Cierre de un Proyecto\r\n189. Cierre de tareas/issues pendientes\r\n190. Cierre de riesgos\r\n191. Cierre de las adquisiciones\r\n192. Lecciones aprendidas de un proyecto\r\n193. Informe final del proyecto\r\n\r\nREQUISITOS', 'Conocimientos en Herramientas Office y sistema Operativo Windows\r\n\r\n'),
(4, 'ADMINISTRACION DE REDES – NIVEL 1', 'En este primer nivel se hace una introducción al funcionamiento de las redes de computadoras, se estudian los protocolos sobre los cuales las mismas funcionan y se analiza en profundidad el Modelo de Comunicaciones de OSI, partiendo desde la capa de aplicación hasta llegar a la capa física; comprendiendo así los conceptos de dirección IP, puerto, protocolo, entre otros. Se utiliza un software de simulación para plantear problemáticas y dar la oportunidad al alumno de resolverlas, finalmente se hace una introducción sobre el cableado estructurado y el diseño de redes.\r\n\r\nDÓNDE SE DICTA', 80, '1. Cronograma – Módulos o Unidad – Contenidos \r\n2. Conceptos básicos de Redes y comunicaciones de datos. \r\n3. Los estándares de referencia OSI y de implantación TCP/IP. \r\n4. Protocolos de supervisión y control de redes. \r\n5. Comunicaciones locales, metropolitanas y de área extendida. \r\n6. Infraestructura moderna de comunicaciones. \r\n7. Comunicaciones futuras: SDH e IP v6', 'Conocimientos en Herramientas Office y sistema Operativo Windows\r\n\r\n'),
(5, 'ADMINISTRACIÓN DE SQL SERVER', 'Los egresados de la carrera de Administración de SQL Server estarán preparados para cubrir las habilidades universales necesarias para el manejo de Bases de Datos, Tipos de Datos, Tablas, Sentencias, Introducción de la Programación CON T-SQL, Procedimientos crear tienda, disparadores, etc.\r\n\r\n', 80, '1. Introducción a Bases de Datos\r\n2. Introducción al Lenguaje SQL\r\n3. Introducción a SQL Server \r\n4. Creación de Bases de Datos\r\n5. Creación de Tipos de Datos y Tablas\r\n6. Usando XML \r\n7. Índices\r\n8. Integridad de Datos\r\n9. Vistas\r\n10. Procedimientos Almacenados\r\n11. Funciones\r\n12. Transacciones y Bloqueos\r\n13. Código Manejado en la Base de Datos\r\n14. Mantenimiento\r\n15. Instalación y Configuración\r\n16. Recuperación de Desastres\r\n17. Manejo de Seguridad\r\n18. Monitoreo de SQL Server\r\n19. Automatización de Tareas Administrativas\r\n20. Replicación\r\n21. • Mantenimiento de Alta Disponibilidad\r\n\r\n', 'Tener conocimientos básicos de base de datos relacionales. Por ejemplo teoría de bases de datos y diferencias entre base de datos y planilla de cálculos.'),
(6, 'ADMINISTRADOR DE BASE DE DATOS', '\r\nQue el alumno aprenda a diseñar y administrar una base de datos relacional. Que el alumno pueda diseñar tablas y manipular datos de la Base de Datos MySQL. Que el alumno distinga las técnicas de recuperación y concurrencia en sistemas de base de datos multiusuario, como así también, las políticas de seguridad de los mismos.\r\n\r\n', 80, '1. Módulo 1:\r\n2. Concepto de base de datos. Información integrada y compartida.\r\n3. Ventajas del enfoque de base de datos.\r\n4. Independencia de los datos.\r\n5. Los tres niveles de la arquitectura de un sistema de bases de datos.\r\n6. Lenguaje de definición de datos, lenguaje de manipulación de datos y lenguaje de control\r\n7. de datos.\r\n8. Acceso a bases de datos. Paginación, bloques y archivos.\r\n9. Indexación. Tipos de Índices. Técnica de Hashing.\r\n\r\n10. Módulo 2\r\n11. Diseño del modelo de Entidad Relación.\r\n12. Formas normales. Dependencias funcionales. Desnormalización.\r\n13. Diseño de Bases de datos relacionales.\r\n\r\n14. Módulo 3\r\n15. MySQL\r\n16. Lenguaje Estructurado de Consulta: SQL.\r\n17. Creando tablas. Tipos de datos. Insertar datos. Seleccionar datos. Modificar datos. Borrado\r\n18. de datos\r\n19. Consultas y vistas. Operadores en MySQL. Operadores de comparación. Operaciones con\r\n20. Cadenas. Operadores lógicos. Ordenando. Inner Joins. Left Joins\r\n21. Datos por defecto\r\n22. Optimización de consultas\r\n23. Seguridad de MySQL. Revocando privilegios\r\n24. Ejemplo\r\n25. Catálogos.\r\n\r\n26. Módulo 4\r\n27. Arquitecturas de procesamiento de base de datos multi-usuaios. Transacciones\r\n28. Confiabilidad: concurrencia, recuperación y seguridad.', 'Conocimientos en Herramientas Office y sistema Operativo Windows\r\n\r\n'),
(7, 'ADMINISTRADOR DE SEGURIDAD INFORMÁTICA', 'El egresado del curso podrá, aportar a la formación de especialistas en todos los aspectos técnicos y profesionales de la Seguridad Informática. Desarrollar la capacidad de detección y análisis de riesgos tecnológicos y la generación de sus contramedidas. -Desarrollar la capacidad de generar contramedidas que no impacten sobre la operatividad de los sistema\r\n\r\n', 80, 'Capítulo 1.- SEGURIDAD DE LA INFORMACION\r\nDefinición de Seguridad informática y Seguridad de la información\r\nTriangulo fundamental de la seguridad informática (CIA)\r\nExplicación de Bugs, Exploits, Amenazas, Contramedidas y Riesgo\r\nTipos de atacantes\r\nPenetration Test vs Analisis de Vulnerabilidades\r\nAmbientes de testeo\r\nMetodología básica de Hacking\r\nCapítulo 2.- FUNDAMENTOS DE REDES Y SEGURIDAD\r\nDirecciones MAC y Direcciones IP\r\nModelo OSI\r\nTCP/IP\r\nProtocolos: IP, TCP, UDP, HTTP, DHCP, HTTPS, Telnet, SSH\r\nPuertos y Servicios\r\nSwitching\r\nVLAN\r\nFeatures de seguridad de Switches\r\nProxy\r\nAnonimato en la Red\r\nCapítulo 3.- FOOTPRINTING Y SCANNING\r\nDefinición de: Footprinting y Scanning\r\nGoogle Hacking\r\nPracticas de Footprinting (RIRs y NICs)\r\nTraceroute\r\nEscaneo de Puertos\r\nDetección de Servicios\r\nEscaneo de Vulnerabilidades\r\nCapítulo 4.- INGENIERIA SOCIAL Y MALWARE\r\nIngeniería Social\r\nPhishing\r\nDefinición de Malware\r\nTipos de Malware\r\nVirus. Troyanos. Rootkits. Spyware. Keyloggers. Botnet\r\nContramedidas: Seguridad EndPoint y NAC\r\nCapítulo 5.- WINDOWS HACKING\r\nArquitectura de Windows\r\nSMB Null Sessions: Ataque y contramedidas\r\nMétodos de autenticación\r\nLM\r\nSAM\r\nCrackeo de Claves\r\nContramedidas\r\nCapítulo 6.-WEB HACKING\r\nArquitectura web\r\nFuncionamiento del Browser\r\nProtocolo HTTP\r\nAutenticación\r\nProtocolo HTTPS\r\nIIS\r\nApache\r\nOWASP TOP 10\r\nAtaques: SQL Injection, XSS, Path Traversal\r\nContramedidas\r\nCapítulo 7.- CONTRAMEDIDAS Y SGSI\r\nSeguridad perimetral: Firewall, IDS/IPS, WAF, UTM, VPN, DMZ\r\nWSUS\r\nHardening\r\nSGSI: Sistema de Gestión de la seguridad de la Información\r\nPolíticas, normas y procedimientos de seguridad\r\nCIO: Oficial de Seguridad\r\nCertificaciones Internacionales de Seguridad\r\n\r\n', 'Conocimientos en Herramientas Office y sistema Operativo Windows\r\n\r\n'),
(8, 'ALFABETIZACIÓN DIGITAL - NIVEL 1', 'Cursos de alfabetización digital dictados en dos niveles. En los mismos se enseñarán contenidos básicos sobre el uso de la PC y los programas y aplicaciones de uso cotidiano.\r\n\r\nDÓNDE SE DICTA', 50, '1. Presentación del curso y metodología de trabajo. Partes de una computadora. Uso del ratón. Creación carpetas. \r\n2. Identificar los distintos programas y sus funciones. Abrir y cerrar programas. Crear archivos, guardarlos, cambiar nombre, administrarlos y buscarlos. \r\n3. Nociones básicas de internet. Conocer los navegadores, criterios de búsqueda, creación de cuentas de correo electrónico. \r\n4. Visión general de editor de gráficos. Conocer Microsoft Paint, pintar formas y líneas, hacer cambios a imágenes y formas. \r\n5. Visión general editor de dibujos. Usar herramientas de dibujo en word, cambiar aspecto de líneas y formas, agregar palabras a un cuadro de texto, agregar imágenes. \r\n6. Visión general procesador de textos. Conocer Microsoft Word, digitar y modificar palabras, cambiar el aspecto del texto y los párrafos, agregar imágenes y efectos especiales. \r\n7. Visión general del administrador de hojas de cálculo. Conocer Microsoft excel, seleccionar celdas, filas y columnas, agregar y trabajar con información, operaciones y funciones básicas.\r\n8. Visión general del presentador multimedial. Conocer Microsoft Power Point. Visualizar y trabajar con diapositivas. Crear presentaciones. Mejorar el aspecto de las diapositivas. Agregar palabras, imágenes, videos. Agregar animaciones y efectos especiales. \r\n9. Profundización, integración y práctica del editor de gráficos y administrador de hoja de cálculos en actividades de un docente. Herramientas de dibujo,diseño de páginas, trabajar con tablas y columnas, cálculos matemátios (sumas, restas, promedios) \r\n10. Profundización, integración y práctica del procesador de texto y hojas de cálculo en actividades de un profesional de la salud. Cambiar aspecto de palabras, diseño de página, características preconfiguradas y avanzadas. Cálculos matemáticos (sumas, restas, promedios) \r\n11. Profundización, integración y práctica del editor de dibujos y gráficos, presentador multimedial, cálculos matemáticos y nociones de administración de proyectos en actividades de un ingeniero. \r\n12. Profundización, integración y práctica del editor de dibujos y gráficos, presentador multimedial, cálculos matemáticos y nociones de administración de proyectos en actividades de un ingeniero. \r\n13. Profundización, integración y práctica de todos los programas utilizados y nociones generales de armado de proyectos en actividades de un emprendedor. \r\n14. Profundización, integración y práctica de todos los programas utilizados y nociones generales de armado de proyectos en actividades de un emprendedor. \r\n15. Repaso general. Diseño de proyecto final de integración en equipos de 2 personas. \r\n16. Ejecución de proyecto final de integración en equipos de 2 personas. \r\n17. Finalización y puesta en común de los proyectos. Cierre del curso. \r\n', 'NO'),
(9, 'ALFABETIZACIÓN DIGITAL - NIVEL 2', 'Cursos de alfabetización digital dictados en dos niveles. En los mismos se enseñarán contenidos básicos sobre el uso de la PC y los programas y aplicaciones de uso cotidiano.\r\n\r\nDÓNDE SE DICTA', 50, '1. Presentación del curso y metodología de trabajo. Repaso de lo visto en 1er nivel. Crear y Administrar Archivos (crearlos, guardarlos, buscarlos)\r\n2. Repaso de Funciones Básicas del Microsoft Paint.\r\n3. Repaso de Funciones Básicas de Microsoft Word.\r\n4. Repaso de Funciones básicas de Microsoft Excel.\r\n5. Repaso de Funciones básicas de Power Point.\r\n6. Utilización de Internet. Correo Electrónico, buscar información, descargar, adjuntar archivos.\r\n7. Utilización de Internet. Correo Electrónico, buscar información, descargar, adjuntar archivos.\r\n8. Profundización de Word: efectos especiales, agrupar, uso del corrector ortográfico. Diseño y redacción de textos formales (CV, carta de presentación, solicitudes, reclamos, etc). Introducción a la creación páginas web. Funciones avanzadas de Diseño de Párrafo (texto en columnas, letra capital, etc.)\r\n9. Creación de Paginas Web y Funciones avanzadas de diseño de parrafo (letra capital, texto en columnas, etc). Profundicación de Excel. Funciones avanzadas (condiciones -.si-), estadísticas, gráficos avanzados (cambios de apariencia, tramas, colores selectivos,etc), armado de presupuestos, cálculo de costos, caja diaria.\r\n10. Continuamos con funciones avanzadas de la Hoja de cálculo\r\n11. Profundización de Power Point/ Presentador Multimedial: agregar sonidos, películas, vínculos y animaciónes.\r\n12. Creación de un Proyecto de Integración de los conceptos trabajados hasta el momento.\r\n13. Ejecución y Revisión del Proyecto.\r\n14. Diseño de un proyecto vinculado a la comunidad o al trabajo a elección.\r\n15. ejecución del Proyecto.\r\n16. Revisión \r\nPuesta en común y cierre.', 'NO'),
(10, 'ANALISTA CONTABLE CON SISTEMA DE GESTIÓN SAP', 'El curso de Introducción al Sistema de Gestión SAP permitirá explicar la terminología utilizada por SAP. Proporcionará al alumno una visión general de las soluciones empresariales de SAP y desarrollará los conocimientos básicos a nivel usuario. Aprenderá los principales conceptos y capacidades de SAP NetWeaver, SAP ERP, SAP Business Suite y Soluciones SAP BusinessObjects.\r\n\r\nDÓNDE SE DICTA', 80, '1. Modulo A Contabilidad general y procesos administrativos de cuentas a pagar\r\n2. Unidad 1: Visión general de Contabilidad.\r\n? Estructura organizacional.\r\n? Estructura de departamentos de administracion y finanzas.\r\n? Estructura de departamentos de compras.\r\n3. Integración entre los diferentes sectores de la empresa.\r\n4. Unidad 2 Visión general de procesos en la contabilidad financiera.\r\n? Procesos de negociones del departamento de administracion.\r\n? Procesos de negociones del departamento de compras.\r\n5. . Procesos de negociones involucrados en cuentas a pagar.\r\n6. Unidad 3 Conceptos de contabilidad.\r\n7. . – Cuentas y plan de cuentas.\r\n8. . – Proceso de Registración contable.\r\n9. . – La partida doble.\r\n10. . – Libros mayores y libros auxiliares.\r\n11. . – Registro de operaciones básicas.\r\n12. Practicas de la lección.\r\n13. Unidad 4 Proceso de cierre contable.\r\n? Balances de sumas y saldos.\r\n14. . Proceso de cierre de balances.\r\n15. . Tareas del proceso contable\r\n16. . Elaboración del balance y del estado de resultado.\r\n17. Practicas de registraciones contables en el libro diario.\r\n18. Practicas de control de cuentas.\r\n19. Practicas de elaboración de informes.\r\n\r\n20. Modulo B Sistema de gestión empresarial SAP.\r\n21. Unidad 1: Sistemas de gestión empresarial\r\n? Qué es un ERP\r\n? Cuáles son los ERP del mercado\r\n? Qué es SAP\r\n? Principales diferencias entre los sistemas OLAP y OLTP\r\n22. Unidad 2: Introducción a SAP y los componentes ERP\r\n? SAP. La empresa y evolución\r\n? Descripción de la contabilidad financiera (FI)\r\n? Descripción de la contabilidad de costos (CO)\r\n23. _ Descripción de la gestión de Materiales (MM)\r\n? Descripción de la venta y la distribución (SD)\r\n? Descripción del control y la planificación de la producción (PP)\r\n? Descripción de Recursos Humanos (HR)\r\n24. Unidad 3: Introducción al módulo de finanzas. .\r\n? Cuáles son los componentes de la contabilidad financiera (FI)\r\n? Cuáles son las tareas del proceso de análisis contable estandarizadas por el sistema.\r\n25. _ Integración modular y base de datos homogénea.\r\n26. Unidad 4: Introducción al entorno SAP\r\n? Cómo logearse al sistema\r\n? Descripción del entorno de menú Access\r\n? Detalle de la barra de herramientas\r\n? Cómo personalizar el entorno\r\n27. Unidad 5: Conceptos Básicos en la contabilidad financiera (FI) en SAP\r\n? Estructura básica organizacional en la contabilidad financiera (FI)\r\n? Conceptos básicos de Mandante / sociedad / división en FI\r\n? Monedas y tipos de cambio\r\n? Conceptos de datos maestros y transaccionales\r\n? Definición de documentos contables\r\n28. Unidad 6: Creación de datos maestros en la contabilidad financiera (FI)\r\n- Estructura de datos maestros en SAP\r\n? Estructura de las cuentas de mayor\r\n? Estructura de las cuentas de activos fijos.\r\n? Cómo crear datos maestros de cuentas en finanzas\r\n- Como crear datos maestros de activos fijos en finanzas.\r\n29. Practicas de creación de datos maestros.\r\n30. Unidad 7: Estructura de documentos\r\n? Estructura de documento contable.\r\n? Clases de documentos estándar en SAP\r\n? Claves de contabilización.\r\n? Carga de documentos contables y asientos.\r\n31. Practicas de carga de documentos contables.\r\n32. Unidad 8: Control de contabilizaciones\r\n? Control de modificación de documentos\r\n? Anulación de documentos\r\n33. Practica de la unidad\r\n34. Unidad 9: Sistemas de información en la contabilidad financiera (FI)\r\n? Tipos de reportes en la contabilidad financiera.\r\n? Reportes de saldos en cuentas de mayor.\r\n35. ? Reporte de balance y estados de resultados.', 'Conocimientos en la herramienta office y en sistemas operativos.\r\n\r\n');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
