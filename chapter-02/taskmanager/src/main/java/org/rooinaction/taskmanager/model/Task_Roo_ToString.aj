// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.rooinaction.taskmanager.model;

import java.lang.String;

privileged aspect Task_Roo_ToString {
    
    public String Task.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Completed: ").append(getCompleted()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Task: ").append(getTask()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }
    
}
