package go.giolopez.javeriana.aes.quickfacts.rest;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@Path("quick-facts")
public class QuickFactsEndpoint {

    @Inject
    @ConfigProperty(name = "weather.url")
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
    public QuickFactsModel getQuickFacts(@HeaderParam("gio.quickfacts.location") String loc){
        JsonObject response = target.queryParam("location", loc)
                .request(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(JsonObject.class);

        double temperature = response.getJsonNumber("tempemperature").doubleValue();

        return new QuickFactsModel(
                loc,
                "Algo sobre Bogota",
                temperature
        );


    }

    @PreDestroy
    public void finish(){
        weatherClient.close();
    }
}

