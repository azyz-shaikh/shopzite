import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoadproductComponent } from './loadproduct.component';

describe('LoadproductComponent', () => {
  let component: LoadproductComponent;
  let fixture: ComponentFixture<LoadproductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoadproductComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoadproductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
