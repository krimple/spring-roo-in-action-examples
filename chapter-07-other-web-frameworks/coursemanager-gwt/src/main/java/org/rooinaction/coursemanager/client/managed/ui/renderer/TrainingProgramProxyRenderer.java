package org.rooinaction.coursemanager.client.managed.ui.renderer;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import org.rooinaction.coursemanager.web.proxy.TrainingProgramProxy;

public class TrainingProgramProxyRenderer extends ProxyRenderer<TrainingProgramProxy> {

    private static TrainingProgramProxyRenderer INSTANCE;

    protected TrainingProgramProxyRenderer() {
        super(new String[] { "name" });
    }

    public static TrainingProgramProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new TrainingProgramProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(TrainingProgramProxy object) {
        if (object == null) {
            return "";
        }
        return object.getName() + " (" + object.getName() + ")";
    }
}
