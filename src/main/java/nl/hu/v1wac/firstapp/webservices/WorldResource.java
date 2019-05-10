package nl.hu.v1wac.firstapp.webservices;

import javax.json.*;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.Path;

import nl.hu.v1wac.firstapp.webservices.ServiceProvider;

@Path("/countries/")
public class WorldResource {
	
	public WorldService ws = ServiceProvider.getWorldService();
	
	public JsonObjectBuilder tmplCountry(Country c) {
		JsonObjectBuilder job = Json.createObjectBuilder();
		
		job.add("code", c.getCode());
        job.add("name", c.getName());
        job.add("capital", c.getCapital());
        job.add("surface", c.getSurface());
        job.add("government", c.getGovernment());
        job.add("lat", c.getLatitude());
        job.add("iso3", c.getIso3());
        job.add("continent", c.getContinent());
        job.add("region", c.getRegion());
        job.add("population", c.getPopulation());
        job.add("lng", c.getLongitude());
	
        return job;
	}

	@GET
	@Produces("application/json")
	public String allCountries() {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Country c : ws.getAllCountries()) {
			jab.add(tmplCountry(c));
		}
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@GET
	@Produces("application/json")
	@Path("{code}")
	public String country(@PathParam("code") String code) {
		Country c = ws.getCountryByCode(code);
		
		return tmplCountry(c).build().toString();
	}
	
	@GET
	@Path("/largestsurfaces")
	@Produces("application/json")
	public String getLargestSurfaces() {
		JsonArrayBuilder jab = Json.createArrayBuilder();
				
			for (Country c : ws.get10LargestSurfaces()) {
				jab.add(tmplCountry(c));
			}
			JsonArray array = jab.build();
			return array.toString();
	}
	
	@GET
	@Path("/largestpopulations")
	@Produces("application/json")
	public String getLargestPopulations() {
		JsonArrayBuilder jab = Json.createArrayBuilder();
				
			for (Country c : ws.get10LargestPopulations()) {
				jab.add(tmplCountry(c));
			}
			JsonArray array = jab.build();
			return array.toString();
	}
}
