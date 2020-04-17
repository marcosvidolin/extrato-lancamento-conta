import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TabelaLancamentosComponent } from './tabela-lancamentos.component';

describe('TabelaLancamentosComponent', () => {
  let component: TabelaLancamentosComponent;
  let fixture: ComponentFixture<TabelaLancamentosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TabelaLancamentosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TabelaLancamentosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
