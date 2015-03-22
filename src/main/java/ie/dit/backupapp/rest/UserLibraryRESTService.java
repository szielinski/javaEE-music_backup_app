package ie.dit.backupapp.rest;

import ie.dit.backupapp.entities.UserLibrary;
import ie.dit.backupapp.services.UserLibraryService;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/userlibrary")
public class UserLibraryRESTService {

	@EJB
	private UserLibraryService userLibraryService;

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserLibrary(String username) {
		// TODO: check if user is logged in/has access

		return Response.ok().status(200).entity(userLibraryService.getUserLibrary(username)).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUserLibrary(UserLibrary userLibrary) {
		userLibraryService.updateLibrary(userLibrary);
		return Response.ok().status(200).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUserLibrary(UserLibrary userLibrary) {
		userLibraryService.addLibrary(userLibrary);
		return Response.ok().status(200).build();
	}
}
