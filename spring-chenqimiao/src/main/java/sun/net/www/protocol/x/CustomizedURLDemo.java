package sun.net.www.protocol.x;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import org.springframework.util.StreamUtils;

/**
 * @Auther: chenqimiao
 * @Date: 2020/5/1 18:26
 * @Description:
 */
public class CustomizedURLDemo {

	public static void main(String[] args) throws IOException {
		URL url = new URL("x:///META-INF/properties/xxx.properties");
		System.out.println(StreamUtils.copyToString(url.openStream(), Charset.forName("UTF-8")));
	}
}
