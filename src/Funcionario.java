public class Funcionario extends Pessoa{

    private int matricula;
    private String cargo;
    private double bonus;
    private double salario;


    public Funcionario(){}

    public Funcionario(String nome, int idade, String cpf,
                       String endereco,
                       String telefone, String email,int matricula, String cargo, double bonus){
        super(nome, idade, cpf, endereco, telefone, email);
        this.matricula = matricula;
        this.cargo = cargo;
    }
    public double getSalario() {
        return this.salario;
    }
    public void setSalario(double salario) {
        try{
            if(!validarSalario(salario)){
                throw new IllegalArgumentException("Salário: "+ salario + " inválido!");
            }
            else{
                this.salario = salario;
                System.out.println("Salário: "+ salario + " setado com sucesso!");
            }
        }catch(IllegalArgumentException e){
            System.out.println("Erro: "+ e.getMessage());
        }

    }
    private static boolean validarSalario(double salario){
        if(salario <= 0|| salario >20000){
            return false;
        }else{
            return true;
        }
    }
    public int getMatricula() {
        return this.matricula;
    }

    public void setMatricula(int matricula) {
        try{
            if(!validarMatricula( matricula )){
                throw new IllegalArgumentException("Matricula "+matricula +" inválida!");
            }else {
                this.matricula = matricula;
                System.out.println("Matricula: " + matricula + " setado com suceso!");
            }
        }catch (IllegalArgumentException e){
            System.out.println("Erro: "+e.getMessage());
        }

    }

    private static boolean validarMatricula(int matricula){
        if(matricula < 0 || matricula > 100) {
            return false;
        }else{
            return true;
        }
    }
    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String nomeCargo) {
       try{
           if(!validarCargo(nomeCargo)){
               throw new IllegalArgumentException("Cargo: "+ nomeCargo + " invalido!");
           }
           else {
               this.cargo = nomeCargo;
               System.out.println("Cargo: " + nomeCargo+ " setado com suceso!");
           }
       }catch(IllegalArgumentException e){
           System.out.println("Erro: "+e.getMessage());
       }
    }
    private static boolean validarCargo(String nomeCargo) {
       for(Cargos c : Cargos.values()){
           if(c.name().equalsIgnoreCase(nomeCargo)){
               return true;
           }
       }
       return false;
    }
    public double getBonus() {
        return this.bonus;
    }
    public void setBonus() {
        if(this.cargo.equalsIgnoreCase("GERENTE")){
            this.bonus = 0.5;
        }
        else{
            this.bonus = 0.25;
        }
    }
    @Override
    public String getInfo(){
        return "Nome: " + getNome() + "\nIdade: " + getIdade() + "\nCPF: " + getCPF() + "\nCargo: " + getCargo();

    }
}
