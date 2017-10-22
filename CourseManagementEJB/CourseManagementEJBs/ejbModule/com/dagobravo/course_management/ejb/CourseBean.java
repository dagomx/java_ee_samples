package com.dagobravo.course_management.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.dagobravo.course_management.dto.CourseDTO;
import com.dagobravo.course_management.model.Course;

@Stateless
@LocalBean
public class CourseBean implements CourseBeanRemote {
	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public CourseBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<CourseDTO> getCourses() {
		// get course entities first
		List<Course> courseEntities = getCourseEntities();
		// create list of course DTOs. This is the result we will return
		List<CourseDTO> courses = new ArrayList<CourseDTO>();
		for (Course courseEntity : courseEntities) {
			// Create CourseDTO from Course entity
			CourseDTO course = new CourseDTO();
			course.setId(courseEntity.getId());
			course.setName(courseEntity.getName());
			course.setCredits(courseEntity.getCredits());
			courses.add(course);
		}
		return courses;
	}

	public List<Course> getCourseEntities() {
		// Use named query created in Course entity using @NameQuery annotation.
		TypedQuery<Course> courseQuery = entityManager.createNamedQuery("Course.findAll", Course.class);
		return courseQuery.getResultList();
	}

}
