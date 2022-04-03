import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
// import {IssueService} from "../../../services/shared/issue.service";
// import {ProjectService} from "../../../services/shared/project.service";
// import {UserService} from "../../../services/shared/user.service";
import {FormBuilder, FormGroup} from "@angular/forms";
import {DatePipe} from "@angular/common";

@Component({
  selector: 'app-issue-detail',
  templateUrl: './issue-detail.component.html',
  styleUrls: ['./issue-detail.component.scss']
})
export class IssueDetailComponent implements OnInit {


  constructor(  ) {

  }

  ngOnInit() {

}
}
