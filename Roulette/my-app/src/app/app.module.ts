import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { RouletteLogInPageComponent } from './roulette-log-in-page/roulette-log-in-page.component';
import { RouletteGamepageComponent } from './roulette-gamepage/roulette-gamepage.component';
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {RouletteAppServiceService} from "./roulette-app-service.service";
import { GamepageComponent } from './roulette-log-in-page/gamepage/gamepage.component';
import {RouterModule} from "@angular/router";


@NgModule({
  declarations: [
    AppComponent,
    RouletteLogInPageComponent,
    RouletteGamepageComponent,
    GamepageComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot([{path:'game',component:GamepageComponent},
      {path:'login',component:RouletteLogInPageComponent},
      {path:"",redirectTo:'/login',pathMatch:'full'},
      {path:"**",redirectTo:'/login',pathMatch:'full'}
    ])

  ],
  providers: [RouletteAppServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
