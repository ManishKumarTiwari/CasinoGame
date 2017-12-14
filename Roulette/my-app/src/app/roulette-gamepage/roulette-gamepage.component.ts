import { Component, OnInit,Input } from '@angular/core';

@Component({
  selector: 'app-roulette-gamepage',
  templateUrl: './roulette-gamepage.component.html',
  styleUrls: ['./roulette-gamepage.component.css']
})
export class RouletteGamepageComponent implements OnInit {
  @Input() customerDetails
  constructor() { }

  ngOnInit() {
  }



}
