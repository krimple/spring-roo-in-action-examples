// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package org.rooinaction.coursemanager.web.request;
import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import java.util.List;
import org.rooinaction.coursemanager.web.proxy.TrainingProgramProxy;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("org.rooinaction.coursemanager.model.TrainingProgram")
@ServiceName("org.rooinaction.coursemanager.model.TrainingProgram")
public interface TrainingProgramRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countTrainingPrograms();

    abstract Request<List<TrainingProgramProxy>> findAllTrainingPrograms();

    abstract Request<List<TrainingProgramProxy>> findTrainingProgramEntries(int firstResult, int maxResults);

    abstract Request<TrainingProgramProxy> findTrainingProgram(Long id);

    abstract InstanceRequest<TrainingProgramProxy, Void> persist();

    abstract InstanceRequest<TrainingProgramProxy, Void> remove();
}
