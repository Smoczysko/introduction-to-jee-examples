package pl.edu.ug.introductiontojee.jaxrs.client.api;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

@Path("weather")
public class MessagesResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@QueryParam("city") String city) {
        Client client = ClientBuilder.newClient();
        JsonObject apiData = client.target("http://api.openweathermap.org/data/2.5/weather?q=" + city).request().get(JsonObject.class);

        JsonObjectBuilder weatherData = Json.createObjectBuilder();
        JsonObject main = apiData.getJsonObject("main");

        weatherData.add("pressure", main.getJsonNumber("pressure").toString() + " hPa");
        weatherData.add("humidity", main.getJsonNumber("humidity").toString() + "%");
        Double temperature = main.getJsonNumber("temp").doubleValue() - 273.15;
        weatherData.add("temperature", temperature.toString() + " C");

        JsonObjectBuilder infoData = Json.createObjectBuilder();
        infoData.add("city", apiData.getString("name"));
        infoData.add("countryCode", apiData.getJsonObject("sys").getString("country"));
        JsonObject cords = apiData.getJsonObject("coord");
        infoData.add("latitude", cords.getJsonNumber("lat").toString());
        infoData.add("longitude", cords.getJsonNumber("lon").toString());

        JsonObject response = Json.createObjectBuilder().add("info", infoData.build()).add("weather", weatherData.build()).build();

        return Response.status(Response.Status.OK).entity(response).build();
    }
}
