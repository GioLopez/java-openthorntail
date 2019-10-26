package go.giolopez.javeriana.aes.weather.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("weather")
public class WeatherEndpoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public WeatherModel getWeather(@QueryParam("location") String loc){
        return new WeatherModel(loc, 12.05);
    }
}
