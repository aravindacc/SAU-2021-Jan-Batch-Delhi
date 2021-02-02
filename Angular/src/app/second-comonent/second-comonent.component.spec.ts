import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SecondComonentComponent } from './second-comonent.component';

describe('SecondComonentComponent', () => {
  let component: SecondComonentComponent;
  let fixture: ComponentFixture<SecondComonentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SecondComonentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SecondComonentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
