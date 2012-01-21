package org.rooina.addons.jqueryui;

/**
 * Interface of commands that are available via the Roo shell.
 *
 * @since 1.1.1
 */
public interface JqueryuiOperations {

	boolean isInstalljQueryCommandAvailable();

    boolean isInstalljQueryUICommandAvailable();

    void installjQueryApi();

    void installjQueryUIApi();
}