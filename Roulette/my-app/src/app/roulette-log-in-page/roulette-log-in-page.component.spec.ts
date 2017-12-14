import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RouletteLogInPageComponent } from './roulette-log-in-page.component';

describe('RouletteLogInPageComponent', () => {
  let component: RouletteLogInPageComponent;
  let fixture: ComponentFixture<RouletteLogInPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RouletteLogInPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RouletteLogInPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
