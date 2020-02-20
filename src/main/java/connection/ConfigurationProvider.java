package connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigurationProvider {
	private Properties properties ;
	private InputStream inStream ;
	private File file ;
		
	public ConfigurationProvider(String path) {
		if( path == null || !Files.exists(Paths.get(path))) {
			properties = null;
		}else {
			try { 
				file = new File(path);
				inStream = new FileInputStream(file);
				properties = new Properties();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
	}
	
	public Properties getProperties() {
		if(properties != null) {
			try {
				properties.load(inStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return properties;
		
	}
}
