import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import {RouletteAppServiceService} from "../../roulette-app-service.service"
import {Router} from "@angular/router";
declare let $ : any;
@Component({
  selector: 'app-gamepage',
  templateUrl: './gamepage.component.html',
  styleUrls: ['./gamepage.component.css']
})

export class GamepageComponent implements OnInit {
  firstTwelvePosition:number=0;
  secondTwelvePosition:number=0;
  thirdTwelvePosition:number=0;
  zerothPosition:number=0;
  oneToEighteen:number=0;
  ninteenToThirtysix:number=0;
  oddPosition:number=0;
  evenPosition:number=0;
  totalsum:number=0;

  name:string='';
  currentBalance:number=0;
  //errorModel:boolean=false;
  WinLossBetAmount:any=0;
  oldBalance:any=0;

  result:string='';
  randomNumber:string='';
  data1: Object = {};
  constructor(private service: RouletteAppServiceService, private router: Router) { }

  ngOnInit() {

      var retrievedObject = sessionStorage.getItem('userdata');
      var mycustomerdata = JSON.parse(retrievedObject);
      if(mycustomerdata===null){
        this.router.navigate(['login']);
      }
      this.name = mycustomerdata['name'];
      this.currentBalance = mycustomerdata['balance'];
    }

  logout(){
    console.log("session storage clean");
    sessionStorage.removeItem('userdata');
    this.router.navigate(['login']);

  }

  submitBetForm(form:NgForm){

      this.totalsum=this.thirdTwelvePosition+this.evenPosition+this.firstTwelvePosition+this.ninteenToThirtysix
        +this.oddPosition+this.secondTwelvePosition+this.zerothPosition+this.oneToEighteen;

      console.log("the entred value is "+this.firstTwelvePosition);
      var retrievedObject = sessionStorage.getItem('userdata');
      var mycustomerdata= JSON.parse(retrievedObject);
      var id=Number(mycustomerdata['id']);
      var balance1=Number(mycustomerdata['balance']);
      this.oldBalance=balance1;

      if(this.totalsum==0){
        alert("No amount seleced to bet")
      }

  else {
        if (balance1 >= this.totalsum && balance1 != 0) {
          //make post request to calculate win/lose
          let betdata = {
            firstTwelvePosition: this.firstTwelvePosition,
            secondTwelvePosition: this.secondTwelvePosition,
            thirdTwelvePosition: this.thirdTwelvePosition,
            zerothPosition: this.zerothPosition,
            oneToEighteen: this.oneToEighteen,
            ninteenToThirtysix: this.ninteenToThirtysix,
            oddPosition: this.oddPosition,
            evenPosition: this.evenPosition,
            blocAmount: this.totalsum
          }
          //service call here
          this.service.findGameResult(betdata, id)
            .subscribe(
              (data) => {

                this.data1 = JSON.parse(data);
                this.randomNumber = this.data1['randomNumberGenerated'].toString();

                var newUpdatedBalance = Number(this.data1['balance']);
                   //set new data to the session
                sessionStorage.setItem('userdata', data);
                if (this.oldBalance - newUpdatedBalance > 0) {
                  this.result = "Lost";
                  this.WinLossBetAmount = this.oldBalance - newUpdatedBalance;
                }
                else {
                  this.result = "Won";
                  this.WinLossBetAmount = newUpdatedBalance - this.oldBalance;
                }

                //render the game result model
                $("#myResultModal").modal();
              }
              ,
              function (err) {
                console.log("error occurred in component ", err);
              }
            );
        }
        else {
          $("#myErrorModal").modal();
        }
      }
  }

  resetSelection(){
    this.thirdTwelvePosition=0;
    this.evenPosition=0;
    this.firstTwelvePosition=0;
    this.ninteenToThirtysix=0;
    this.oddPosition=0;
    this.secondTwelvePosition=0;
    this.zerothPosition=0;
    this.oneToEighteen=0;

  }
  resetAfterResult(){
    this.router.navigate(['login']);
  }


}

