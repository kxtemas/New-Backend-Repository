package com.example.capstone45.data;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.example.capstone45.models.ProjectModel;

@Service
public class ProjectDataService {


	/*
	 * Katie Munoz
	 * March 25, 2023
	 * 
	 */

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
	 * Returns a list of all the courses in a database.
	 * .
	 *
	 * @return List<CoursetModel> List of courses
	 */
    public List<ProjectModel> findAllProjects(){
        String sql = "SELECT * FROM CAPSTONE.PROJECT";
        List<ProjectModel> projects = new ArrayList<>();
        try {
            SqlRowSet srs = jdbcTemplate.queryForRowSet(sql);
            while (srs.next()){
                projects.add(new ProjectModel(srs.getInt("ID"), srs.getString("COURSE_ID"),  srs.getString("PROJECT_NAME"), srs.getString("PROJECT_DES"),  srs.getString("PROJECT_SKILLS"), srs.getString("PROJECT_FW"), srs.getString("PROJECT_IMG")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return projects;
    }
    public ProjectModel findProjectById(int id){
        String sql = "SELECT * FROM CAPSTONE.PROJECT WHERE ID =?";
        ProjectModel project = new ProjectModel();
        try {
            SqlRowSet srs = jdbcTemplate.queryForRowSet(sql, id);
            while (srs.next())
            {
                project.setProjectId(id);
                project.setCourseId(srs.getString("COURSE_ID"));
            project.setProjectName(srs.getString("PROJECT_NAME"));
                project.setProjectDes(srs.getString("PROJECT_DES"));
     
              project.setProjectSkills(srs.getString("PROJECT_SKILLS"));
              project.setProjectFw(srs.getString("PROJECT_FW"));
               project.setProjectImg(srs.getString("PROJECT_IMG"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return project;
    }
    
    /**
   	 * Returns a list of all the courses in a database based of course id.
   	 * .
   	 *
   	 * @return <CoursetModel> where the course id=
   	 */
  
    public List<ProjectModel> findProjectByCourseId(int courseid){
        String sql = "SELECT * FROM CAPSTONE.PROJECT WHERE 'COURSE_ID' = ?";
        List<ProjectModel> projects = new ArrayList<>();
        try {
            SqlRowSet srs = jdbcTemplate.queryForRowSet(sql, courseid);
            while (srs.next()){
                projects.add(new ProjectModel(srs.getInt("ID"), srs.getString("COURSE_ID"),  srs.getString("PROJECT_NAME"), srs.getString("PROJECT_DES"),  srs.getString("PROJECT_SKILLS"), srs.getString("PROJECT_FW"), srs.getString("PROJECT_IMG")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return projects;
    
    }
	/**
	 * Create a course for the database. Returns an boolean so a
	 * proper error message can be displayed.
	 *
	 * @param courseModel Used to add course to database
	 *
	 * @return boolean Used to determine what to do
	 */
    public boolean createProject(ProjectModel project) {
		 String sql = "INSERT INTO CAPSTONE.PROJECT(PROJECT_NAME, PROJECT_DES, COURSE_ID, PROJECT_SKILLS, PROJECT_FW, PROJECT_IMG) VALUES (?,?,?,?,?,?)";
	        try {
	            jdbcTemplate.update(sql,  project.getProjectName(),  project.getProjectDes(),  project.getCourseId(),  project.getProjectSkills(),  project.getProjectFw(),
	            		 project.getProjectImg());
	        }catch (Exception e){
	            e.printStackTrace();
	            return false;
	        }
	        return true;
	    }


    /**
	 * Change a course from the database. Returns an boolean so a
	 * proper error message can be displayed.
	 *
	 * @param courseModel Used to change courset from database
	 *
	 * @return boolean Used to determine what to do
	 */
    public boolean updateProject(ProjectModel project, int projectId) {
        String sql = "UPDATE CAPSTONE.PROJECT SET PROJECT_NAME = ?, PROJECT_DES = ?,COURSE_ID = ?, PROJECT_SKILLS = ?, PROJECT_FW = ?, PROJECT_IMG = ?   WHERE ID = ?";
        try {
            jdbcTemplate.update(sql, project.getProjectName(),project.getProjectDes(), project.getCourseId(), project.getProjectSkills(), project.getProjectFw(),
            		project.getProjectImg(), projectId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /**
	 * Delete the course from the database.
	 *
	 * @param courseModel Used to find out which course to delete from database
	 *
	 * @return boolean Used to determine what happened
	 */
    public boolean deleteProject(int projectId){
        String sql = "DELETE FROM CAPSTONE.PROJECT WHERE ID = ?";
        try {
            jdbcTemplate.update(sql, projectId);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }





}
