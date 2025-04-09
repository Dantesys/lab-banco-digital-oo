public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
        System.out.printf("Saque de R$%.2f realizada com sucesso\n", valor);
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.printf("Deposito de R$%.2f realizada com sucesso\n", valor);
    }

    @Override
    public void transferir(double valor, IConta contaDestino,TipoTransferencia tipo) {
        if(tipo.temLimite()){
            if(valor<=tipo.getLimite()){
                this.sacar(valor);
                contaDestino.depositar(valor);
                System.out.printf("Transferencia de R$%.2f realizada com sucesso\n", valor);
            }else{
                System.out.printf("Erro ao transferir: R$%.2f\n", valor);
                System.out.printf("Limite para transferencia tipo %s é de R$ %.2f\n",tipo.getTipo(),tipo.getLimite());
            }
        }else{
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.printf("Transferencia de R$%.2f realizada com sucesso\n", valor);
        }
    }
    public int getAgencia() {
        return agencia;
    }
    public int getNumero() {
        return numero;
    }
    public double getSaldo() {
        return saldo;
    }
    protected void imprimirInfosComuns() {
        System.out.printf("Titular: %s\n", this.cliente.getNome());
        System.out.printf("Agencia: %d\n", this.agencia);
        System.out.printf("Numero: %d\n", this.numero);
        System.out.printf("Saldo: %.2f\n", this.saldo);
    }
}
