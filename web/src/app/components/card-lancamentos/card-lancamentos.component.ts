import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-card-lancamentos',
  templateUrl: './card-lancamentos.component.html',
  styleUrls: ['./card-lancamentos.component.css']
})
export class CardLancamentosComponent implements OnInit {

  @Input() lancamentos: any;

  constructor() { }

  ngOnInit(): void {
  }

}
