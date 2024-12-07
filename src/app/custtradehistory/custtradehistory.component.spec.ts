import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CusttradehistoryComponent } from './custtradehistory.component';

describe('CusttradehistoryComponent', () => {
  let component: CusttradehistoryComponent;
  let fixture: ComponentFixture<CusttradehistoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CusttradehistoryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CusttradehistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
