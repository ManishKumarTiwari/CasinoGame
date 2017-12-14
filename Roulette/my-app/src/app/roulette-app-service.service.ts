import { Injectable } from '@angular/core';
import {Http,Response,Headers,RequestOptions} from "@angular/http";
import "rxjs/Rx";
import {Observable} from "rxjs";
@Injectable()
export class RouletteAppServiceService {

  constructor(private http:Http) {
  }

  checkUuid(uuid:string):Observable<string>{
    console.log("logging uuid in service"+uuid);
    console.log("posting from services :: the uuid is :: ",uuid);
    const url ='http://localhost:9090/checkClientUuid/'+uuid;
    return this.http.get(url)
      .map((res:Response)=> {
        return <string>res.text();
    });
  }

  findGameResult(betdata:Object,id:number):Observable<any>{
    console.log("id is" +id);
    console.log(typeof id);
    const url ='http://localhost:9090/playgame/'+id;
    let headers=new Headers({'Content-Type':'application/json'});
    let option=new RequestOptions({headers:headers});
    let body=JSON.stringify(betdata);

    return this.http.post(url,body,option)
      .map(function (res:Response) {
        return <string>res.text();
      })
      .catch(function (error:any) {
        console.error(error);
        return Observable.throw(error.statusText);
      });
  }

  //    post request in angular 5
  //    const headers = new HttpHeaders()
  //       .set('Content-Type', 'application/json')
  //    return this.http.post('http://localhost:5000/info',{"name":"manish"},{headers:headers});
  //    no need for observables also it can be sent without headers

}
