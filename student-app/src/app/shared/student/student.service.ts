import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
@Injectable()
export class StudentService {
  public STUDENT_URL = '/api/student';
  constructor(private http: HttpClient) {
  }
  getAll(): Observable<any> {
    return this.http.get(this.STUDENT_URL);
  }
  get(id: string) {
    return this.http.get(this.STUDENT_URL + '/' + id);
  }
  save(student: any): Observable<any> {
    let result: Observable<Object>;
    console.log('service save id'+ student.id);
    console.log('service save name'+ student.name);
    if (student.id) {
      result = this.http.put(this.STUDENT_URL, student);
    } else {
      result = this.http.post(this.STUDENT_URL, student);
    }
    return result;
  }
  remove(id: string) {
    console.log('service delete id'+ id);
    return this.http.delete(this.STUDENT_URL+ '/' + id);
  }
}
