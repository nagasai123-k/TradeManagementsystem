import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TraderequestComponent } from './traderequest.component';

describe('TraderequestComponent', () => {
  let component: TraderequestComponent;
  let fixture: ComponentFixture<TraderequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TraderequestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TraderequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
