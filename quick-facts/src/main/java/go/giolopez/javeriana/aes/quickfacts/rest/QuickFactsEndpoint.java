package go.giolopez.javeriana.aes.quickfacts.rest;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@Path("quick-facts")
public class QuickFactsEndpoint {

    @Inject
    // export WEATHER_URL='http://localhost:8090/api/boundedcontext/v1.0/weather'
    @ConfigProperty(name = "weather.url", defaultValue = "http://weather_weather_1:8080/api/boundedcontext/v1.0/weather")
    private String weatherUrl;
    private Client weatherClient;
    private WebTarget target;

    @PostConstruct
    private void init(){
//        Se ejecuta antes de que este operativo pero luego que las inyecciones
//        pasen
        weatherClient = ClientBuilder.newClient();
//        La URL la vamos a inyectar de esta forma y no con el constructor
//        Para garantizar que el objeto este creado antes de ejecutarla
        target = weatherClient.target(weatherUrl);
    }

    @GET
    @Retry(maxRetries = 10, delay = 500, jitter = 50)
    @Fallback(fallbackMethod = "getQuickFactsFallback")
    @Produces(MediaType.APPLICATION_JSON)
    public QuickFactsModel getQuickFacts(@HeaderParam("gio.quickfacts.location") String loc){
        JsonObject response = target.queryParam("location", loc)
                .request(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(JsonObject.class);

        double temperature = response.getJsonNumber("temperature").doubleValue();

        return new QuickFactsModel(
                loc,
                "Algo sobre Bogota",
                temperature
        );
    }

    public QuickFactsModel getQuickFactsFallback(String loc) {
        return new QuickFactsModel(
                loc,
                "Bogotá officially Bogotá, Distrito Capital, abbreviated Bogotá, D.C., and formerly known as Santafé/Santa Fe de Bogotá between 1991 and 2000",
                0.0);
    }

    @PreDestroy
    public void finish(){
        weatherClient.close();
    }
}

