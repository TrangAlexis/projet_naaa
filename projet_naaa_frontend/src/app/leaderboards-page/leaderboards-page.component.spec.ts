import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaderboardsPageComponent } from './leaderboards-page.component';

describe('LeaderboardsPageComponent', () => {
  let component: LeaderboardsPageComponent;
  let fixture: ComponentFixture<LeaderboardsPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LeaderboardsPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LeaderboardsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
