import { Banco } from './banco.model';

export interface LancamentoEmConta {
    numeroRemessa: any;
    situacao: string;
    descricao: string;
    dataLancamento: string;
    dataConfirmacao: string;
    banco: Banco;
    valor: number;
}
