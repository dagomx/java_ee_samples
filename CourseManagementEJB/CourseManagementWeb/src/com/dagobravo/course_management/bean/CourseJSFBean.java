package com.dagobravo.course_management.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.dagobravo.course_management.dto.CourseDTO;
import com.dagobravo.course_management.ejb.CourseBeanRemote;

@ManagedBean(name="Course")
public class CourseJSFBean {
	@EJB
	CourseBeanRemote courseBean;

	public List<CourseDTO> getCourses() {
		return courseBean.getCourses();
	}
}
