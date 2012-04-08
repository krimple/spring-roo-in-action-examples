package org.rooinaction.coursemanager.server.locator;

import com.google.web.bindery.requestfactory.shared.Locator;
import org.rooinaction.coursemanager.shared.model.TrainingProgram;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("org.rooinaction.coursemanager.shared.model.TrainingProgram")
@Component
public class TrainingProgramLocator extends Locator<TrainingProgram, Long> {

    public TrainingProgram create(Class<? extends org.rooinaction.coursemanager.shared.model.TrainingProgram> clazz) {
        return new TrainingProgram();
    }

    public TrainingProgram find(Class<? extends org.rooinaction.coursemanager.shared.model.TrainingProgram> clazz, Long id) {
        return TrainingProgram.findTrainingProgram(id);
    }

    public Class<org.rooinaction.coursemanager.shared.model.TrainingProgram> getDomainType() {
        return TrainingProgram.class;
    }

    public Long getId(TrainingProgram trainingProgram) {
        return trainingProgram.getId();
    }

    public Class<java.lang.Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(TrainingProgram trainingProgram) {
        return trainingProgram.getVersion();
    }
}
