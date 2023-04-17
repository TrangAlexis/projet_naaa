import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InscriptionCoachComponent } from './inscription-coach.component';

describe('InscriptionCoachComponent', () => {
  let component: InscriptionCoachComponent;
  let fixture: ComponentFixture<InscriptionCoachComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InscriptionCoachComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InscriptionCoachComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
