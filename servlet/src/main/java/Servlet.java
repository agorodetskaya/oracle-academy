import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.UUID;

@WebServlet(name = "Servlet", urlPatterns = "/")
@MultipartConfig(maxFileSize = (1024 * 1024 * 10))
public class Servlet extends HttpServlet {
    protected ResourcesUtil resourcesUtil = new ResourcesUtil();
    protected Properties property = resourcesUtil.loadPropertiesFromResources(new Properties(), "config.properties");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Part filePart = request.getPart("file");
        if (filePart != null) {
            String fileName = filePart.getSubmittedFileName();
            String fileExtension = getExtensionOfFileByName(fileName);
            try (InputStream inputStream = filePart.getInputStream();
                 OutputStream outputStream = new FileOutputStream(getFileForImage(fileExtension))) {
                IOUtils.copy(inputStream, outputStream);
            }
        }
        doGet(request, response);
    }

    private String getExtensionOfFileByName(String fileName) {
        String[] arr = fileName.split("\\.+");
        return "." + arr[arr.length - 1];
    }

    private File getFileForImage(String fileExtension) {
        String pathname = getDirectoryOfImage() + File.separator + UUID.randomUUID() + fileExtension;
        return new File(pathname);
    }

    protected String getDirectoryOfImage() {
        return property.getProperty("upload.location");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        File directory = new File(getDirectoryOfImage());
        request.setAttribute("fileList", directory.list());
        request.getRequestDispatcher("myPage.jsp").forward(request, response);
    }
}
