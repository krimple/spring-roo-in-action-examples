package org.rooinaction.coursemanager.model;

import org.springframework.roo.addon.dod.RooDataOnDemand;

@RooDataOnDemand(entity = Offering.class)
public class OfferingDataOnDemand {
	
	public Offering getNewTransientOfferingWithNullCourse(int index) {
        org.rooinaction.coursemanager.model.Offering obj = new org.rooinaction.coursemanager.model.Offering();
        setRunDate(obj, index);
        //setCourse(obj, index);
        setInstructor(obj, index);
        return obj;
    }
}
