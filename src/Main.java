public class Main {
    public static void main(String[] args) {
        Banco parelhense = new Banco();
        parelhense.setNome("ParelhensePay");
        Conta cc = parelhense.abrirConta("Diego",TipoConta.CC);
        Conta poupanca = parelhense.abrirConta("Diego",TipoConta.POUPANCA);

        for(Conta conta: parelhense.getContas()){
            System.out.printf("Conta: %d\n",conta.numero);
            System.out.printf("Cliente: %s\n",conta.cliente.getNome());
        }

        cc.depositar(100);
        cc.transferir(100, poupanca,TipoTransferencia.PIX);
        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
        cc.depositar(200);
        cc.transferir(150, poupanca,TipoTransferencia.TED);
        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
        cc.depositar(4950);
        cc.transferir(5000, poupanca,TipoTransferencia.DOC);
        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
        cc.transferir(4500, poupanca,TipoTransferencia.DOC);
        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}