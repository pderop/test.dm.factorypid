package test;

import java.io.IOException;
import java.util.Hashtable;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;

public class Configurator {
	ConfigurationAdmin _cm;

	void start() {
		System.out.println("Configurator: creating conf");
		Configuration c;
		try {
			c = _cm.createFactoryConfiguration("mypid", "?");
			Hashtable<String, Object> props = new Hashtable<>();
			props.put("property", "value");
			c.update(props);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
