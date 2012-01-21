package org.rooinaction.coursemanager.service;

import java.util.List;

import org.rooinaction.coursemanager.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("studentService")
public class StudentServiceBean implements StudentService {
	
	@Override
	@Transactional
	public void updateCities(List<Long> students, String city) {
		for (Long studentId : students) {
			Student student = Student.findStudent(studentId);
			student.setCity(city);
		}
	}
}
