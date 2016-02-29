import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;


@WebServlet(name = "ImageServlet", urlPatterns = "/hello/img")
@MultipartConfig
public class ImageServlet extends HttpServlet {
    protected ResourcesUtil resourcesUtil = new ResourcesUtil();
    protected Properties property = resourcesUtil.loadPropertiesFromResources(new Properties(), "config.properties");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getParameter("name");
        File img = new File(getDirectoryOfImage() + File.separator + path);
        byte[] bytesOfImg = Files.readAllBytes(img.toPath());
        ServletOutputStream out = response.getOutputStream();
        out.write(bytesOfImg);
    }

    protected String getDirectoryOfImage() {
        return property.getProperty("upload.location");
    }
}
