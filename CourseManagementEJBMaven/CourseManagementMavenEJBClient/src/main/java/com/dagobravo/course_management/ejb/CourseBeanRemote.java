package com.dagobravo.course_management.ejb;

import java.util.List;

import com.dagobravo.course_management.dto.CourseDTO;

public interface CourseBeanRemote {
	public List<CourseDTO> getCourses(); 
}
