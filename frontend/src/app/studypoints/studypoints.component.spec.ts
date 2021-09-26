import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudypointsComponent } from './studypoints.component';

describe('StudypointsComponent', () => {
  let component: StudypointsComponent;
  let fixture: ComponentFixture<StudypointsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudypointsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudypointsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
