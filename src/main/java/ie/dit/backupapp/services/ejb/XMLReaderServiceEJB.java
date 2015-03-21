package ie.dit.backupapp.services.ejb;

import ie.dit.backupapp.dao.UserLibraryDAO;
import ie.dit.backupapp.entities.Playlist;
import ie.dit.backupapp.entities.Track;
import ie.dit.backupapp.entities.UserLibrary;
import java.io.File;
import java.util.ArrayList;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Local
@Stateless
public class XMLReaderServiceEJB /* implements XMLReaderService */{

	@Inject
	private UserLibraryDAO userLibraryDAO;

	public static void main(String [] args) {
		readXML("C:\\Users\\Szymon\\Desktop\\java project\\iTunes Music Library3.xml");
	}

	// @Override
	public static void readXML(String location) {
		File xmlFile = null;
		try {
			xmlFile = new File(location);
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document parsedXML = docBuilder.parse(xmlFile);

			parsedXML.getDocumentElement().normalize();
			System.out.println("Root element: " + parsedXML.getDocumentElement().getNodeName());

			// NodeList nList = parsedXML.getElementsByTagName("staff");
			System.out.println("----------------------------");
			processFile(parsedXML);
			// showChildNodes(1, parsedXML.getDocumentElement().getChildNodes());

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void processFile(Document parsedXML) {
		UserLibrary newUserLibrary = new UserLibrary("test", "test", new ArrayList <Track>(), new ArrayList <Playlist>());

		Node tracksNode = getNode(parsedXML.getDocumentElement().getChildNodes(), "Tracks");
		if (tracksNode != null) {
			Node tracksKey = tracksNode.getParentNode();
			Node tracksDict = tracksKey.getNextSibling().getNextSibling();
			processTracks(tracksDict, newUserLibrary);
		}

		Node playlistsNode = getNode(parsedXML.getChildNodes(), "Playlists");
		if (playlistsNode != null) {
			Node playlistsKey = playlistsNode.getParentNode();
			Node playlistsArray = playlistsKey.getNextSibling().getNextSibling();
			processPlaylists(playlistsArray, newUserLibrary);
		}
	}

	private static void processTracks(Node tracksDict, UserLibrary userLibrary) {
		NodeList tracksDictElements = tracksDict.getChildNodes();

		for (int i = 0; i < tracksDictElements.getLength(); i++) {
			Node currentNode = tracksDictElements.item(i);

			if (currentNode.getNodeName().equals("dict")) {
				processSingleTrack(currentNode, userLibrary);
			}
		}
	}

	private static void processSingleTrack(Node trackNode, UserLibrary userLibrary) {
		NodeList trackContents = trackNode.getChildNodes();
		Track track = new Track();
		// track.setLibraryId(userLibrary.getLibraryId());
		track.setLibraryId(1);

		Node trackId = getValueNode(trackContents, "Track ID");
		if (trackId != null) {
			track.setTrackId(Integer.parseInt(trackId.getNodeValue()));
		}

		Node name = getValueNode(trackContents, "Name");
		if (name != null) {
			track.setName(name.getNodeValue());
		}

		Node artist = getValueNode(trackContents, "Artist");
		if (artist != null) {
			track.setArtist(artist.getNodeValue());
		}

		Node album = getValueNode(trackContents, "Album");
		if (album != null) {
			track.setAlbum(album.getNodeValue());
		}

		Node composer = getValueNode(trackContents, "Composer");
		if (composer != null) {
			track.setComposer(composer.getNodeValue());
		}

		Node genre = getValueNode(trackContents, "Genre");
		if (genre != null) {
			track.setGenre(genre.getNodeValue());
		}

		Node trackNumber = getValueNode(trackContents, "Track Number");
		if (trackNumber != null) {
			track.setTrackNumber(Integer.parseInt(trackNumber.getNodeValue()));
		}

		Node year = getValueNode(trackContents, "Year");
		if (year != null) {
			track.setYear(Integer.parseInt(year.getNodeValue()));
		}

		System.out.println("track");
		System.out.println(track);
		userLibrary.addTrack(track);
	}

	private static void processPlaylists(Node playlistsArray, UserLibrary userLibrary) {
		NodeList playlistsDictElements = playlistsArray.getChildNodes();

		for (int i = 0; i < playlistsDictElements.getLength(); i++) {
			Node currentNode = playlistsDictElements.item(i);

			if (currentNode.getNodeName().equals("dict")) {
				processSinglePlaylist(currentNode, userLibrary);
			}
		}
	}

	private static void processSinglePlaylist(Node playlistNode, UserLibrary userLibrary) {
		NodeList playlistContents = playlistNode.getChildNodes();
		Playlist playlist = new Playlist();

		Node name = getValueNode(playlistContents, "Name");
		if (name != null) {
			playlist.setName(name.getNodeValue());
		}

		for (int i = 0; i < playlistContents.getLength(); i++) {
			Node currentNode = playlistContents.item(i);

			if (currentNode.getNodeName().equals("array")) {
				processPlaylistArray(currentNode, userLibrary, playlist);
			}
		}
		System.out.println(playlist);
		userLibrary.addPlaylist(playlist);
	}

	private static void processPlaylistArray(Node playlistArray, UserLibrary userLibrary, Playlist playlist) {
		NodeList playlistTrackArray = playlistArray.getChildNodes();

		for (int i = 0; i < playlistTrackArray.getLength(); i++) {
			Node currentNode = playlistTrackArray.item(i);

			if (currentNode.getNodeName().equals("dict")) {
				Node trackIDNode = getValueNode(currentNode.getChildNodes(), "Track ID");
				if (trackIDNode != null) {
					int trackID = Integer.parseInt(trackIDNode.getNodeValue());
					playlist.addTrack(userLibrary.getTrackById(trackID));
				}
			}
		}
	}

	public static Node getNode(NodeList nodeList, String nodeKey) {
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node currentNode = nodeList.item(i);

			// System.out.println("comp: " + nodeKey);
			// System.out.println(currentNode.getNodeValue());

			if (currentNode.getNodeValue() != null && currentNode.getNodeValue().equals(nodeKey)) {
				// System.out.println("HERERAHIUWHNGFEIO");
				return currentNode;
			}
			if (currentNode.hasChildNodes()) {
				Node result = getNode(currentNode.getChildNodes(), nodeKey);
				if (result != null)
					return result;
			}
		}
		return null;
	}

	public static Node getValueNode(NodeList nodeList, String nodeKey) {
		Node keyNode = getNode(nodeList, nodeKey);
		if (keyNode != null) {
			return keyNode.getParentNode().getNextSibling().getFirstChild();
		}
		return null;
	}

	public static void showChildNodes(int indentation, NodeList nList) {
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);

			for (int i = 0; i < indentation; i++)
				System.out.print("\t");
			System.out.println("Current Element :" + nNode.getNodeName());
			for (int i = 0; i < indentation; i++)
				System.out.print("\t");
			System.out.println("Value :" + nNode.getNodeValue() + "\n");
			if (nNode.hasChildNodes()) {
				showChildNodes(indentation + 1, nNode.getChildNodes());
			}
		}
	}
}
