package sun.net.www.protocol.x;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.springframework.core.io.ClassPathResource;
import sun.net.www.URLConnection;

/**
 * @Auther: chenqimiao
 * @Date: 2020/5/1 18:23
 * @Description:
 */
public class XURLConnection extends URLConnection {

	private final ClassPathResource resource;

	// scheme://path
	public XURLConnection(URL u) {
		super(u);
		this.resource = new ClassPathResource(url.getPath());
	}

	@Override
	public void connect() throws IOException {

	}

	public InputStream getInputStream() throws IOException {
		return resource.getInputStream();
	}
}
