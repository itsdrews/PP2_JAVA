import java.time.LocalDate;
public class Main {

    public static void main(String[] args) {

        // Instanciando carro e testando exceções

        // Testando a validação de modelo e marca segundo ENUM;
        System.out.println("Instanciando carro e validando campos: ");
        Carro carro1 = new Carro();
        carro1.setModelo("X1"); // Erro
        carro1.setModelo("DOLPHIN");
        carro1.setMarca("APPLE"); // Erro
        carro1.setMarca("BYD");
        // Setando Cor, Placa e Valor da Diária;
        carro1.setCor("PRETO");
        carro1.setPlaca("TAD6E00");
        carro1.setValorDiaria(280);
        System.out.println("----------------------------------------------------------------------------------");



        // Instanciando Cliente e validando dados
        // Cliente herda de pessoa todos os atributos e métodos com e exceção de CNH;
        System.out.println("Cliente: ");
        Cliente cliente1 = new Cliente();
        // Setando Nome
        cliente1.setNome("Jorginho Frello");
        // Setando CPF
        cliente1.setCPF("000.000.000-00"); // Erro
        cliente1.setCPF("781.459.532-00");
        // Setando Telefone
        cliente1.setTelefone("0"); // Erro
        cliente1.setTelefone("92994177001");
        // Setando Idade
        cliente1.setIdade(2); // Erro
        cliente1.setIdade(20);
        // Setando Endereço
        cliente1.setEndereco(""); // Erro
        cliente1.setEndereco("Av. Darcy Vargas,1200");
        // Setando Email
        cliente1.setEmail("jorginho.frello.com"); // Erro
        cliente1.setEmail("jorginho.frello@email.com");
        // Setando CNH
        cliente1.setCNH("000000000"); // Erro
        cliente1.setCNH("07700897575");
        System.out.println("----------------------------------------------------------------------------------");


        // Intanciando Funcionario que herda de pessoa todos os atributos e métodos de Pessoa
        System.out.println("Funcionario: ");
        Funcionario funcionario1 = new Funcionario();
        // Setando nome
        funcionario1.setNome("Giorgian de Arrascaeta Bennedetti");
        // Setando matricula de Funcionario
        funcionario1.setMatricula(-1); // Erro
        funcionario1.setMatricula(10);
        // Setando Cargo
        funcionario1.setCargo("ATENDENTE"); // Erro
        funcionario1.setCargo("GERENTE");
        // Setando Bonus (Automático ligado ao cargo)
        funcionario1.setBonus();
        funcionario1.setSalario(3500);
        System.out.println("Bônus: "+ funcionario1.getBonus()+ "%");
        System.out.println("----------------------------------------------------------------------------------");


        // Aluguel classe associativa entre Cliente, Carro e Funcionario // Erro
        System.out.println("Aluguel: ");
        Aluguel aluguel = new Aluguel(cliente1,carro1,funcionario1,
                LocalDate.of(2025,6,8),
                LocalDate.of(2025,12,12));

        // Ajustando atributos de Carro para ficar disponível e a revisão ser aprovada
        carro1.addCombustivel(100);
        System.out.println("Aluguel: ");
        Aluguel aluguel2 = new Aluguel(cliente1,carro1,funcionario1,
                LocalDate.of(2025,6,8),
                LocalDate.of(2025,12,12));
        aluguel2.setBonusSalarial(); // Bônus para o trabalhador
        System.out.println("Salário com bônus de 0.5% para "+ aluguel2.getFuncionario().getNome() + " : R$ " + aluguel2.getBonusSalarial());

        // Encerrando aluguel
        aluguel2.encerrarAluguel();




    }


}
