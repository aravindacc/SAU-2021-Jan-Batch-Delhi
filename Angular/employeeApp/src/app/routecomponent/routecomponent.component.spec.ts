import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RoutecomponentComponent } from './routecomponent.component';

describe('RoutecomponentComponent', () => {
  let component: RoutecomponentComponent;
  let fixture: ComponentFixture<RoutecomponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RoutecomponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RoutecomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
