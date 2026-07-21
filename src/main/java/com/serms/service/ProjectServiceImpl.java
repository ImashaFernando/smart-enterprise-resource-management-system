package com.serms.service;

import com.serms.entity.Project;
import com.serms.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public Project updateProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public List<Project> searchProjects(String keyword) {

        if (keyword == null || keyword.trim().isEmpty()) {
            return projectRepository.findAll();
        }

        return projectRepository
                .findByProjectCodeContainingIgnoreCaseOrProjectNameContainingIgnoreCaseOrClientNameContainingIgnoreCaseOrProjectManagerContainingIgnoreCase(
                        keyword,
                        keyword,
                        keyword,
                        keyword
                );
    }
}