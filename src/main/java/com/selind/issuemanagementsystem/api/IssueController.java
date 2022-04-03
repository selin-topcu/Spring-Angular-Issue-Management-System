package com.selind.issuemanagementsystem.api;

import com.selind.issuemanagementsystem.dto.IssueDto;
import com.selind.issuemanagementsystem.service.implement.IssueServiceImplement;
import com.selind.issuemanagementsystem.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueController.CTRL)
@Api(value =ApiPaths.IssueController.CTRL, description = "Issue API's")
public class IssueController {
    //
    private final IssueServiceImplement issueServiceImplement;

    public IssueController(IssueServiceImplement issueServiceImplement) {
        this.issueServiceImplement = issueServiceImplement;
    }

    //projectdto üzerinden nesneleri idsine göre getirme işlemi PathVariable: GetMapping de verilen idyi alıp getirecek
    @GetMapping("/{id}")
    @ApiOperation(value="Get by id",response= IssueDto.class)
    public ResponseEntity<IssueDto> getById(@PathVariable(value="id",required = true) Long id){
        IssueDto projectDto=issueServiceImplement.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping
    @ApiOperation(value="Create by id",response=IssueDto.class)
    public ResponseEntity<IssueDto> createProject(@Valid @RequestBody IssueDto project){
        return ResponseEntity.ok(issueServiceImplement.save(project));
    }

    @PutMapping("/{id}")
    @ApiOperation(value="Update by id",response=IssueDto.class)
    public ResponseEntity<IssueDto> updateProject(@PathVariable("id") Long id,@Valid @RequestBody IssueDto project){
        return ResponseEntity.ok(issueServiceImplement.update(id,project));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Delete by id",response=Boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value="id",required = true) Long id, @Valid @RequestBody IssueDto project){
        return ResponseEntity.ok(issueServiceImplement.delete(id));
    }
}
