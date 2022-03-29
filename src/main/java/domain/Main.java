package domain;

public class Main {


    public static void main(String[] args) {

        Banco banco = new Banco("SSSLT");

        banco.showMenu(banco.getMsgInicial());

    }
}
