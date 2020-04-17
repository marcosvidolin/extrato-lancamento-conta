import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { LancamentoEmConta } from '../models/lancamentoEmConta.model';

@Injectable()
export class ExtratoLancamentoEmContaService {

  constructor(private http: HttpClient) { }

  getLancamentos(): Observable<LancamentoEmConta[]> {
    return this.http.get<LancamentoEmConta[]>('http://localhost:9000/api/lancamentos?page=1&items=20');
  }
}
