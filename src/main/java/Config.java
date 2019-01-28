import java.io.*;
import java.util.Properties;

public class Config {

	private static final String filePath = "app.properties";
	private static Properties props;

	static {
		Setup();
	}

	public static void Setup() {
		props = new Properties();
		InputStream is = null;
		try {
			File f = new File(filePath);
			is = new FileInputStream(f);
		} catch (IOException e) {
			e.printStackTrace();
			is = null;
		}
		try {
			props.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String propertyKey) {
		return props.getProperty(propertyKey);
	}
}