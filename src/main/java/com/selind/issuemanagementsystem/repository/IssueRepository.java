package com.selind.issuemanagementsystem.repository;

import com.selind.issuemanagementsystem.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue,Long> {//hangi tabloya hizmet edeceğini ve id türünün ne olduğunu belirtiyoruz

}
