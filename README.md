# Proyecto-Avante

## Configuración de Eclipse JEE (back-end)
Pasos:
* Establecer como workspace la carpeta *Proyecto* del repositorio en la copia local del ordenador.

![eclipse workspace](https://github.com/jucansu/Proyecto-Avante/blob/master/Documentaci%C3%B3n/Im%C3%A1genes/Readme/Eclipse%20workspace.png)

* Importar el proyecto como Maven Project. El nombre del proyecto **debe ser exactamente** Back-end.
* Es posible que surja algún error en las clases. Para solventar esto se debe comprobar que el RunTime está bien seleccionado. Para ello hacemos click derecho sobre el proyecto>Properties. Escribimos en el buscador facets y seleccionamos la única opción. Comprobamos que las opciones están tal y como se muestra en la siguiente imagen y hacemos click en Aplicar.
* Seguirán existiendo errores, esto se debe a que probablemente no estén los servidores implementados. Para ello, en la barra superior seleccionamos la opción Window>Show view>Servers. En la pestaña que se abrirá, hacemos click: y buscamos la opción Apache>Tomcat v8.5 tal y como se muestra en la imagen: Continuamos y seleccionamos la ruta donde esté instalado el Apache Tomcat 8.5. Se generará automáticamente la carpeta Servers.
* Haciendo click secundario sobre la vista de Servers en el server Tomcat 8.5, seleccionamos la opción *Add and remove...*. En la ventana que se abrirá, se selecciona el proyecto PepeBlog haciendo doble click en él y se pulsa el botón *Finish*
