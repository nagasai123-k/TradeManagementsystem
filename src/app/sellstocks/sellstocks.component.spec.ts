import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SellstocksComponent } from './sellstocks.component';

describe('SellstocksComponent', () => {
  let component: SellstocksComponent;
  let fixture: ComponentFixture<SellstocksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SellstocksComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SellstocksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
