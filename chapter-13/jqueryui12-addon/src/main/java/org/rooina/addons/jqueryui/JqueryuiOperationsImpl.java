package org.rooina.addons.jqueryui;

import java.io.File;
import java.io.InputStream;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.springframework.roo.classpath.operations.AbstractOperations;
import org.springframework.roo.model.JavaType;
import org.springframework.roo.project.Path;
import org.springframework.roo.project.PathResolver;
import org.springframework.roo.project.ProjectOperations;
import org.springframework.roo.support.util.Assert;
import org.springframework.roo.support.util.XmlElementBuilder;
import org.springframework.roo.support.util.XmlUtils;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Implementation of {@link JqueryuiOperations} interface.
 *
 * @since 1.1.1
 */
@Component
@Service
public class JqueryuiOperationsImpl extends AbstractOperations implements JqueryuiOperations {
	private static final char SEPARATOR = File.separatorChar;

	/**
	 * Get a reference to the ProjectOperations from the underlying OSGi container. Make sure you
	 * are referencing the Roo bundle which contains this service in your add-on pom.xml.
	 */
	@Reference private ProjectOperations projectOperations;

	 /** {@inheritDoc} */
	public boolean isInstalljQueryCommandAvailable() {
		String id = projectOperations.getPathResolver().getFocusedIdentifier(Path.SRC_MAIN_WEBAPP, "/js/jquery-1.5.1.min.js");
        boolean needsInstall =  !fileManager.exists(id);
        return needsInstall;
	}

    /** {@inheritDoc} */
    public boolean isInstalljQueryUICommandAvailable() {
        PathResolver resolver = projectOperations.getPathResolver();
        
        
        String jQueryFileLocation = resolver.getFocusedIdentifier(Path.SRC_MAIN_WEBAPP, "/js/jquery-1.5.1.min.js");
        String jQueryUIFileLocation = resolver.getFocusedIdentifier(Path.SRC_MAIN_WEBAPP, "/js/jquery-ui-1.8.14.custom.min.js");
        if (projectOperations.isFocusedProjectAvailable()) {
            return fileManager.exists(jQueryFileLocation) && !fileManager.exists(jQueryUIFileLocation);
        } else {
            return false;
        }
    }

	 /** {@inheritDoc} */
	public String getProperty(String propertyName) {
		Assert.hasText(propertyName, "Property name required");
		return System.getProperty(propertyName);
	}

	 /** {@inheritDoc} */

    public void installjQueryUIApi() {
        PathResolver resolver = projectOperations.getPathResolver();
        copyDirectoryContents("js/jquery-ui-1.8.14.custom.min.js", resolver.getFocusedIdentifier(Path.SRC_MAIN_WEBAPP, "/js"), true);
        copyDirectoryContents("js/jquery.validate.js", resolver.getFocusedIdentifier(Path.SRC_MAIN_WEBAPP, "/js"), true);
        copyDirectoryContents("js/jquery.validate.min.js", resolver.getFocusedIdentifier(Path.SRC_MAIN_WEBAPP, "/js"), true);
        copyDirectoryContents("js/jquery.maskedinput.js", resolver.getFocusedIdentifier(Path.SRC_MAIN_WEBAPP, "/js"), true);

        copyDirectoryContents("images/*.png", resolver.getFocusedIdentifier(Path.SRC_MAIN_WEBAPP, "/images"), true);
        copyDirectoryContents("styles/*.css", resolver.getFocusedIdentifier(Path.SRC_MAIN_WEBAPP, "/styles"), true);

        String targetDirectory = projectOperations.getPathResolver()
                .getFocusedIdentifier(Path.SRC_MAIN_WEBAPP, "/WEB-INF/tags/util");
        String loadScriptsTagFile = targetDirectory + "/load-scripts.tagx";
        InputStream loadScriptsTagFileStream = fileManager.getInputStream(loadScriptsTagFile);
        Document document = XmlUtils.readXml(loadScriptsTagFileStream);
        Node parentNode = document.getFirstChild();

        buildAndAddUrlNode(document, "/js/jquery-ui-1.8.14.custom.min.js", "jqueryui_url");
        buildAndAddUrlNode(document, "/js/jquery.validate.min.js", "jquery_validate_url");
        buildAndAddUrlNode(document, "/js/additional-methods.min.js", "jquery_validate_add_methods_url");
        buildAndAddUrlNode(document, "/styles/jquery-ui-1.8.14.custom.css", "jquery_ui_theme_url");

        buildAndAddJSNode(document, "${jqueryui_url}");
        buildAndAddJSNode(document, "${jquery_validate_url}");
        buildAndAddJSNode(document, "${jquery_validate_add_methods_url}");
        buildAndAddCSSNode(document, "${jquery_ui_theme_url}");
        try { loadScriptsTagFileStream.close(); } catch (Exception e) {}
        fileManager.createOrUpdateTextFileIfRequired(loadScriptsTagFile, XmlUtils.nodeToString(document), false);
    }

	public void installjQueryApi() {
        PathResolver resolver = projectOperations.getPathResolver();

        copyDirectoryContents("js/jquery-1.5.1.min.js", resolver.getFocusedIdentifier(Path.SRC_MAIN_WEBAPP, "/js"), true);
        // now, load the scripts file and modify it to add the relevant javascript and css installation
        String targetDirectory = projectOperations.getPathResolver()
                .getFocusedIdentifier(Path.SRC_MAIN_WEBAPP, "/WEB-INF/tags/util");

        String loadScriptsTagFile = targetDirectory + "/load-scripts.tagx";
        InputStream loadScriptsTagFileStream = fileManager.getInputStream(loadScriptsTagFile);

        Document document = XmlUtils.readXml(loadScriptsTagFileStream);
        Node parentNode = document.getFirstChild();
        // add existence search here to not add this twice...
        buildAndAddUrlNode(document, "/js/jquery-1.5.1.min.js", "jquery_url");
        buildAndAddJSNode(document, "${jquery_url}");
        try { loadScriptsTagFileStream.close(); } catch (Exception e) {}

        fileManager.createOrUpdateTextFileIfRequired(loadScriptsTagFile, XmlUtils.nodeToString(document), false);
	}

    private void buildAndAddUrlNode(Document document, String path, String var) {
        XmlElementBuilder builder = new XmlElementBuilder("spring:url", document);
        builder.addAttribute("value", path);
        builder.addAttribute("var", var);
        Element springURLTag = builder.build();
        document.getDocumentElement().appendChild(springURLTag);
    }

    private void buildAndAddJSNode(Document document, String var) {
        XmlElementBuilder builder = new XmlElementBuilder("script", document);
        builder.addAttribute("type", "text/javascript");
        builder.addAttribute("src", var);
        addComment(document, builder);
        Element springJSTag = builder.build();
        document.getDocumentElement().appendChild(springJSTag);
    }

    private void buildAndAddCSSNode(Document document, String fileName) {
        XmlElementBuilder builder = new XmlElementBuilder("link", document);
        builder.addAttribute("href", fileName);
        builder.addAttribute("rel", "stylesheet");
        builder.addAttribute("type", "text/css");
        addComment(document, builder);
        Element springCSSTag = builder.build();
        document.getDocumentElement().appendChild(springCSSTag);
    }

    private void addComment(Document document, XmlElementBuilder builder) {
        Comment comment = document.createComment("required for FF3 and Opera");
        builder.addChild(comment);
    }
}