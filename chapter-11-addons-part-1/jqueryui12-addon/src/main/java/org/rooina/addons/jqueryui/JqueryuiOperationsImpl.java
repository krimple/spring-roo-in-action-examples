package org.rooina.addons.jqueryui;

import java.io.InputStream;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.springframework.roo.classpath.operations.AbstractOperations;
import org.springframework.roo.project.Path;
import org.springframework.roo.project.PathResolver;
import org.springframework.roo.project.ProjectOperations;
import org.springframework.roo.support.util.IOUtils;
import org.springframework.roo.support.util.XmlElementBuilder;
import org.springframework.roo.support.util.XmlUtils;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Implementation of {@link JqueryuiOperations} interface.
 * 
 * @since 1.1.1
 */
@Component
@Service
public class JqueryuiOperationsImpl extends AbstractOperations
    implements JqueryuiOperations {

  /**
   * Get a reference to the ProjectOperations from the underlying OSGi
   * container. Make sure you are referencing the Roo bundle which contains this
   * service in your add-on pom.xml.
   */
  @Reference
  private ProjectOperations projectOperations;

  /**
   * Most of our methods need the path resolver, so inject this as well, since
   * it is another SCR component.
   */
  @Reference
  private PathResolver pathResolver;

  /** {@inheritDoc} */
  public boolean isInstalljQueryCommandAvailable() {
    String jsLocation = pathResolver.getFocusedIdentifier(
        Path.SRC_MAIN_WEBAPP, "/js");

    return fileManager.findMatchingAntPath(
        jsLocation + "**/jquery-1.*.min.js").isEmpty();
  }

  /** {@inheritDoc} */
  public boolean isInstalljQueryUICommandAvailable() {

    String jsLocation = pathResolver.getFocusedIdentifier(
        Path.SRC_MAIN_WEBAPP, "/js");
    if (projectOperations.isFocusedProjectAvailable()) {
      boolean hasJqueryUI = !fileManager.findMatchingAntPath(
          jsLocation + "/jquery-ui-*.min.js").isEmpty();

      return !isInstalljQueryCommandAvailable() && !hasJqueryUI;
    } else {
      return false;
    }
  }

  /** {@inheritDoc} */
  public void installjQueryUIApi() {
    copyDirectoryContents("js/jqueryui/*.js",
        pathResolver.getFocusedIdentifier(Path.SRC_MAIN_WEBAPP, "/js"),
        true);
    copyDirectoryContents("images/*.png",
        pathResolver.getFocusedIdentifier(Path.SRC_MAIN_WEBAPP,
            "/images"), true);
    copyDirectoryContents("styles/*.css",
        pathResolver.getFocusedIdentifier(Path.SRC_MAIN_WEBAPP,
            "/styles"), true);

    String targetDirectory = pathResolver.getFocusedIdentifier(
        Path.SRC_MAIN_WEBAPP, "/WEB-INF/tags/util");

    String loadScriptsTagFile = targetDirectory + "/load-scripts.tagx";

    InputStream loadScriptsTagFileStream = fileManager
        .getInputStream(loadScriptsTagFile);

    Document document = XmlUtils.readXml(loadScriptsTagFileStream);

    buildAndAddJSNode(document,
        "/js/jqueryui/jquery-ui-1.8.14.custom.min.js");
    buildAndAddJSNode(document, 
        "/js/jqueryui/jquery.validate.min.js");
    buildAndAddJSNode(document,
        "/js/jqueryui/additional-methods.min.js");
    buildAndAddCSSNode(document, 
        "/styles/jquery-ui-1.8.14.custom.css");

    IOUtils.closeQuietly(loadScriptsTagFileStream);
    fileManager.createOrUpdateTextFileIfRequired(loadScriptsTagFile,
        XmlUtils.nodeToString(document), false);
  }

  public void installjQueryApi() {
    String pathIdentifier = pathResolver.getFocusedIdentifier(
        Path.SRC_MAIN_WEBAPP, "/js");

    copyDirectoryContents("js/jquery/jquery-1.5.1.min.js",
        pathIdentifier, true);

    String targetDirectory = pathResolver.getFocusedIdentifier(
        Path.SRC_MAIN_WEBAPP, "WEB-INF/tags/util");

    String loadScriptsTagFile = targetDirectory + "/load-scripts.tagx";

    InputStream loadScriptsTagFileStream = fileManager
        .getInputStream(loadScriptsTagFile);

    Document document = XmlUtils.readXml(loadScriptsTagFileStream);

    buildAndAddJSNode(document, "/js/jquery-1.5.1.min.js");

    IOUtils.closeQuietly(loadScriptsTagFileStream);

    fileManager.createOrUpdateTextFileIfRequired(loadScriptsTagFile,
        XmlUtils.nodeToString(document), false);
  }

  private void buildAndAddJSNode(Document doc, String var) {
    XmlElementBuilder builder = new XmlElementBuilder("script", doc);
    builder.addAttribute("type", "text/javascript");
    builder.addAttribute("src", var);
    addComment(doc, builder);
    Element springJSTag = builder.build();
    doc.getDocumentElement().appendChild(springJSTag);
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
    Comment comment = document
        .createComment("required for FF3 and Opera");
    builder.addChild(comment);
  }
}