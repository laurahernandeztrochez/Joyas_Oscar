Proyecto integrador para un negocio llamado Joyas Oscar, un programa funcional que le ayude a gestionar mucho mejor su negocio y no hacerlo manualmente. 
realizado por: Jhosep Nuñez, Laura Hernandez y Juan Pablo Toro

La forma de ejecutarlo: Es necesario tener alguna  aplicacion que permita ver-leer codigos, como Visual code o Apache Netbeans
Descargar el proyecto en > code > https://github.com/laurahernandeztrochez/Joyas_Oscar.git 
clonarlo en netbeans al iniciar arriba en el menu "team" > git > clon > pegar el link del repositorio > next > elegir en que parte de tu computador lo guardas > constraseña vacia, dale a next > repositorio clonado
AVISO: ES NECESARIO TENER LA BASE DE DATOS RELACIONADA DESCARGADA PARA QUE EL PROYECTO CORRA
Requisitos: MySQL workbench
Abrir MySQL workbench y conectarse > crear un schema llamado 'joyasoscar'
> server > data import > import from Self-Contained File > seleccionar joyasoscar.sql y start import
ya con estos pasos, deberia correr exitosamente el programa

## Conectar con una base de datos en otra computadora

La conexión usa `localhost` por defecto. Si MySQL está en otra computadora,
configura su dirección IP o nombre de equipo antes de iniciar la aplicación.
Se puede configurar mediante variables de entorno (`JOYAS_DB_HOST`,
`JOYAS_DB_PORT`, `JOYAS_DB_NAME`, `JOYAS_DB_USER` y `JOYAS_DB_PASSWORD`) o
propiedades de Java (`joyas.db.host`, `joyas.db.port`, `joyas.db.name`,
`joyas.db.user` y `joyas.db.password`). Las propiedades de Java tienen
prioridad; los valores predeterminados son `localhost`, `3306`, `joyasoscar`,
`root` y la configuración local ya existente.

Por ejemplo, en las opciones de la máquina virtual de NetBeans se puede
configurar `-Djoyas.db.host=192.168.1.50` usando la IP real del equipo servidor.
El servidor MySQL también debe aceptar conexiones desde la computadora cliente,
el usuario configurado debe tener permisos sobre `joyasoscar` y el puerto
configurado debe estar accesible en la red local. No expongas MySQL directamente
a Internet.
