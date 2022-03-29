package domain;

public class ContaCorrente extends Conta{


    @Override
    public String imprimirExtrato() {
        return "=== Extrato da Conta Corrente ===" + super.infoExtratos()+ "++++++++++++";
    }


}
