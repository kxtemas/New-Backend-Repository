package com.example.capstone45.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.capstone45.data.CourseDataService;
import com.example.capstone45.models.CourseModel;

@Service
public class CourseBusinessService {
	/*
	 * Katie Munoz
	 * March 25, 2023
	 * 
	 */
    @Autowired
    private CourseDataService service;

    public CourseBusinessService(CourseDataService service) {
        this.service = service;
    }

    /**
	 * Returns a list of all the courses by calling the DAO service
	 *
	 * @param  determines what courses are pulled.
	 *
	 * @return List<CourseModel> List of courses
	 */
    public List<CourseModel> findAllCourses(){
        return service.findAllCourses();
    }

    public CourseModel findCourseById(int courseId){
        return service.findCourseById(courseId);
    }

    /**
    * Create a course by calling DAO. Returns an boolean so a
	 * proper error message can be displayed.
	 *
	 * @param coursetModel Used to add course
	 *
	 * @return boolean Used to determine what to do
	 */
    public boolean createCourse(CourseModel course){
        return service.createCourse(course);
    }


    /**
	 * Change a course by calling the DAO. Returns an boolean so a
	 * proper error message can be displayed.
	 *
	 * @param courseModel Used to change course
	 *
	 * @return boolean Used to determine what to do
	 */

    public boolean updateCourse(CourseModel courseModel, int courseId){
        return service.updateCourse(courseModel, courseId);
    }

    /**
	 * Delete the course by calling DAO service
	 *
	 * @param courseModel Used to find out which course to delete
	 *
	 * @return boolean Used to determine what happened
	 */

    public boolean deleteCourse(int courseId){
        return service.deleteCourse(courseId);
    }

}
