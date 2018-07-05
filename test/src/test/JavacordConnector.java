package test;

public class JavacordConnector {
	CommandRegistry _commandRegistry;
	
	void configure(JavacordConnectorConfiguration conf) {
		System.out.println("JavacordConnector.configure: property=" + conf.getProperty());
	}

	void connect() {
		System.out.println("JavacordConnector.start");
		_commandRegistry.run();
	}

	void disconnect() {
		System.out.println("JavacordConnector.stop");
	}
}
