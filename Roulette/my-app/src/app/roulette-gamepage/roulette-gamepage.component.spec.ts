import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RouletteGamepageComponent } from './roulette-gamepage.component';

describe('RouletteGamepageComponent', () => {
  let component: RouletteGamepageComponent;
  let fixture: ComponentFixture<RouletteGamepageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RouletteGamepageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RouletteGamepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
