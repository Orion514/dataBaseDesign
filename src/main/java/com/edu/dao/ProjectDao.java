package com.edu.dao;

import com.edu.po.Project;

import java.util.List;

public interface ProjectDao {
    public Project selectProjectByIdentifier(String identifier);

    public void AddProject(Project project);

    public List<Project> selectProjectByTutorId(String tutor_id);

    public void UpdateProject(Project project);
}
