import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Route1SeedetailsComponent } from './route1-seedetails.component';

describe('Route1SeedetailsComponent', () => {
  let component: Route1SeedetailsComponent;
  let fixture: ComponentFixture<Route1SeedetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Route1SeedetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Route1SeedetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
