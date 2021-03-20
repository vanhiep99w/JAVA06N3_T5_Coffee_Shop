 package connection;

import java.io.File;
import util.URL_Factory;


public enum Config {
	URL(),USER(),PASS();
	
	private ConfigurationProvider conPro;
	private final String path = URL_Factory.CONFIG_FILE_URL;

	String getValue() {

		System.out.println(path);
		conPro = new ConfigurationProvider(path);
		return (conPro == null) ? null : conPro.getProperties().getProperty(this.toString());
	}
}
