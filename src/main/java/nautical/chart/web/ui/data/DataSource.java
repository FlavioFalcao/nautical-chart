package nautical.chart.web.ui.data;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * 数据源，用以读取项目、版本、问题等数据。
 * 
 * @author Cheng Feng
 */
public class DataSource {

//	public String getLocation() {
//		return properties.getProperty(DATA_SOURCE);
//		return String.valueOf(configFile.exists());
//	}
//
//	private static final String CONFIG_FILE = "configuration.properties";
//	private static final String DATA_SOURCE = "data.source";
//	private static final Properties properties = new Properties();
//
//	static {
//		try {
//			properties.load(new FileInputStream(CONFIG_FILE));
//		} catch (Exception e) {
//			// TODO
//		}
//	}
//
//	

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	private String location;
}
