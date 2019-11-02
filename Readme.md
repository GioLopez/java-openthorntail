# Ejemplo practico de  DDD con Full REST API con Java y Thorntail [En construccion]

> Restfull API with Java and Thorntail

La idea de este ejemplo es crear micro-servicios full rest API con Thorntail y Java, es importante saber hasta cuando y cuanto puedes segmentar tus servicios en micro-servicios y que es lo que te lleva a tomar esta decisión, porque en otras ocasiones es sabio utilizar monolíticos.
Que es importante a la hora de arquitecta:
- Obtener los requerimientos de tu cliente.
- Es súper importante que tu equipo de desarrollo y el negocio se entiendan, por lo tanto emplea lenguaje ubico y utiliza el DDD para esto.
- Segmenta a través de características o usos los servicios, con esto puede determinar cuales son similares y comenzar a darle verbos relacionados con el post, put, delete, get, path de HTTP.
- Creación del contrato para los/el servicio.

## Table of Contents

- [Definiciones](#definiciones)
- [Inicio](#inicio)
- [License](#license)

## Definiciones

### Bounded Contexts

Cada negocio tiene múltiples dominios como por ejemplo en una compañía puede tener área de ventas, diseño, ensamblaje y envíos, para cada uno de esos dominios la forma para referenciar los atributos o características de ese objeto que se esta produciendo son distintos, por eso es tan importante y DDD sugiere que al Arquitecto de software conozca bien cada uno de los dominios.

> Anécdota inventada

Tengo una experiencia donde se contrató el desarrollo de software por parte de una compañía para solucionar un problema que tenían en un dominio especifico de la empresa, el dueño explicó al arquitecto que era lo que se quería y se inició el desarrollo del software. Después de varias semanas se regresó con el producto, se desplegó y se realizó el cobro por el trabajo.
Un par de años después la compañía era mas grande, hasta otra razón social tenia y se les presentó un problema similar que podía ser resuelto a través de software, uno de los trabajadores se le ocurrió la idea de proponer al dueño que se contratará una empresa para que hiciera el diseño y desarrollo de software, entonces nos encontramos cara a cara nuevamente y su actitud no fue la mejor, hablamos y después de un par de minutos dijo: “[…] lo que me entregaron la ultima vez, no sirvió para nada! […]” y el problema no era mala construcción de software, el problema era que el lenguaje utilizado no era el mismo que empleaban las personas en ese dominio de la compañía, por lo que de inmediato se convirtió en un software basura. 

> Conclusión de la anécdota

Por eso es tan importante involucrar a las personas que interactúan con el sistema desarrollado y entender cuales son las cosas que para ellos son relevantes para el negocio y como se comunican normalmente, así transferir eso al software y crear algo mas util

### Event Storm

<a href="https://github.com/jgraph/drawio-desktop/issues/45"><img src=https://user-images.githubusercontent.com/1964655/41868241-627f4136-78ad-11e8-8912-9da26ec2db22.png" title="EventStorm" alt="EventStorm"></a>


# Esta parte inferior esta en construccion [Jejeje]

## Inicio

> Iniciar el proyecto con Throntail

1.	Ve a la pagina: https://thorntail.io/generator/
2.	Sigue las instrucciones
3.	Descarga el archivo
4.	Ejecuta el comando `mvn install` en el folder descomprimido para generar el target de tu app
5.  Ve al directorio target y ejecuta el comando `java -jar nombredetuapp-thorntail.jar`

Hasta acá tienes una aplicación restfull API que responde a http://localhost:8080/hello, entonces es hora de editarla para lograr la creación de tu app

### Bounded Context

A bounded context se le llamaría aquella porción del código que esta de cara a nuestro servicio, es ese enrutador que nos lleva al controlador. Un ejemplo de lo que se habló anteriormente:

```
@ApplicationPath("/api/boundedcontext/v1.0/")
@ApplicationPath("/api/usuario/v2.1.10/")
@ApplicationPath("/api/paquetes/v10.5/")
```

El Path se sugiere que lleve primero el boundend context, para poder discriminar entre diferentes servicios de la organización, a nivel de microprofiles y si no se presenta directamente al usuario es recomendable ser granular, es decir que cuando estemos creando nuestro micro servicio en el path del router seamos lo mas explicitos posibles, asi como en el ejemplo de arriba que se coloca el nombre del boundedcontext y la versión, hasta ese detalle debemos llegar 

## Referencias

- [https://www.infoq.com/presentations/microservices-ddd-bounded-contexts/]

## License

[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)

- **[MIT license](http://opensource.org/licenses/mit-license.php)**
