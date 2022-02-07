package com.selind.issuemanagementsystem.api;

import com.selind.issuemanagementsystem.dto.IssueDto;
import com.selind.issuemanagementsystem.service.implement.IssueServiceImplement;
import com.selind.issuemanagementsystem.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueController.CTRL)
public class IssueController {
    //
    private final IssueServiceImplement issueServiceImplement;

    public IssueController(IssueServiceImplement issueServiceImplement) {
        this.issueServiceImplement = issueServiceImplement;
    }

    //projectdto üzerinden nesneleri idsine göre getirme işlemi PathVariable: GetMapping de verilen idyi alıp getirecek
    @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getById(@PathVariable(value="id",required = true) Long id){
        IssueDto projectDto=issueServiceImplement.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping
    public ResponseEntity<IssueDto> createProject(@Valid @RequestBody IssueDto project){
        return ResponseEntity.ok(issueServiceImplement.save(project));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IssueDto> updateProject(@PathVariable("id") Long id,@Valid @RequestBody IssueDto project){
        return ResponseEntity.ok(issueServiceImplement.update(id,project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value="id",required = true) Long id, @Valid @RequestBody IssueDto project){
        return ResponseEntity.ok(issueServiceImplement.delete(id));
    }
}
