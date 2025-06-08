public class Funcionario extends Pessoa{

    private int matricula;
    private String cargo;
    private double bonus;


    public Funcionario(){}

    public Funcionario(String nome, int idade, String cpf,
                       String endereco,
                       String telefone, String email,int matricula, String cargo, double bonus){
        super(nome, idade, cpf, endereco, telefone, email);
        this.matricula = matricula;
        this.cargo = cargo;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String nomeCargo) {
       if(validarCargo(nomeCargo)){
           this.cargo = nomeCargo;
           System.out.println("Cargo atualizado com sucesso!");
       }
       else{
           System.out.println("Erro ao atualizar cargo!");
       }
    }
    private static boolean validarCargo(String nomeCargo) {
        try {
            Cargos cargo = Cargos.valueOf(nomeCargo.toUpperCase());
            return true;
        }catch(IllegalArgumentException e) {
            return false;
        }
    }
    public double getBonus() {
        return this.bonus;
    }
    public void setBonus() {
        if(this.cargo.equalsIgnoreCase("GERENTE")){
            this.bonus = 15;
        }
        else{
            this.bonus = 10;
        }
    }
    @Override
    public String getInfo(){
        return "Nome: " + getNome() + "\nIdade: " + getIdade() + "\nCPF: " + getCPF() + "\nCargo: " + getCargo();

    }
}
