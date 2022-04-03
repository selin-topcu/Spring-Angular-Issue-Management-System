package com.selind.issuemanagementsystem.api;

import com.selind.issuemanagementsystem.dto.ProjectDto;
import com.selind.issuemanagementsystem.service.implement.ProjectServiceImplement;
import com.selind.issuemanagementsystem.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/versioning")
@Api(value=ApiPaths.ProjectController.CTRL,description = "Project API's")
public class ProjectVersionApi {
    @Autowired
    private ProjectServiceImplement projectServiceImplement;

    @GetMapping(value = "/{id}", params = "version=1")
    @ApiOperation(value="Get by id V1",response= ProjectDto.class)
    public ResponseEntity<ProjectDto> getByIdV1(@PathVariable(value="id",required = true) Long id){
        ProjectDto projectDto=projectServiceImplement.getById(id);
        return ResponseEntity.ok(projectDto);
    }
    @GetMapping(value ="/{id}", params = "version=2")
    @ApiOperation(value="Get by id V2",response=ProjectDto.class)
    public ResponseEntity<ProjectDto> getByIdV2(@PathVariable(value="id",required = true) Long id){
        ProjectDto projectDto=projectServiceImplement.getById(id);
        return ResponseEntity.ok(projectDto);
    }
}
