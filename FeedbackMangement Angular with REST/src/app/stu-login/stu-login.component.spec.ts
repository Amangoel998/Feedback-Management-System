import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StuLoginComponent } from './stu-login.component';

describe('StuLoginComponent', () => {
  let component: StuLoginComponent;
  let fixture: ComponentFixture<StuLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StuLoginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StuLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
