public abstract class Pessoa {

    protected String nome;
    protected int idade;
    protected String cpf;
    protected String rg;
    protected String telefone;
    protected String email;
    protected String endereco;

    public Pessoa() {

    }
    public Pessoa(String nome, int idade, String cpf,
                  String endereco,
                  String telefone, String email) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;

    }
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        try{
            if(!validarNome(nome)) {
                throw new IllegalArgumentException("Nome não pode ser vazio" );
            }
            else{
                this.nome = nome;
                System.out.println("Nome: " + nome+ " setado com sucesso!");
            }
        }catch(IllegalArgumentException e){
            System.out.println("Erro: " + e.getMessage());

        }

    }
    private static boolean validarNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        try {
            if (!validaIdade(idade)) {
                throw new IllegalArgumentException("Idade mínima 18 anos e máxima 80 anos!");
            } else {
                this.idade = idade;
                System.out.println("Idade " + idade +" setado com sucesso!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public String getCPF() {
        return this.cpf;
    }

    public void setCPF(String cpf) {
        try{

        if(!validarCPF(cpf)){
            throw new IllegalArgumentException("CPF " + cpf+ " Inválido!!");
        }
        else{
            this.cpf = cpf;
            System.out.println("CPF " +cpf+ " setado com sucesso!");
        }
        }catch(IllegalArgumentException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        try{
            if(!validarEndereco(endereco)){
                throw new IllegalArgumentException("Endereço não pode ser vazio!");

            }else{
                this.endereco = endereco;
                System.out.println("Endereço "+ endereco +" setado com sucesso!");
            }
        }catch(IllegalArgumentException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static boolean validarEndereco(String endereco) {
        if (endereco != null && !endereco.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    public String getTelefone() {
        return this.telefone;
    }
    public void setTelefone(String telefone) {
        try{
            if (!validarTelefone(telefone)) {
                throw new IllegalArgumentException("Telefone " + telefone +" inválido!!");
            }
            else{
                this.telefone = telefone;
                System.out.println("Telefone "+ telefone +" setado com sucesso!");
            }

        }catch (IllegalArgumentException e){
            System.out.println("Erro: " + e.getMessage());
        }

    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        try{
            if (!validarEmail(email)) {
                throw new IllegalArgumentException("Email " +email +" inválido!!");
            }else{
                this.email = email;
                System.out.println("Email " + email +" setado com sucesso!");
            }
        }catch(IllegalArgumentException e){
            System.out.println("Erro: " + e.getMessage());
        }

    }
    private static boolean validarEmail(String email){

        if (email == null) return false;
        String regex = "^[\\w.-]+@[\\w-]+\\.[a-zA-Z]{2,}$";
        return email.matches(regex);

    }
    public static boolean validarTelefone(String telefone) {

        if (telefone == null) return false;
        String regex = "^\\(?\\d{2}\\)?\\s?9?\\d{4}-?\\d{4}$";
        return telefone.matches(regex);
    }
    private static boolean validaIdade(int idade){
        if(idade<=18 || idade>100){
            return false;
        }else{return true;}
    }
    // todo: Alterar validaçã do  CPF para modelo mais simples.
    private static boolean validarCPF(String cpf) {
        // Remove pontuação
        cpf = cpf.replaceAll("[^\\d]", "");

        // Verifica se tem 11 dígitos
        if (!cpf.matches("\\d{11}")) return false;

        // Verifica se todos os dígitos são iguais (ex: 00000000000)
        if (cpf.chars().distinct().count() == 1) return false;

        // Calcula o primeiro dígito verificador
        int soma1 = 0;
        for (int i = 0; i < 9; i++) {
            soma1 += (cpf.charAt(i) - '0') * (10 - i);
        }
        int digito1 = 11 - (soma1 % 11);
        if (digito1 >= 10) digito1 = 0;

        // Calcula o segundo dígito verificador
        int soma2 = 0;
        for (int i = 0; i < 10; i++) {
            soma2 += (cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma2 % 11);
        if (digito2 >= 10) digito2 = 0;

        // Verifica se os dígitos calculados batem com os informados
        return cpf.charAt(9) - '0' == digito1 && cpf.charAt(10) - '0' == digito2;
    }


    public abstract String getInfo();
}
