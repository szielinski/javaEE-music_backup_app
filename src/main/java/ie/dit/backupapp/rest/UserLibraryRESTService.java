package ie.dit.backupapp.rest;

import ie.dit.backupapp.entities.Playlist;
import ie.dit.backupapp.entities.Track;
import ie.dit.backupapp.entities.UserLibrary;
import ie.dit.backupapp.services.UserLibraryService;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/userlibrary")
public class UserLibraryRESTService {

	@EJB
	private UserLibraryService userLibraryService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public UserLibrary getUserLibrary(@Context SecurityContext securityContext) {
		return userLibraryService.getUserLibrary(securityContext.getUserPrincipal().getName());
	}

	@GET
	@Path("/tracks")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection <Track> getUserTracks(@Context SecurityContext securityContext) {
		UserLibrary library = userLibraryService.getUserLibrary(securityContext.getUserPrincipal().getName());
		return library.getTracks();
	}

	@GET
	@Path("/playlist/getTracksByPlaylistName")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection <Track> getTracksByPlaylistName(@QueryParam("playlistName") String playlistName, @Context SecurityContext securityContext) {
		return userLibraryService.getTracksByPlaylistName(securityContext.getUserPrincipal().getName(), playlistName);
	}

	@GET
	@Path("/playlists")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection <Playlist> getUserPlaylists(@Context SecurityContext securityContext) {
		return userLibraryService.getAllPlaylists(securityContext.getUserPrincipal().getName());
	}

	@GET
	@Path("/playlists/names")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection <String> getUserPlaylistNames(@Context SecurityContext securityContext) {
		return userLibraryService.getAllPlaylistNames(securityContext.getUserPrincipal().getName());
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUserLibrary(UserLibrary userLibrary) {
		userLibraryService.updateLibrary(userLibrary);
		return Response.ok().status(200).build();
	}

	/*
	 * public Response deleteTrack(@QueryParam("trackId") int trackId, @QueryParam("libraryId") int libraryId){ userLibraryService.deleteTrack(); return
	 * Response.ok().status(200).build(); }
	 */
}
