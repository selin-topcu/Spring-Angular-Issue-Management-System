package com.selind.issuemanagementsystem.repository;

import com.selind.issuemanagementsystem.entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory,Long> {
}
