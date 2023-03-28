package com.example.capstone45.business;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.capstone45.data.ProjectDataService;
import com.example.capstone45.models.ProjectModel;

@Service
public class ProjectBusinessService {
	/*
	 * Katie Munoz
	 * March 25, 2023
	 * 
	 */
    @Autowired
    private ProjectDataService service;

    public ProjectBusinessService(ProjectDataService service) {
        this.service = service;
    }

    /**
	 * Returns a list of all the courses by calling the DAO service
	 *
	 * @param  determines what courses are pulled.
	 *
	 * @return List<CourseModel> List of courses
	 */
    public List<ProjectModel> findAllProjects(){
        return service.findAllProjects();
    }

    public ProjectModel findProjectById(int projectId){
        return service.findProjectById(projectId);
    }
    public List<ProjectModel> findProjectByCourseId(int courseId){
        return service.findProjectByCourseId(courseId);
    }
    /**
    * Create a course by calling DAO. Returns an boolean so a
	 * proper error message can be displayed.
	 *
	 * @param coursetModel Used to add course
	 *
	 * @return boolean Used to determine what to do
	 */
    public boolean createProject(ProjectModel project){
        return service.createProject(project);
    }


    /**
	 * Change a course by calling the DAO. Returns an boolean so a
	 * proper error message can be displayed.
	 *
	 * @param courseModel Used to change course
	 *
	 * @return boolean Used to determine what to do
	 */

    public boolean updateProject(ProjectModel projectModel, int projectId){
        return service.updateProject(projectModel, projectId);
    }

    /**
	 * Delete the course by calling DAO service
	 *
	 * @param courseModel Used to find out which course to delete
	 *
	 * @return boolean Used to determine what happened
	 */

    public boolean deleteProject(int projectId){
        return service.deleteProject(projectId);
    }

}
