
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Aluguel implements Revisao {

    private Cliente cliente;
    private Funcionario funcionario;
    private Carro carro;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private long dias;
    private double bonusSalarial = 0;
    private String id;

    public Aluguel(){}

    public Aluguel(Cliente cliente,Carro carro,
                   Funcionario funcionario, LocalDate dataInicio, LocalDate dataFim) {
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.carro = carro;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        setId();
        iniciarAluguel();



    }
    public void setId(){
        this.id = getCliente().getNome().substring(0,3) + String.valueOf((int)(Math.random() * 100) + 1) + getFuncionario().getNome().substring(0,3);

    }
    public String getId() {
        return this.id;
    }
    public void iniciarAluguel(){
        this.dias = ChronoUnit.DAYS.between(getDataInicio(),getDataFim());
        if (carro.isDisponivel()&& revisaoCompleta()){
        carro.alugar();
        cliente.notificar("Carro: " + this.carro.getModelo()
                + " | Placa: " + this.carro.getPlaca()
                + " alugado com sucesso!!"
                + "\nData de início: " + getDataInicio()
                + "\nData de fim: " + getDataFim()
                + "\nFuncionário responsável: " + this.funcionario.getNome()
                + "\nValor Total: R$ " + (this.dias * this.carro.getValorDiaria()) + " para " + this.dias + " dias"
                + "\nIdentificador: " +getId());
    }else{
        System.out.println("Erro ao estabelecer aluguel:\nCarro "+this.carro.getModelo() + " placa "+ this.carro.getPlaca() + " indisponivel!");
    }
    }

    public long getDias(){
        return this.dias;
    }

    public double getBonusSalarial(){
        return this.bonusSalarial;
    }
    public void setBonusSalarial(){
        this.bonusSalarial = getFuncionario().getSalario() + getFuncionario().getBonus()*getCarro().getValorDiaria()*getDias()/100;
    }

    public void encerrarAluguel(){
        this.carro.devolver();
        this.cliente.notificar("Devolução conclída para o carro: "+this.carro.getModelo()+ " Placa: " + this.carro.getPlaca()+ " Cliente: " + this.cliente.getNome());
        this.carro=null;
        this.cliente=null;
        this.dias = 0;
        this.bonusSalarial = 0;
        this.dataInicio = null;
        this.dataFim = null;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    public Carro getCarro() {return this.carro;}

    public void setCarro(Carro carro) {
        try {
            if (!(carro instanceof Carro)) {
                throw new NullPointerException("Cliente é nulo!");
            }else{
                this.carro = carro;
            }
        }catch (NullPointerException e){
            System.out.println("Erro: "+e.getMessage());
        }
    }
    public void setCliente(Cliente cli){
        try {
            if (!(cli instanceof Cliente)) {
                throw new NullPointerException("Cliente é nulo!");
            }else{
                this.cliente = cli;
            }
        }catch (NullPointerException e){
            System.out.println("Erro: "+e.getMessage());
        }
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    public void setFuncionario(Funcionario func){
        try {
            if (!(func instanceof Funcionario)) {
                throw new NullPointerException("Cliente é nulo!");
            }else{
                this.funcionario= func;
            }
        }catch (NullPointerException e){
            System.out.println("Erro: "+e.getMessage());
        }
    }

    public LocalDate getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(LocalDate d){
        try{
            if(!(d instanceof LocalDate)){
                throw new NullPointerException("Data de inicio nulo!");
            }else{
                this.dataInicio = d;
            }
        }catch(NullPointerException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public LocalDate getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(LocalDate d){

        try{
            if(d.isBefore(this.dataInicio)){
                throw new IllegalArgumentException("Data " +dataFim +" de fim invalido!");
            }else{
                this.dataFim = d;
            }
        }catch (IllegalArgumentException e ){
            System.out.println("Erro: "+e.getMessage());
        }
    }

    public boolean revisaoCompleta(){
        if(verificarCombustivel()&&verificarAvarias()&&verificarMotor()){
            return true;
        }else {
            return false;
        }
    }

    public boolean verificarMotor(){
        if(carro.isMotorOk()){
            return true;
        }else {
            return false;
        }
    }
    public boolean verificarCombustivel(){
        if(carro.getCombustivel()!=100){
            return false;
        }else{
            return true;
        }
    }
    public boolean verificarAvarias(){
        if(carro.getAvarias()!=null){
            return false;
        }else{
            return true;
        }
    }
    }
