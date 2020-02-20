package connection;

import java.io.File;


public enum Config {
	URL(),USER(),PASS();
	
	private ConfigurationProvider conPro;
	private String value;
	private final String path = new File("").getAbsolutePath()+"\\other_file\\config.properties";

	String getValue() {
		conPro = new ConfigurationProvider(path);
		System.out.println(path);
		return (conPro == null) ? null : conPro.getProperties().getProperty(this.toString());
	}
}
