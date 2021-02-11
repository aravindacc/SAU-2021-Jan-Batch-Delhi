import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DailyWeeklyDepositComponent } from './daily-weekly-deposit.component';

describe('DailyWeeklyDepositComponent', () => {
  let component: DailyWeeklyDepositComponent;
  let fixture: ComponentFixture<DailyWeeklyDepositComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DailyWeeklyDepositComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DailyWeeklyDepositComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
