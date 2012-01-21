// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.web.gwt.requests;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest(value = "org.rooinaction.coursemanager.model.TrainingProgram", exclude = { "clear", "entityManager", "equals", "flush", "hashCode", "merge", "toString" })
@ServiceName("org.rooinaction.coursemanager.model.TrainingProgram")
public interface TrainingProgramRequest extends RequestContext {

    abstract Request<java.lang.Long> countTrainingPrograms();

    abstract Request<java.util.List<org.rooinaction.coursemanager.web.gwt.proxies.TrainingProgramProxy>> findAllTrainingPrograms();

    abstract Request<java.util.List<org.rooinaction.coursemanager.web.gwt.proxies.TrainingProgramProxy>> findTrainingProgramEntries(int firstResult, int maxResults);

    abstract Request<org.rooinaction.coursemanager.web.gwt.proxies.TrainingProgramProxy> findTrainingProgram(Long id);

    abstract InstanceRequest<org.rooinaction.coursemanager.web.gwt.proxies.TrainingProgramProxy, java.lang.Void> persist();

    abstract InstanceRequest<org.rooinaction.coursemanager.web.gwt.proxies.TrainingProgramProxy, java.lang.Void> remove();
}
