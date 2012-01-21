package org.rooinaction.coursemanager.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.dod.RooDataOnDemand;

@RooDataOnDemand(entity = Course.class)
public class CourseDataOnDemand {

  public void setTrainingProgramDataOnDemand(TrainingProgramDataOnDemand dod) {
    this.trainingProgramDataOnDemand = dod;
  }

  @Autowired
  private TrainingProgramDataOnDemand trainingProgramDataOnDemand;


}
