package org.rooina.addons.jqueryui;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.springframework.roo.shell.CliAvailabilityIndicator;
import org.springframework.roo.shell.CliCommand;
import org.springframework.roo.shell.CommandMarker;

import java.util.logging.Logger;

/**
 * Example of a command class. The command class is registered by the Roo shell following an
 * automatic classpath scan. You can provide simple user presentation-related logic in this
 * class. You can return any objects from each method, or use the logger directly if you'd
 * like to emit messages of different severity (and therefore different colors on 
 * non-Windows systems).
 * 
 * @since 1.1.1
 */
@Component // Use these Apache Felix annotations to register your commands class in the Roo container
@Service
public class JqueryuiCommands implements CommandMarker { // All command types must implement the CommandMarker interface
	
	/**
	 * Get hold of a JDK Logger
	 */
	private Logger log = Logger.getLogger(getClass().getName());

	@Reference private JqueryuiOperations operations;

    @CliAvailabilityIndicator("jquery api install")
    public boolean isApiInstallCommandAvailable() {
        return operations.isInstalljQueryCommandAvailable();
    }

	@CliAvailabilityIndicator("jquery ui install") // Define the exact command name
	public boolean isInstalljQueryUIAvailable() {
		return operations.isInstalljQueryUICommandAvailable();
	}

    @CliCommand(value = "jquery api install", help="provide jquery API")
    public void installjQueryApi() {
        operations.installjQueryApi();
    }

    @CliCommand(value = "jquery ui install", help="provide jqueryui")
	public void installjQueryUIApi() {
		operations.installjQueryUIApi();
	}
}