import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CardLancamentosComponent } from './card-lancamentos.component';

describe('CardLancamentosComponent', () => {
  let component: CardLancamentosComponent;
  let fixture: ComponentFixture<CardLancamentosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CardLancamentosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CardLancamentosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
