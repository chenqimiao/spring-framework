package sun.net.www.protocol.x;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 * @Auther: chenqimiao
 * @Date: 2020/5/1 18:20
 * @Description:
 */
public class Handler extends URLStreamHandler {

	@Override
	protected URLConnection openConnection(URL u) throws IOException {
		return new XURLConnection(u);
	}
}
