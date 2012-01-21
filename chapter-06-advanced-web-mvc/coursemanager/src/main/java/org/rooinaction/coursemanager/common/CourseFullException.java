package org.rooinaction.coursemanager.common;

public class CourseFullException extends RuntimeException {
   public CourseFullException(String message) {
     super(message);
   }
}