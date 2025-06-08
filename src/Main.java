import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {

        // Instanciando carro e testando exceções

        // Testando a validação de modelo e marca segundo ENUM;
        Carro carro1 = new Carro();
        carro1.setModelo("X1");
        carro1.setModelo("DOLPHIN");
        carro1.setMarca("APPLE");
        carro1.setMarca("BYD");

        // Setando Cor e Placa;
        carro1.setCor("PRETO");
        carro1.setPlaca("TAD6E00");

        // Criando Cliente e validando dados.
        // Cliente herda de pessoa todos os atributos com e exceção de CNH;
        Cliente cliente1 = new Cliente();
        // Nome
        cliente1.setNome("Jorginho Frello");
        // CPF
        cliente1.setCPF("000.000.000-00");
        cliente1.setCPF("781.459.532-00");
        // Telefone
        cliente1.setTelefone("0");
        cliente1.setTelefone("92994177001");
        // Idade
        cliente1.setIdade(2);
        cliente1.setIdade(20);
        // Endereço
        cliente1.setEndereco("");
        cliente1.setEndereco("Av. Darcy Vargas,1200");
        // Email
        cliente1.setEmail("jorginho.frello.com");
        cliente1.setEmail("jorginho.frello@email.com");
        // CNH
        cliente1.setCNH("000000000");
        cliente1.setCNH("07700897575");


    }


}
