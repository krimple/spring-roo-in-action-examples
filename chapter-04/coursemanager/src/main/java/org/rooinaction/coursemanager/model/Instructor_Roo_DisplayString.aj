// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.rooinaction.coursemanager.model;

privileged aspect Instructor_Roo_DisplayString {
    
    public java.lang.String Instructor.getDisplayString() {
        return new StringBuilder().append(getFirstName()).append(" ").append(getMiddleNameOrInitial()).append(" ").append(getLastName()).append(" ").append(getAddressLine1()).append(" ").append(getAddressLine2()).toString();
    }
    
}
