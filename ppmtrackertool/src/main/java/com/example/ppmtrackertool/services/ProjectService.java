package com.example.ppmtrackertool.services;

import com.example.ppmtrackertool.domain.Project;
import com.example.ppmtrackertool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdate(Project project) {
        return projectRepository.save(project);
    }
}
