package com.example.capstone45.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.capstone45.business.CourseBusinessService;
import com.example.capstone45.business.ProjectBusinessService;
import com.example.capstone45.models.CourseModel;
import com.example.capstone45.models.ProjectModel;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/course")
public class CourseRestService {
	/*
	 * Katie Munoz
	 * March 25, 2023
	 * 
	 */
    @Autowired
    private CourseBusinessService courseBusinessService;
    private ProjectBusinessService projectBusinessService;


    /**
	 * Displays the main courses from dataservice
	 *
	 *
	 * @return json format of all courses
	 */
    @GetMapping("/")
    @ApiOperation(value = "Gets all courses")
    public ResponseEntity<?> findAllcourses(){
        try {
            List<CourseModel> users = courseBusinessService.findAllCourses();
            if(users == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(users, HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	/**
	 * Take user to the Detailed page for showing all details of a specific course
	 *
	 * @param course id
	 *
	 * @return specific course based of id
	 */
 
    @GetMapping("/{id}")
    @ApiOperation(value = "Get course by ID")
    public ResponseEntity<?> findCourseById(@PathVariable ("id") Integer courseId){
        try {
            CourseModel user = courseBusinessService.findCourseById(courseId);
            if(user == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   


	/**
	 * Post method that checks for validation and submits course page with new course added.
	 *
	 * @param coursetModel from form
	 * @param bindingResults for error page
	 * @param model for page attributes.
	 *
	 * @return add course
	 */
    @PostMapping("/")
    @ApiOperation(value = "Create a new course")
    public ResponseEntity<?> createCourse(@RequestBody CourseModel course){
        try {
            boolean status = courseBusinessService.createCourse(course);
            if(status){
                return new ResponseEntity<>(HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /**
	 * Put method to go to update course with the different information
	 *
	 * @param courseModel Object to forward details to update page
	 * @param model for page attributes
	 * @param binding Results for error page
	 *
	 * @return Update updated course response
	 */
    @PutMapping("/{id}")
    @ApiOperation(value = "Update a course")
    public ResponseEntity<?> updateCourse(@RequestBody CourseModel course, @PathVariable ("id") Integer courseId){
        try {
            boolean status = courseBusinessService.updateCourse(course, courseId);
            if(status){
                return new ResponseEntity<>(HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
	 * Delete method that checks for validation then deletes course.
	 *
	 * @param courseModel from form
	 * @param bindingResults for error page
	 * @param model for page attributes
	 *
	 * @return delete course
	 */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a course")
    public ResponseEntity<?> deleteCourse(@PathVariable ("id") Integer courseId){
        try {
            boolean status = courseBusinessService.deleteCourse(courseId);
            if(status){
                return new ResponseEntity<>(HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
            }

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
