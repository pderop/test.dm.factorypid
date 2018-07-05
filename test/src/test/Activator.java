package test;

import org.apache.felix.dm.Component;
import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;
import org.osgi.service.cm.ConfigurationAdmin;

public class Activator extends DependencyActivatorBase {

    @Override
    public void init(BundleContext ctx, DependencyManager dm) throws Exception {
		Component c = createFactoryConfigurationAdapterService("mypid", "configure", true, JavacordConnectorConfiguration.class)
				.setImplementation(JavacordConnector.class)
				.add(createServiceDependency().setService(CommandRegistry.class).setRequired(false).setDefaultImplementation(NOPCommandRegistry.class))
				.setCallbacks(null, "connect", "disconnect", null);
		dm.add(c);
		
		Component configurator = createComponent()
				.setImplementation(Configurator.class)
				.add(createServiceDependency().setService(ConfigurationAdmin.class).setRequired(true));
		dm.add(configurator);
    }

}
