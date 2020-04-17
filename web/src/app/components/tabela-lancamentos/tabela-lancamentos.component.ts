import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-tabela-lancamentos',
  templateUrl: './tabela-lancamentos.component.html',
  styleUrls: ['./tabela-lancamentos.component.css']
})
export class TabelaLancamentosComponent implements OnInit {

  @Input() lancamentos: any; //LancamentoEmConta;

  constructor() { }

  ngOnInit(): void {
  }

}
