import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FakeUserReportComponent } from './fakeReport.component';

describe('FakeUserReportComponent', () => {
  let component: FakeUserReportComponent;
  let fixture: ComponentFixture<FakeUserReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FakeUserReportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FakeUserReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
