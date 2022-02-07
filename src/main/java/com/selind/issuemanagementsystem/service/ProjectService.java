package com.selind.issuemanagementsystem.service;

import com.selind.issuemanagementsystem.dto.ProjectDto;
import com.selind.issuemanagementsystem.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {
    ProjectDto save(ProjectDto project);
    ProjectDto getById(Long id);
    Project getByProjectCode(String projectCode);
    List<Project> getByProjectCodeContains(String projectCode);

    Page<Project> getAllPageable(Pageable pageable);
    Boolean delete(ProjectDto project);
    ProjectDto update(Long id, ProjectDto project);
}
