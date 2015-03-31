package ie.dit.backupapp.rest;

import ie.dit.backupapp.services.XMLReaderService;
import ie.dit.backupapp.utils.PasswordGenerator;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

@Path("/restImportService")
public class ImportRESTService {

	@EJB
	private XMLReaderService xmlReader;

	@POST
	@Path("/import")
	@Consumes("multipart/form-data")
	public String importUploadedFile(@MultipartForm FileUploadForm form) {
		String resultString = "";
		try {
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(form.getFileData());

			File newFile = new File("tempData");
			String filepath = newFile.getAbsolutePath();
			System.out.println(filepath);
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile), "UTF-8"));
			int data;
			while ((data = byteArrayInputStream.read()) != -1) {
				out.write(data);
			}
			out.close();

			if (xmlReader == null)
				System.out.println("wtf");
			xmlReader.createUserLibraryFromXML(filepath, "tests", PasswordGenerator.generate("tests"));
		}
		catch (IOException e) {
			resultString = "Import was unsuccessful";
			e.printStackTrace();
		}
		return resultString;
	}
}
