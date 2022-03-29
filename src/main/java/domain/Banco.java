package domain;

import javax.swing.*;
import java.util.ArrayList;

public class Banco implements IBanco {

    final String menuPosListagem = "\n Escolha uma opção " +
            "\n 7 - Menu inicial" +
            "\n 6 - Sair";
    final String msgVeriqueTerminal = "Verifique o terminal para visualizar listagem ";

    final String opcoesFuncionario = "\n Escolha uma opção " +
            "\n 7 - Menu inicial" +
            "\n 8 - Cadastrar novo cliente" +
            "\n 9 - Minha ficha" +
            "\n 6 - Sair";
    final String opcoesClientes = "\n Escolha uma opção " +
            "\n 7 - Menu inicial" +
            "\n 10 - Abrir conta" +
            "\n 11 - Minhas contas abertas" +
            "\n 6 - Sair";

    private final String nome;

    private final String msgInicial;

    private ArrayList<Cliente> clientes = new ArrayList<>();

    private ArrayList<Funcionario> funcionarios;

    private final ArrayList<Conta> contas = new ArrayList<>();

    public Banco(String nome) {
        this.nome = nome;
        this.msgInicial = "Bem vindo ao banco" + this.getNome() +
                "\n Escolha uma das opções para continuar" +
                "\n 1 - Listar todos os Clientes" +
                "\n 2 - Listar todos os Funcionários" +
                "\n 3 - Listar todas as Contas" +
                "\n 4 - Opções para funcionários do Banco" +
                "\n 5 - Opções para clientes" +
                "\n 6 - Sair ";
        Funcionario funcionario = new Funcionario("Funcionario 1", "111.111.111-11");
        funcionario.setSalario(2400);
        if (funcionarios == null) funcionarios = new ArrayList<>();
        funcionarios.add(funcionario);
    }

    public String getNome() {
        return nome;
    }

    public String getMsgInicial() {
        return msgInicial;
    }


    @Override
    public void listarClientes() {
        StringBuilder clientesListados = new StringBuilder();
        if (clientes != null && !clientes.isEmpty()) {
            for (Cliente c : this.clientes) {
                clientesListados.append("\n === Cliente ===");
                clientesListados.append("\n Nome: ").append(c.getNome());
                clientesListados.append("\n CPF: ").append(c.getCpf());
            }
        } else {
            clientesListados = new StringBuilder("Nenhum cliente cadastrado!");
        }
        System.out.println(clientesListados);
    }

    @Override
    public void listarFuncionarios() {
        StringBuilder funcionariosListados = new StringBuilder();
        if (clientes != null && !clientes.isEmpty()) {
            for (Funcionario f : this.funcionarios) {
                funcionariosListados.append("\n === Funcionário ===");
                funcionariosListados.append("\n Nome: ").append(f.getNome());
                funcionariosListados.append("\n CPF: ").append(f.getCpf());
                funcionariosListados.append("\n Funcao: ").append(f.getFuncao());
                funcionariosListados.append("\n Salario %.2f: ").append(f.getSalario());
            }
        } else {
            funcionariosListados = new StringBuilder("Nenhum funcionário cadastrado!");
        }
        System.out.println(funcionariosListados);
    }

    @Override
    public void listarContas() {
        StringBuilder contasListadas = new StringBuilder();
        if (!contas.isEmpty()) {
            for (Conta c : this.contas) {
                contasListadas.append("\n === Contas ===");
                contasListadas.append("\n Agencia: ").append(c.getAgencia());
                contasListadas.append("\n Numero: ").append(c.getNumero());
            }
        } else {
            contasListadas = new StringBuilder("Nenhuma conta cadastrada!");
        }
        System.out.println(contasListadas);
    }

    @Override
    public void controleOpcoes(String opcoes) {

        String opcaoSelecionada;

        switch (opcoes) {
            case "1":
                this.listarClientes();
                opcaoSelecionada = JOptionPane.showInputDialog(msgVeriqueTerminal +
                        menuPosListagem);
                controleOpcoes(opcaoSelecionada);
                break;
            case "2":
                this.listarFuncionarios();
                opcaoSelecionada = JOptionPane.showInputDialog(msgVeriqueTerminal +
                        menuPosListagem);
                controleOpcoes(opcaoSelecionada);
                break;
            case "3":
                this.listarContas();
                opcaoSelecionada = JOptionPane.showInputDialog(msgVeriqueTerminal +
                        menuPosListagem);
                controleOpcoes(opcaoSelecionada);
                break;
            case "4":
                opcaoSelecionada = JOptionPane.showInputDialog(opcoesFuncionario);
                controleOpcoes(opcaoSelecionada);
                break;
            case "5":
                controleClientes();
                break;
            case "6":
                break;
            case "7":
                showMenu(this.getMsgInicial());
                break;
            case "8":
                cadastrarNovoCliente();
                break;
            case "9":
                fichaFuncionario();
                break;
            case "10":
                abrirConta();
                break;
            case "11":
                listaContasPorCliente();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Escolha uma opção válida");
                break;
        }
    }

    private void controleClientes() {
        String opcaoSelecionada = JOptionPane.showInputDialog(opcoesClientes);
        controleOpcoes(opcaoSelecionada);
    }

    @Override
    public void showMenu(String msgInicial) {
        String opcaoSelecionada = JOptionPane.showInputDialog(this.msgInicial).trim();
        this.controleOpcoes(opcaoSelecionada);
    }

    public void cadastrarNovoCliente() {
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do cliente");
        String cpf = JOptionPane.showInputDialog(null, "Digite o CPF do cliente");

        Cliente cliente = new Cliente(nome.trim(), cpf.trim());
        if (clientes == null) clientes = new ArrayList<>();
        clientes.add(cliente);
        String opcaoSelecionada = JOptionPane.showInputDialog("Cliente cadastrado" +
                opcoesFuncionario);
        controleOpcoes(opcaoSelecionada);

    }

    public void abrirConta() {
        String cpf = JOptionPane.showInputDialog(null, "Se identifique com o seu documento(CPF):");
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                cliente = c;
            }
        }

        if (cliente == null) {
            String opcaoSelecionada = JOptionPane.showInputDialog("Cliente não encontrado selecione uma nova opção" +
                    opcoesClientes);
            controleOpcoes(opcaoSelecionada);
        } else {
            clientes.remove(cliente);
            ContaCorrente cc = new ContaCorrente();
            cliente.abrirConta(cc);
            clientes.add(cliente);
            String opcaoSelecionada = JOptionPane.showInputDialog("Conta Adicionada com sucesso" +
                    opcoesClientes);
            controleOpcoes(opcaoSelecionada);
        }

    }

    public void listaContasPorCliente() {
        String cpf = JOptionPane.showInputDialog(null, "Se identifique com o seu documento(CPF):");
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                cliente = c;
            }
        }

        if (cliente == null) {
            String opcaoSelecionada = JOptionPane.showInputDialog("Cliente não encontrado selecione uma nova opção" +
                    opcoesClientes);
            controleOpcoes(opcaoSelecionada);
        } else {

            cliente.exibirContas();

            String opcaoSelecionada = JOptionPane.showInputDialog(msgVeriqueTerminal +
                    opcoesClientes);
            controleOpcoes(opcaoSelecionada);
        }
    }

    public void fichaFuncionario() {
        funcionarios.get(0).exibirFicha();
        String opcaoSelecionada = JOptionPane.showInputDialog(msgVeriqueTerminal +
                opcoesFuncionario);
        controleOpcoes(opcaoSelecionada);
    }
}
