package com.serms.service;

import com.serms.entity.Project;

import java.util.List;

public interface ProjectService {

    List<Project> getAllProjects();

    Project saveProject(Project project);

    Project getProjectById(Long id);

    Project updateProject(Project project);

    void deleteProject(Long id);

    List<Project> searchProjects(String keyword);

}