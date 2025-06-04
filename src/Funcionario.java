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

    public void setCargo(String cargo) {
        try{
            Cargos atual  = Cargos.valueOf(cargo.toUpperCase().trim());

        }
        this.cargo = cargo;
    }
    public double getBonus() {
        return this.bonus;
    }
    public void setBonus() {
        if(this.cargo == 'GERENTE'){
            this.bonus = 15;
        }
        else{
            this.bonus = 10;
        }
    }
    @Override
    public String getInfo(){
        return "Nome: " + getNome() + "\nIdade: " + getIdade() + "\nCPF: " + getCpf() +"\nCargo: "

    }
}
