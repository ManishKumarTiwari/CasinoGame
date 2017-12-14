import { Component, OnInit } from '@angular/core';
import {RouletteAppServiceService} from "../roulette-app-service.service"
import {Router} from "@angular/router";
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-roulette-log-in-page',
  templateUrl: './roulette-log-in-page.component.html',
  styleUrls: ['./roulette-log-in-page.component.css']
})
export class RouletteLogInPageComponent implements OnInit {
  errormsg: string = "";
  private uuid: string = '';
  userdata: Object = {};

  constructor(private service: RouletteAppServiceService, private router: Router) {
  }

  ngOnInit() {
      var retrievedObject = sessionStorage.getItem('userdata');
      var mycustomerdata = JSON.parse(retrievedObject);
      if (mycustomerdata['uuid'] != null) {
        this.router.navigate(['game']);
      }
    }
  redirect() {
    this.router.navigate(['game']);
  }

  submitForm(form: NgForm) {
    if (form.dirty === false)
      this.errormsg = "* incorrect id...Please Try Again";

    else {
      this.service.checkUuid(this.uuid)
        .subscribe(
          data => {
            if (data.length != 0) {
              this.userdata = JSON.parse(data);
              console.log(this.userdata['id']);
              sessionStorage.setItem('userdata', data);
              this.redirect();
            }
            else
              this.errormsg = "* incorrect id...Please Try Again";
          },
          function (err) {
            console.log("error occurred in component ", err);
          });
    }
  }
}

