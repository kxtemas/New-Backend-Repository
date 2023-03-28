package com.example.capstone45.models;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class ProjectModel {

	private int projectId;
	/*
	 * Katie Munoz
	 * March 25, 2023
	 * 
	 */

    @NotNull(message="Coursename is a required field")
    @Size(min=1, max=32, message="course name must be between 1 and 32 characters")
    @ApiModelProperty(value = "course name", example = "cst323")
    private String projectName;

    @NotNull(message="coursede is a required field")
    @Size(min=1, max=32, message="coursedes must be between 1 and 150 characters")
    @ApiModelProperty(value = "course description")
    private String projectDes;

    @NotNull(message="Projects is a required field")
    @Size(min=1, max=32, message="Projects must be between 1 and 32 characters")
    @ApiModelProperty(value = "projects from course", example = "music app")
    private String courseId;

    @NotNull(message="course skills is a required field")
    @Size(min=1, max=32, message="course skils must be between 1 and 32 characters")
    @ApiModelProperty(value = "skills lesrned in course", example = "AJAX")
    private String projectSkills;
    
    @NotNull(message=" projectframework is a required field")
    @Size(min=1, max=32, message="course framework must be between 1 and 32 characters")
    @ApiModelProperty(value = "framework lesrned in course", example = "AJAX")
    private String projectFw;


    @NotNull(message="course img is a required field")
    @Size(min=1, max=32, message="image must be between 1 and 150 characters")
    @ApiModelProperty(value = "picture of course", example = "course.jpg")
    private String projectImg;


    /**
	 * Parameterized Constructor
	 *
	 * @param courseId Id of product in database
	 * @param courseName Name of course
	 * @param courseDes description of course
	 * @param projects course projects
	 * @param courseSkills skills lesrned in course
	 * @param courseImg image of course
	 */
    /**
	 * Default constructor
	 */
    public ProjectModel(int projectId, String courseId,String projectName, String projectDes,  String projectSkills, String projectFw, String projectImg) {
    	this.projectId =projectId;
    	this.projectName = projectName;
        this.projectDes =projectDes;
        this.courseId = courseId;
        this.projectFw = projectFw;
          this.projectSkills =projectSkills;
        this.projectImg = projectImg;
    }



  //Getters and Setters

    public ProjectModel() {
    }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String courseName) {
            this.projectName = courseName;
        }

        public String getProjectDes() {
            return projectDes;
        }

        public void setProjectDes(String projectDes) {
            this.projectDes = projectDes;
        }

        public String getCourseId() {
            return courseId;
        }

        public void setCourseId(String courseId) {
            this.courseId = courseId;
        }

        public String getProjectSkills() {
            return projectSkills;
        }

        public void setProjectSkills(String projectSkills) {
            this.projectSkills = projectSkills;
        }

        public String getProjectFw() {
            return projectFw;
        }

        public void setProjectFw(String projectFw) {
            this.projectFw = projectFw;
        }

        public String getProjectImg() {
            return projectImg;
        }

        public void setProjectImg(String projectImg) {
            this.projectImg = projectImg;
        }
        public int getProjectId() {
            return projectId;
        }

        public void setProjectId(int projectId) {
            this.projectId =projectId;
        }




    }



