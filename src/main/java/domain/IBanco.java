package domain;

public interface IBanco {

    void listarClientes();

    void listarFuncionarios();

    void listarContas();

    void controleOpcoes(String opcoes);

    void showMenu(String msgInicial);
}
