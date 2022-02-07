package com.selind.issuemanagementsystem.repository;

import com.selind.issuemanagementsystem.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {

    List<Project> getAllByProjectCode(String projectCode); //proje koduna göre getirmesini sağlar
    List<Project> getAllByProjectCodeContains(String projectCode);
    Page<Project> findAll(Pageable pageable);
    List<Project> findAll(Sort sort);

}
