import { BrowserModule } from '@angular/platform-browser';
import { NgModule, LOCALE_ID } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { registerLocaleData } from '@angular/common';
import localePt from '@angular/common/locales/pt';

import { ExtratoLancamentoEmContaService } from './services/extratoLancamentoEmConta.service';

import { AppComponent } from './app.component';
import { TabelaLancamentosComponent } from './components/tabela-lancamentos/tabela-lancamentos.component';
import { CardLancamentosComponent } from './components/card-lancamentos/card-lancamentos.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ExtratoLancamentosComponent } from './components/extrato-lancamentos/extrato-lancamentos.component';

registerLocaleData(localePt);

@NgModule({
  declarations: [
    AppComponent,
    TabelaLancamentosComponent,
    CardLancamentosComponent,
    NavbarComponent,
    ExtratoLancamentosComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [
    {provide: LOCALE_ID, useValue: 'pt-BR'},
    ExtratoLancamentoEmContaService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
