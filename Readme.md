# Crear a Full REST API con Java and Thorntail

> Restfull API with Java and Thorntail

La idea de este ejemplo es crear micro-servicios full rest API con Thorntail y Java, es importante saber hasta cuando y cuanto puedes segmentar tus servicios en micro-servicios y que es lo que te lleva a tomar esta decisión, porque en otras ocasiones es sabio utilizar monolíticos.
Que es importante a la hora de arquitecta:
- Obtener los requerimientos de tu cliente.
- Es súper importante que tu equipo de desarrollo y el negocio se entiendan, por lo tanto emplea lenguaje ubico y utiliza el DDD para esto.
- Segmenta a través de características o usos los servicios, con esto puede determinar cuales son similares y comenzar a darle verbos relacionados con el post, put, delete, get, path de HTTP.
- Creación del contrato para los/el servicio.

## Table of Contents

- [Inicio](#inicio)
- [License](#license)

## Inicio

> Iniciar el proyecto con Throntail

1.	Ve a la pagina: https://thorntail.io/generator/
2.	Sigue las instrucciones
3.	Descarga el archivo
4.	Ejecuta el comando `mvn install` en el folder descomprimido para generar el target de tu app
5.  Ve al directorio target y ejecuta el comando `java -jar nombredetuapp-thorntail.jar`

Hasta acá tienes una aplicación restfull API que responde a http://localhost:8080/hello, entonces es hora de editarla para lograr la creación de tu app



## License

[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)

- **[MIT license](http://opensource.org/licenses/mit-license.php)**
