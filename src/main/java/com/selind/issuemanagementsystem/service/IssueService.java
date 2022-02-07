package com.selind.issuemanagementsystem.service;

import com.selind.issuemanagementsystem.dto.IssueDto;
import com.selind.issuemanagementsystem.util.TPage;
import org.springframework.data.domain.Pageable;

public interface IssueService {
    IssueDto save(IssueDto issue); //kaydedilen parametrenin son halini geri döndürdü
    IssueDto getById(Long id); //bu metodu kullandığımız da verdiğmiz idyi getirir
    TPage<IssueDto> getAllPageable(Pageable pageable); //20'er verili sayfalama işlemini yapar
    Boolean delete(Long issue);
    IssueDto update(Long id, IssueDto project);
}
