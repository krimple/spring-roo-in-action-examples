package org.rooina.addons.coffeescript;

public interface CoffeescriptOperations {

	boolean isSetupCommandAvailable();

    boolean isRemoveCommandAvailable();

	void setup();

    void remove();
}