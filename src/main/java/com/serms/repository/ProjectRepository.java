package com.serms.repository;

import com.serms.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByProjectCodeContainingIgnoreCaseOrProjectNameContainingIgnoreCaseOrClientNameContainingIgnoreCaseOrProjectManagerContainingIgnoreCase(
            String projectCode,
            String projectName,
            String clientName,
            String projectManager
    );

}