package com.dagobravo.course_management.ejb;

import java.util.List;

import javax.ejb.Remote;

import com.dagobravo.course_management.dto.CourseDTO;

@Remote
public interface CourseBeanRemote {
	public List<CourseDTO> getCourses();
}
