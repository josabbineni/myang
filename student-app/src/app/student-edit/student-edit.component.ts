import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from '../shared/student/student.service';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-student-edit',
  templateUrl: './student-edit.component.html',
  styleUrls: ['./student-edit.component.css']
})
export class StudentEditComponent implements OnInit, OnDestroy {
  student: any = {};
  sub: Subscription;
  constructor(private route: ActivatedRoute,
              private router: Router,
              private studentService: StudentService) {
  }
  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.studentService.get(id).subscribe((student: any) => {
          if (student) {
            this.student = student;
          } else {
            console.log(`Student with id '${id}' not found, returning to list`);
            this.gotoList();
          }
        });
      }
    });
  }
  ngOnDestroy() {
    this.sub.unsubscribe();
  }
  gotoList() {
    this.router.navigate(['/student-list']);
  }
  save(form: NgForm) {
    this.studentService.save(form).subscribe(result => {
      this.gotoList();
    }, error => console.error(error))
  }
  remove(id) {
    console.log('delete id' + id);
    this.studentService.remove(id).subscribe(result => {
      this.gotoList();
    }, error => console.error(error))
  }
}


