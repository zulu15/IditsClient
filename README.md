# Idits Client
Aplicación creada para el curso de desarrollo de aplicaciones móviles dictado en el instituto Idits. Nuestra idea fue presentar una aplicación móvil que funcionara al estilo del sistema web de inscripción que ya posee el instituto http://www.empleartec.org.ar/.

### Funcionalidades:
- La aplicacion se compone de tres pantalla principales:

#### Home:
La pantalla de Home cuenta con un slider de fotos análogo al de la página original. Y una descripción del instituto y cuales son los organismos que apoyan el plan de capacitaciones gratuitas.

<p align="center">
  <img src="https://cloud.githubusercontent.com/assets/13476233/20125964/26131298-a610-11e6-99e8-4712811b9fb2.png" width="350"/>
</p>  

#### Cursos:

La pantalla de Cursos cuenta un listado de cursos seleccionables que una vez seleccionado el de interes para el usuario se procede a mostrar su "detalle" descripcion, contenidos, requisitos del curso y un botón de inscribirse.

<p align="center">
  <img src="https://cloud.githubusercontent.com/assets/13476233/20125962/26090a46-a610-11e6-9433-7e9bbb86f830.png" width="350"/>
</p>  



#### Formulario:
Esta pantalla permite al usuario darse de alta en el sistema sin aún estar registrado en ningún curso. Una vez que se validan los datos ingresados del usuario se envian sus datos al servidor y además se guarda una copia de dchos en una base de datos local. Que funciona como cache en el caso de que el usuario no cuente con conexión a internet poder ver sus datos y editarlos si así lo desea.


<p align="center">
  <img src="https://cloud.githubusercontent.com/assets/13476233/20125963/260e7d1e-a610-11e6-8a38-20f8e419ba45.png" width="350"/>
</p>  



### Tecnologías Utilizadas:

 * `Material Design` Para el diseño de la interfaz de usuario.
 * `SQLITE` Para el almacenamiento local de los datos.
 * `PHP y MYSQL` Para el desarrollo del webservice.



###Integrantes:

  * Joaquin Sanchez
  * Esteban Santillan
  * Matias Paredes



