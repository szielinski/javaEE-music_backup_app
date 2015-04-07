package ie.dit.backupapp.rest;

import ie.dit.backupapp.entities.Playlist;
import ie.dit.backupapp.entities.Track;
import ie.dit.backupapp.entities.UserLibrary;
import ie.dit.backupapp.services.UserLibraryService;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
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
	@Path("/tracks/getTrackByName")
	@Produces(MediaType.APPLICATION_JSON)
	public Track getUserTrackByName(@QueryParam("trackName") String trackName, @Context SecurityContext securityContext) {
		UserLibrary library = userLibraryService.getUserLibrary(securityContext.getUserPrincipal().getName());
		Collection<Track> tracks = library.getTracks();
		for(Track t : tracks){
			if(t.getName().equals(trackName))
				return t;
		}
		return null;
	}

	@GET
	@Path("/tracks/getTrackById")
	@Produces(MediaType.APPLICATION_JSON)
	public Track getUserTrackById(@QueryParam("trackId") int trackId, @Context SecurityContext securityContext) {
		UserLibrary library = userLibraryService.getUserLibrary(securityContext.getUserPrincipal().getName());
		Collection<Track> tracks = library.getTracks();
		for(Track t : tracks){
			if(t.getTrackId() == trackId)
				return t;
		}
		return null;
	}

	@GET
	@Path("/playlists/getPlaylistByName")
	@Produces(MediaType.APPLICATION_JSON)
	public Playlist getUserPlaylistByName(@QueryParam("playlistName") String playlistName, @Context SecurityContext securityContext) {
		UserLibrary library = userLibraryService.getUserLibrary(securityContext.getUserPrincipal().getName());
		Collection<Playlist> playlists = library.getPlaylists();
		for(Playlist p : playlists){
			if(p.getName().equals(playlistName))
				return p;
		}
		return null;
	}

	@GET
	@Path("/playlists/getPlaylistById")
	@Produces(MediaType.APPLICATION_JSON)
	public Playlist getUserPlaylistById(@QueryParam("playlistId") int playlistId, @Context SecurityContext securityContext) {
		UserLibrary library = userLibraryService.getUserLibrary(securityContext.getUserPrincipal().getName());
		Collection<Playlist> playlists = library.getPlaylists();
		for(Playlist p : playlists){
			if(p.getPlaylistId() == playlistId)
				return p;
		}
		return null;
	}
	
	@DELETE
	@Path("/tracks/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteTrack(@QueryParam("trackId") int trackId, @Context SecurityContext securityContext){
		userLibraryService.deleteTrack(securityContext.getUserPrincipal().getName(), trackId);
		return Response.ok().status(200).build();
	}
	
	@POST
	@Path("/tracks/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addTrack(Track track, @Context SecurityContext securityContext){
		userLibraryService.addTrack(securityContext.getUserPrincipal().getName(), track);
		return Response.ok().status(200).build();
	}
	
	@POST
	@Path("/tracks/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateTrack(Track track){
		userLibraryService.updateTrack(track);
		return Response.ok().status(200).build();
	}
	
	@POST
	@Path("/playlists/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePlaylist(Playlist playlist){
		userLibraryService.updatePlaylist(playlist);
		return Response.ok().status(200).build();
	}
	
	@POST
	@Path("/playlist/addTrack")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addTrackToPlaylist(@QueryParam("trackId") int trackId, @QueryParam("playlistName") String playlistName, @Context SecurityContext securityContext){
		userLibraryService.addTrackToPlaylist(securityContext.getUserPrincipal().getName(), playlistName, trackId);
		return Response.ok().status(200).build();
	}
	
	@DELETE
	@Path("/playlist/removeTrack")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeTrackFromPlaylist(@QueryParam("trackId") int trackId, @QueryParam("playlistName") String playlistName, @Context SecurityContext securityContext){
		userLibraryService.removeTrackFromPlaylist(securityContext.getUserPrincipal().getName(), playlistName, trackId);
		return Response.ok().status(200).build();
	}
	
	@DELETE
	@Path("/playlists/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePlaylist(@QueryParam("playlistId") int playlistId, @Context SecurityContext securityContext){
		userLibraryService.deletePlaylist(securityContext.getUserPrincipal().getName(), playlistId);
		return Response.ok().status(200).build();
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
	
	@POST
	@Path("/playlists/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPlaylist(Playlist playlist, @Context SecurityContext securityContext){
		if(userLibraryService.addPlaylist(securityContext.getUserPrincipal().getName(), playlist)){
			return Response.ok().status(200).build();
		}
		return Response.status(Status.CONFLICT).build();
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
}
