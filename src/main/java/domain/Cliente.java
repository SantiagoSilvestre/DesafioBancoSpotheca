package domain;

import java.util.ArrayList;

public class Cliente extends Pessoa implements ICliente {

    private final ArrayList<Conta> contasAbertas = new ArrayList<>();

    public Cliente(String nome, String cpf) {
        super(nome, cpf);
    }

    @Override
    public void abrirConta(Conta conta) {
        this.contasAbertas.add(conta);
    }

    @Override
    public void exibirContas() {
        if (contasAbertas.isEmpty()) {
            System.out.println("Nenhuma conta aberta para exibir!");

        } else {
            StringBuilder contasImpressas = new StringBuilder();
            for (Conta conta : contasAbertas) {
                contasImpressas.append(conta.imprimirExtrato());
            }
            System.out.println(contasImpressas);
        }
    }

    @Override
    public void fecharConta(Conta conta) {
        this.contasAbertas.remove(conta);
    }
}
