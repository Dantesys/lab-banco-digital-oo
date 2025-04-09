import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Conta> getContas() {
        return contas;
    }
    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
    public Conta abrirConta(String nomeCliente,TipoConta tipoConta){
        Cliente cliente = new Cliente();
        cliente.setNome(nomeCliente);
        Conta conta;
        if(tipoConta==TipoConta.CC){
            conta = new ContaCorrente(cliente);
        }else{
            conta = new ContaPoupanca(cliente);
        }
        List<Conta> contas = new ArrayList<>();
        if(this.contas!=null){
            contas = this.contas;
        }
        contas.add(conta);
        setContas(contas);
        System.out.println("Conta criada com sucesso!");
        System.out.printf("== Bem-vindo ao %s ==\n",this.getNome());
        return conta;
    }
}
