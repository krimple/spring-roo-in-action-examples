package org.rooina.addons.coffeescript;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.springframework.roo.model.JavaType;
import org.springframework.roo.shell.CliAvailabilityIndicator;
import org.springframework.roo.shell.CliCommand;
import org.springframework.roo.shell.CliOption;
import org.springframework.roo.shell.CommandMarker;

/**
 * Sample of a command class. The command class is registered by the Roo shell following an
 * automatic classpath scan. You can provide simple user presentation-related logic in this
 * class. You can return any objects from each method, or use the logger directly if you'd
 * like to emit messages of different severity (and therefore different colours on 
 * non-Windows systems).
 * 
 * @since 1.1
 */
@Component // Use these Apache Felix annotations to register your commands class in the Roo container
@Service
public class CoffeescriptCommands implements CommandMarker { // All command types must implement the CommandMarker interface
	
	/**
	 * Get a reference to the CoffeescriptOperations from the underlying OSGi container
	 */
	@Reference private CoffeescriptOperations operations;
		
	@CliAvailabilityIndicator({ "coffeescript setup" })
	public boolean isSetupCommandAvailable() {
		return operations.isSetupCommandAvailable();
	}

    @CliAvailabilityIndicator({ "coffeescript remove" })
    public boolean isRemoveCommandAvailable() {
        return operations.isSetupCommandAvailable();
    }

	@CliCommand(value = "coffeescript setup", help = "Install the CoffeeScript compiler")
	public void setup() {
		operations.setup();
	}
	
	@CliCommand(value = "coffeescript remove", help = "Remove the coffeescript compiler")
	public void remove() {
		operations.remove();
	}
}