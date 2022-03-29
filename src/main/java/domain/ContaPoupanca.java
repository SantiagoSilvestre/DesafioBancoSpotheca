package domain;

public class ContaPoupanca extends Conta{

    @Override
    public String imprimirExtrato() {
        return "=== Extrato da Conta Poupanca ===" + super.infoExtratos() + "++++++++++++";
    }
}
