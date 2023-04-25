import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgrammeEditorComponent } from './programme-editor.component';

describe('ProgrammeEditorComponent', () => {
  let component: ProgrammeEditorComponent;
  let fixture: ComponentFixture<ProgrammeEditorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProgrammeEditorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProgrammeEditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
