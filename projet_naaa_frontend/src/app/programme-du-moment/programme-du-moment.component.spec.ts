import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgrammeDuMomentComponent } from './programme-du-moment.component';

describe('ProgrammeDuMomentComponent', () => {
  let component: ProgrammeDuMomentComponent;
  let fixture: ComponentFixture<ProgrammeDuMomentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProgrammeDuMomentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProgrammeDuMomentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
