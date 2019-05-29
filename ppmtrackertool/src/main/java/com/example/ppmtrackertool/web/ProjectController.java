package com.example.ppmtrackertool.web;

import com.example.ppmtrackertool.ProjectService;
import com.example.ppmtrackertool.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping("")
    public ResponseEntity<Project> createNewProject(@RequestBody Project project) {
        projectService.saveOrUpdate(project);
        return new ResponseEntity<Project>(project, HttpStatus.ACCEPTED);
    }

    @GetMapping("/test")
    public String testMesage() {
        return "Test Message!";
    }
}
