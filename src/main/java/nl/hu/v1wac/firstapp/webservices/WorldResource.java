package nl.hu.v1wac.firstapp.webservices;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.Path;

import nl.hu.v1wac.firstapp.webservices.ServiceProvider;

@Path("/countries/")
public class WorldResource {
	
	public WorldService ws = ServiceProvider.getWorldService();

	@GET
	@Produces("application/json")
	public List<Country> allCountries() {
		return ws.getAllCountries();
	}
	
	@GET
	@Produces("application/json")
	@Path("{code}")
	public Country country(@PathParam("code") String code) {
		return ws.getCountryByCode(code);
	}
	
	@GET
	@Path("/largestsurfaces")
	@Produces("application/json")
	public List<Country> getLargestSurfaces() {
		return ws.get10LargestSurfaces();
	}
	
	@GET
	@Path("/largestpopulations")
	@Produces("application/json")
	public List<Country> getLargestPopulations() {
		return ws.get10LargestPopulations();
	}
}
