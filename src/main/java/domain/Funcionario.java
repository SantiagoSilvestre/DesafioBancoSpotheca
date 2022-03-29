package domain;

public class Funcionario extends Pessoa implements IFuncionario {

    private double salario;
    private final String funcao;

    public Funcionario(String nome, String cpf) {
        super(nome, cpf);
        this.salario = 0;
        this.funcao = "Staff";
        super.nome = nome;
        super.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    @Override
    public void depositarSalario(double valor) {
        this.setSalario(valor);
    }

    @Override
    public void exibirFicha() {
        String ficha = "=== Funcionario ===";
        ficha += "\n Nome: " + this.getNome();
        ficha += "\n CPF: " + this.getCpf();
        ficha += "\n Funcao: " + this.getFuncao();
        ficha += "\n Salario atual: " + this.getSalario();

        System.out.println(ficha);
    }
}
