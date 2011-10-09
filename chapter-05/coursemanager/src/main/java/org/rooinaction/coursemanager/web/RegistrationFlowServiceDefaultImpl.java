package org.rooinaction.coursemanager.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.rooinaction.coursemanager.model.Course;
import org.rooinaction.coursemanager.model.Offering;
import org.rooinaction.coursemanager.model.Registration;
import org.rooinaction.coursemanager.model.Student;
import org.rooinaction.coursemanager.service.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.webflow.action.MultiAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

@Service("registrationFlowService")
public class RegistrationFlowServiceDefaultImpl extends MultiAction
                                                implements RegistrationFlowService {
	
	@Autowired
	private RegistrationService registrationService;

	Logger logger = LoggerFactory.getLogger(getClass());

	@Transactional(readOnly = true)
	@Override
	public List<Course> retrieveAllCourses() {
		return Course.findAllCourses();
	}

	@Transactional(readOnly = true)
	@Override
	public Event retrieveCourseOfferings(RequestContext context) {
		RegisterStudentsForm form = getForm(context);
		List<Offering> resultList = Offering.findOfferingsByCourseId(
				form.getCourseId()).getResultList();
		context.getViewScope().put("offeringList", resultList);
		return success();
	}

	/**
	 * Naive implementation - don't bother un-registering previously processed
	 * students, only look at ones from the current web flow... Ignore those
	 * that may have already been registered for now. This will cause a problem
	 * if you try to re-register a student for a course they already have
	 * registered for...
	 */
	@Transactional(readOnly = true)
	@Override
	public Event search(RequestContext context) {
		RegisterStudentsForm form = getForm(context);
		String name = form.getCurrentSearch();
		List<Student> students = name == null ? new ArrayList<Student>()
				: Student.findStudentsByName(name).getResultList();
		List<RegisterStudentsSearchResult> results = new ArrayList<RegisterStudentsSearchResult>();
		Iterator<Student> iterator = students.iterator();
		while (iterator.hasNext()) {
			Student student = iterator.next();
			results.add(new RegisterStudentsSearchResult(student, form
					.getStudentsToRegister().contains(student.getId())));
		}
		context.getViewScope().put("searchResults", results);
		return success();
	}
	
	@Override
	public Event addStudent(RequestContext context) {

		Long studentId = (Long) context.getExternalContext()
				.getRequestParameterMap().getRequiredLong("id");
		
		RegisterStudentsForm form = getForm(context);
				
		form.addStudent(studentId);
		
		return success();
		
	}

	@Override
	public Event removeStudent(RequestContext context) {
		Long studentId = (Long) context.getExternalContext()
				.getRequestParameterMap().getRequiredLong("id");
		RegisterStudentsForm form = getForm(context);
		if (form.getStudentsToRegister().contains(studentId)) {
			form.getStudentsToRegister().remove(studentId);
		}
		return success();
	}

	@Transactional(readOnly = true)
	@Override
	public Event findPendingStudents(RequestContext context) {
		RegisterStudentsForm form = getForm(context);
		List<Long> studentsToRegister = form.getStudentsToRegister();

		List<Student> pendingStudents = studentsToRegister.size() > 0 ? Student
				.findStudentsByIdIn(studentsToRegister).getResultList()
				: new ArrayList<Student>();

		context.getViewScope().put("pendingStudents", pendingStudents);
		return success();
	}

	@Override
	public Event completeRegistration(RequestContext context) {
		RegisterStudentsForm form = getForm(context);
		registrationService.registerStudents(form.getOfferingId(), form.getStudentsToRegister());
		return success();
	}

	private RegisterStudentsForm getForm(RequestContext context) {
		return (RegisterStudentsForm) context.getFlowScope().get(
				"registerStudentsForm");
	}

}
