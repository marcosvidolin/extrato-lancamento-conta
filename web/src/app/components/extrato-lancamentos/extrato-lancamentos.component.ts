import { Component, OnInit } from '@angular/core';

import { LancamentoEmConta } from '../../models/lancamentoEmConta.model';
import { ExtratoLancamentoEmContaService } from '../../services/extratoLancamentoEmConta.service';

@Component({
  selector: 'app-extrato-lancamentos',
  templateUrl: './extrato-lancamentos.component.html',
  styleUrls: ['./extrato-lancamentos.component.css']
})
export class ExtratoLancamentosComponent implements OnInit {

  lancamentos: LancamentoEmConta[];

  constructor(private extratoLancamentoEmContaService: ExtratoLancamentoEmContaService) {}

  ngOnInit() {
    this.extratoLancamentoEmContaService.getLancamentos()
    .subscribe(data => {
      this.lancamentos = data;
    }, error => {
      alert('Ocorreu um erro. Tente novamente!');
   });

  }
}
