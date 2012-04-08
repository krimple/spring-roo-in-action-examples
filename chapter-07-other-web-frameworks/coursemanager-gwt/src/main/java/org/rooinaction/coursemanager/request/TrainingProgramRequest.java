// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.request;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("org.rooinaction.coursemanager.shared.model.TrainingProgram")
@ServiceName("org.rooinaction.coursemanager.shared.model.TrainingProgram")
public interface TrainingProgramRequest extends RequestContext {

    abstract Request<java.lang.Long> countTrainingPrograms();

    abstract Request<java.util.List<org.rooinaction.coursemanager.proxy.TrainingProgramProxy>> findAllTrainingPrograms();

    abstract Request<java.util.List<org.rooinaction.coursemanager.proxy.TrainingProgramProxy>> findTrainingProgramEntries(int firstResult, int maxResults);

    abstract Request<org.rooinaction.coursemanager.proxy.TrainingProgramProxy> findTrainingProgram(Long id);

    abstract InstanceRequest<org.rooinaction.coursemanager.proxy.TrainingProgramProxy, java.lang.Void> persist();

    abstract InstanceRequest<org.rooinaction.coursemanager.proxy.TrainingProgramProxy, java.lang.Void> remove();
}
