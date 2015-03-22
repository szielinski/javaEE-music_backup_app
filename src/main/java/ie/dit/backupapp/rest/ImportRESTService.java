package ie.dit.backupapp.rest;

import ie.dit.backupapp.services.XMLReaderService;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

@Path("/restImportService")
public class ImportRESTService {

	@Inject
	private XMLReaderService xmlReader;

	@POST
	@Path("/import")
	@Consumes("multipart/form-data")
	public String importUploadedFile(@MultipartForm FileUploadForm form) {
		String resultString = "";
		try {
//			HSSFWorkbook wb = new HSSFWorkbook(new ByteArrayInputStream(form.getFileData()));
			File xmlFile = new File(new ByteArrayInputStream(form.getFileData()));
			xmlReader.readXML(xmlFile);
		}
		catch (IOException e) {
			resultString = "Import was unsuccessful";
			e.printStackTrace();
		}
		return resultString;
	}
}
