# Instrucciones de uso
Reto final módulo backend KrugerStar

1. Componentes del proyecto
Este proyecto incluye:
  - Backend, basado en microservicios con Spring Boot
  - Frontend, que utiliza React + Vite

2. Modo de uso.- El proyecto solo corre en local, por lo que se necesita ejecutar cada programa de manera distinta mediante terminal o con un IDE
- Para el frontend, en cuanto se encuentre en el directorio "front", debe realizar una instalación de dependencias npm, usando "npm i". Una vez instalados, ejecuta el comando "npm run dev"
- Para el backend, se debe ejecutar en el siguiente orden los direfentes microservicios:
  1. Discovery server
  2. Patient microservice
  3. Medical test
  4. Api gateway
  
## Funciones
Se definió dos entidades para este reto: Medical test y Patients. Estas entidades son el núcleo de cada microservicio y están conectados a una base de datos diferente. 
Cada microservicio implementa un CRUD para el tipo de entidad específica, por lo que se puede utilizarlo a través del front de este proyecto o a través de herramientas que simulan clientes como Postman o Insomnia. 

La funcionalidad se basa en dos actividades:
1. Obtener una lista de todos los pacientes, con el riesgo médico asociado a c/u
2. Obtener un detalle de todos los exámenes que tiene registrado un paciente, con el cálculo de riesgo en c/examen

## Features pendientes
1. Validación desde el front para enviar directamente el valor del riesgo médico al crear un examen
2. Creación de un http interceptor para cambiar el atributo medical risk y operar segun los demás atributos
3. Creación de formularios/inputs para guardar examenes y pacientes desde el front
4. Autorización de usuarios


