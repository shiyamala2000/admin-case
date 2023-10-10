import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CaseMangementViewComponent } from './case-mangement-view.component';

describe('CaseMangementViewComponent', () => {
  let component: CaseMangementViewComponent;
  let fixture: ComponentFixture<CaseMangementViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CaseMangementViewComponent]
    });
    fixture = TestBed.createComponent(CaseMangementViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
