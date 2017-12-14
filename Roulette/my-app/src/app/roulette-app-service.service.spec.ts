import { TestBed, inject } from '@angular/core/testing';

import { RouletteAppServiceService } from './roulette-app-service.service';

describe('RouletteAppServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RouletteAppServiceService]
    });
  });

  it('should be created', inject([RouletteAppServiceService], (service: RouletteAppServiceService) => {
    expect(service).toBeTruthy();
  }));
});
