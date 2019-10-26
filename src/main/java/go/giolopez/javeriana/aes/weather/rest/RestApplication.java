package go.giolopez.javeriana.aes.weather.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api/boundedcontext/v1.0/")
public class RestApplication extends Application {
}

//El Path se sugiere que lleve primero el boundend context, para poder discriminar
//entre diferentes servicios de la organizacion, a nivel de microprofiles
//es necesario ser granular

//La idea es manejar bounded context, controlls and entities
//  Donde los endpoint serian los bounded
//  los controllers la logica de negocio
//  los entity

// Con thorntail por defecto tenemos los siguientes endpoints:
//      http://localhost:8080/openapi
//      http://localhost:8080/health
//      http://localhost:8080/metrics

//Imagenes para java:
// azul/zulu
// amazoncorreto

