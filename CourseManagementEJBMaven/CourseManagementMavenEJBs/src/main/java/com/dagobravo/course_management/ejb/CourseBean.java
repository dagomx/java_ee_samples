package com.dagobravo.course_management.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.dagobravo.course_management.dto.CourseDTO;
import com.dagobravo.course_management.model.Course;

/**
 * Session Bean implementation class CourseBean
 */
@Stateless
@Remote
public class CourseBean implements CourseBeanRemote {

	/*
	 * This is optional if there's only one persistence unit defined in persistence.xml
	 * @PersistenceContext(unitName="CourseManagementMavenEJBs")
	 * */
	@PersistenceContext
	EntityManager entityManager;

	public CourseBean() {
		// TODO Auto-generated constructor stub
	}

	public List<CourseDTO> getCourses() {
		System.out.println("### CourseBean.getCourses():Linea 30");
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
		System.out.println("### CourseBean.getCourses():Linea 43");
		return courses;
	}

	public List<Course> getCourseEntities() {
		System.out.println("### CourseBean.getCourseEntities():Linea 48");
		// Use named query created in Course entity using @NameQuery annotation.
		TypedQuery<Course> courseQuery = entityManager.createNamedQuery("Course.findAll", Course.class);
		System.out.println("### CourseBean.getCourseEntities():Linea 51");
		return courseQuery.getResultList();
	}

}
