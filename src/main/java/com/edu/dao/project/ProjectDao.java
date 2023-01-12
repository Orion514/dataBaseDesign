package com.edu.dao.project;

import com.edu.domain.project.Project;

import java.util.List;

public interface ProjectDao {
    public Project selectProjectByIdentifier(String identifier);

    public void AddProject(Project project);

    public List<Project> selectProjectByTutorId(String tutor_id);

    public void UpdateProject(Project project);
}
