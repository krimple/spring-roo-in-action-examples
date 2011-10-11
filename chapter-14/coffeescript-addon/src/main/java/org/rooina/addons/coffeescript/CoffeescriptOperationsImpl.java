package org.rooina.addons.coffeescript;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.springframework.roo.classpath.PhysicalTypeDetails;
import org.springframework.roo.classpath.PhysicalTypeIdentifier;
import org.springframework.roo.classpath.PhysicalTypeMetadata;
import org.springframework.roo.classpath.PhysicalTypeMetadataProvider;
import org.springframework.roo.classpath.TypeLocationService;
import org.springframework.roo.classpath.details.MemberFindingUtils;
import org.springframework.roo.classpath.details.MutableClassOrInterfaceTypeDetails;
import org.springframework.roo.classpath.details.annotations.AnnotationMetadataBuilder;
import org.springframework.roo.metadata.MetadataService;
import org.springframework.roo.model.JavaType;
import org.springframework.roo.process.manager.FileManager;
import org.springframework.roo.project.*;
import org.springframework.roo.support.util.Assert;
import org.springframework.roo.support.util.XmlUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Implementation of operations this add-on offers.
 *
 * @since 1.1
 */
@Component // Use these Apache Felix annotations to register your commands class in the Roo container
@Service
public class CoffeescriptOperationsImpl implements CoffeescriptOperations {
	
	/**
	 * MetadataService offers access to Roo's metadata model, use it to retrieve any available metadata by its MID
	 */
	@Reference private MetadataService metadataService;
	
	/**
	 * Use the PhysicalTypeMetadataProvider to access information about a physical type in the project
	 */
	@Reference private PhysicalTypeMetadataProvider physicalTypeMetadataProvider;
	
	/**
	 * Use ProjectOperations to install new dependencies, plugins, properties, etc into the project configuration
	 */
	@Reference private ProjectOperations projectOperations;

	/**
	 * Use TypeLocationService to find types which are annotated with a given annotation in the project
	 */
	@Reference private TypeLocationService typeLocationService;

    @Reference private FileManager fileManager;


	/** {@inheritDoc} */
	public boolean isSetupCommandAvailable() {
        if (!projectOperations.isProjectAvailable() ||
            !isProjectWar()) {
            return false;
        }

        // check to see whether the Maven dependency is installed already
        return !isCoffeeScriptPluginInstalled();
	}

    public boolean isRemoveCommandAvailable() {
        if (!projectOperations.isProjectAvailable() ||
            !isProjectWar()) {
            return false;
        }

        return isCoffeeScriptPluginInstalled();

    }

	/** {@inheritDoc} */
	public void setup() {
        List<Plugin> pluginsToAdd = getPluginList();
        projectOperations.addBuildPlugins(pluginsToAdd);
	}


    public void remove() {
        List<Plugin> pluginsToRemove = getPluginList();
        projectOperations.removeBuildPlugins(pluginsToRemove);
    }

    private List<Plugin> getPluginList() {
        Element configuration = XmlUtils.getConfiguration(this.getClass());
        Collection<Element> configPlugins = XmlUtils.findElements(
                    "/configuration/coffeescript/plugins/plugin",
                    configuration);

        List<Plugin> plugins = new ArrayList<Plugin>();
        for (Element pluginElement : configPlugins) {
            plugins.add(new Plugin(pluginElement));
        }
        return plugins;
    }


    private boolean isCoffeeScriptPluginInstalled() {
        boolean found = false;
        return projectOperations.getProjectMetadata().isBuildPluginRegistered(
                new Plugin("com.theoryinpractise", "coffee-maven-plugin", null));
    }

    private boolean isProjectWar() {
        return projectOperations.isProjectAvailable() &&
                fileManager.exists(
                        projectOperations.getPathResolver()
                                .getIdentifier(Path.SRC_MAIN_WEBAPP, "WEB-INF/web.xml"));
    }
}