package org.rooinaction.coursemanager.client.scaffold.ioc;

import org.rooinaction.coursemanager.client.scaffold.ScaffoldApp;
import com.google.gwt.inject.client.Ginjector;

public interface ScaffoldInjector extends Ginjector {

	ScaffoldApp getScaffoldApp();
}
