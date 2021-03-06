package com.example.ppmtrackertool.web;

import com.example.ppmtrackertool.services.MapValidationErrorService;
import com.example.ppmtrackertool.services.ProjectService;
import com.example.ppmtrackertool.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @Autowired
    MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject( @Valid @RequestBody Project project, BindingResult bindingResult) {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapvalidationService(bindingResult);
        if (errorMap != null)
            return errorMap;
        Project project1 = projectService.saveOrUpdate(project);
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }

    @GetMapping("/test")
    public String testMesage() {
        return "Test Message!";
    }
}
