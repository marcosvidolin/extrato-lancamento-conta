import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExtratoLancamentosComponent } from './extrato-lancamentos.component';

describe('ExtratoLancamentosComponent', () => {
  let component: ExtratoLancamentosComponent;
  let fixture: ComponentFixture<ExtratoLancamentosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExtratoLancamentosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExtratoLancamentosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
