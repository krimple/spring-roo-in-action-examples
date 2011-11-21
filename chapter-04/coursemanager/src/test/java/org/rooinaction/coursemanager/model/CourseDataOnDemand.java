package org.rooinaction.coursemanager.model;

import org.springframework.roo.addon.dod.RooDataOnDemand;

@RooDataOnDemand(entity = Course.class)
public class CourseDataOnDemand {

  public void setTrainingProgram(Course obj, int index) {
    TrainingProgramDataOnDemand tpdod = new TrainingProgramDataOnDemand();
    TrainingProgram trainingProgram = tpdod.getNewTransientTrainingProgram(0);    
    obj.setTrainingProgram(trainingProgram);
  }
}
