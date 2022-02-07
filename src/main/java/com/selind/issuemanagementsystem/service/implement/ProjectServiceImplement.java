package com.selind.issuemanagementsystem.service.implement;

import com.selind.issuemanagementsystem.entity.Project;
import com.selind.issuemanagementsystem.repository.ProjectRepository;
import com.selind.issuemanagementsystem.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImplement implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImplement(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project save(Project project) {
        if(project.getProjectCode()==null){
            throw new IllegalArgumentException("Project code cannot be null");
        }
        project=projectRepository.save(project);
        return project;
    }

    @Override
    public Project getById(Long id) {
        return projectRepository.getById(id);
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Project project) {
        return null;
    }
}
