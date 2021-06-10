# Título del Proyecto

En este proyecto utilizo lo practicado en el proyecto de HilosJava para hacer un Chat funcional con despliegue en Java swing

## Comenzando 🚀

Para recoger el proyecto has de ir al apartado VSC de tu entorno de desarrollo (la aplicacion que uses para programar) y buscar la pestaña que gestiona 
los imports de repositorios git, tras ello utilizando la url y tu identificacion de gitHub lo hara automaticamente.


### Pre-requisitos 📋

Necesitaras un entorno de desarrollo, una jdk java instalada y el Xamp (u otro genereador de BBDD)


### Funcionamiento 🔧

Una vez recogido el proyecto del git y abierto con el entorno que utilices, asegurate de haber abierto una bbdd local con el nombre que especifica la practica.
Tras ello asegurate de que los ID están en orden, es decir, que si tienes 100 entradas el ID ha de empezar en 1, y acabar en 100, si algun ID por medio esta corrupto
(no va en orden) probablemente devuelva null en el valor de un ingreso.

Si has iniciado bien la base de datos, y los ID estan colocados correctamente, la consola deberia devolver lo siguiente;

```
ACCESO SECUENCIAL: 
La suma es: 4834
Ha tardado: 281



ACCESO CONCURRENTE: 
La suma es: 4834
Ha tardado: 27

```

El acceso secuencial representa un solo hilo, el cual lee los registros y lo suma de uno en uno.

Por otra partem el concurrente son 5 hilos que trabajan simultaneamente, repartiendose la carga de trabajo.


## Ejecutando las pruebas ⚙️

Para probar que funciona simplemente verifica en tu base de datos si se suman correctamente los ingresos


## Despliegue 📦

Puedes ejecutarlo tambien con el jar desde la cmd, el jar esta en el gitHub, simplemente recojelo y ponlo en una localizacion de la que te acuerdes.
Posteriormente accede a la cmd y busca esta localizacion, posteriormente ingresa este comando “java '-jar nombredelarchivo. jar”.

Asegurate de que el xamp o el programa que utilices para la bbdd este funcionando


## Construido con 🛠️

* Eclipse (probablemente el peor entorno que se puede elegir)


## Versionado 📌

He utilizado Java 8 y el mySQL Connector 5.0.2

## Autores ✒️

* **Alejandro Casado** 

