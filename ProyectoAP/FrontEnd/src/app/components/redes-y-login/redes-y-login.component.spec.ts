import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RedesYLoginComponent } from './redes-y-login.component';

describe('RedesYLoginComponent', () => {
  let component: RedesYLoginComponent;
  let fixture: ComponentFixture<RedesYLoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RedesYLoginComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RedesYLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
