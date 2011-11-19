package org.rooina.addons.coffeescript;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.springframework.roo.classpath.PhysicalTypeMetadataProvider;
import org.springframework.roo.classpath.TypeLocationService;
import org.springframework.roo.metadata.MetadataService;
import org.springframework.roo.process.manager.FileManager;
import org.springframework.roo.project.Plugin;
import org.springframework.roo.project.ProjectOperations;
import org.springframework.roo.support.util.XmlUtils;
import org.w3c.dom.Element;

/**
 * Implementation of operations this add-on offers.
 * 
 * @since 1.1
 */
@Component
// Use these Apache Felix annotations to register your commands class in the Roo
// container
@Service
public class CoffeescriptOperationsImpl implements
    CoffeescriptOperations {

  /**
   * MetadataService offers access to Roo's metadata model, use it to retrieve
   * any available metadata by its MID
   */
  @Reference
  private MetadataService metadataService;

  /**
   * Use the PhysicalTypeMetadataProvider to access information about a physical
   * type in the project
   */
  @Reference
  private PhysicalTypeMetadataProvider physicalTypeMetadataProvider;

  /**
   * Use ProjectOperations to install new dependencies, plugins, properties, etc
   * into the project configuration
   */
  @Reference
  private ProjectOperations projectOperations;

  /**
   * Use TypeLocationService to find types which are annotated with a given
   * annotation in the project
   */
  @Reference
  private TypeLocationService typeLocationService;

  @Reference
  private FileManager fileManager;

  /** {@inheritDoc} */
  public boolean isSetupCommandAvailable() {
    if (!projectOperations.isFocusedProjectAvailable()
        || !isProjectWar()) {
      return false;
    }

    // check to see whether the Maven dependency is installed already
    return !isCoffeeScriptPluginInstalled();
  }

  public boolean isRemoveCommandAvailable() {
    if (!projectOperations.isFocusedProjectAvailable()
        || !isProjectWar()) {
      return false;
    }

    return isCoffeeScriptPluginInstalled();

  }

  /** {@inheritDoc} */
  public void setup() {
    String moduleName = projectOperations.getFocusedModuleName();
    projectOperations.addBuildPlugins(moduleName, getPlugins());

  }

  public void remove() {
    String moduleName = projectOperations.getFocusedModuleName();
    projectOperations.removeBuildPlugins(moduleName, getPlugins());
  }

  /**
   * provide access to the build plugins in the file, that way if additional
   * plugins are needed, you can just add them to the configuration file.
   * 
   * @return The set of plugins
   */
  private Set<Plugin> getPlugins() {
    Element configuration = XmlUtils.getConfiguration(this.getClass());
    Collection<Element> configPlugins = XmlUtils.findElements(
        "/configuration/coffeescript/plugins/plugin", configuration);

    Set<Plugin> plugins = new HashSet<Plugin>();
    for (Element pluginElement : configPlugins) {
      plugins.add(new Plugin(pluginElement));
    }
    return plugins;
  }

  private boolean isCoffeeScriptPluginInstalled() {
    Set<Plugin> pluginsExcludingVersion = projectOperations
        .getFocusedProjectMetadata()
        .getPom()
        .getBuildPluginsExcludingVersion(
            new Plugin("com.theoryinpractise", "coffee-maven-plugin",
                "1.3.1")); // required even though not needed...
    return !pluginsExcludingVersion.isEmpty();
  }

  private boolean isProjectWar() {
    return projectOperations.getFocusedProjectMetadata().getPom()
        .getPackaging().equals("war");
  }
}