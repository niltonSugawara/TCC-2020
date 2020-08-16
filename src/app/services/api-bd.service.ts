import { HttpClientModule, HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class ApiBdService {

  constructor(private http: HttpClient) { }

  add(task: string) {
    const url = 'http://localhost:17901/api/expririence/AddTask';

    const header = {
      headers: new HttpHeaders()
        .set('Content-Type', 'application/json')}

    const param = { nome: task };

    return this.http.post(url, param, header).toPromise();
  }

  update(task: any) {
    const url = 'http://localhost:17901/api/expririence/UpdateTask';

    const header = {
      headers: new HttpHeaders()
        .set('Content-Type', 'application/json')
    };

    return this.http.put(url, task, header).toPromise();
  }

  list() {
    const url = 'http://localhost:17901/api/expririence/ListTask';

    return this.http.get(url).toPromise();
  }

  delete(id: any) {
    const url = 'http://localhost:17901/api/expririence/' + id;

    return this.http.delete(url).toPromise();
  }
}
