import java.util.Date;
public class Aluguel {

    private Cliente cliente;
    private Funcionario funcionario;
    private Carro carro;
    private Date dataInicio;
    private Date dataFim;

    public Aluguel(){}

    public Aluguel(Cliente cliente,Carro carro,
                   Funcionario funcionario, Date datainicio, Date datafim) {
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        if (carro.isDisponivel()){
            this.carro = carro;
            carro.alugar();
            cliente.notificar("Carro: "+ carro.getModelo() + " Placa: " + carro.getPlaca() + " alugado com sucesso!!"
        +"\nData de inicio: "+ getDataInicio() + "\nData de fim: "+ getDataFim() + "\nFuncionario responsável: "+ funcionario.getNome());
        }else{
            System.out.println("Carro "+carro.getModelo() + " placa "+ carro.getPlaca() + "indisponivel!");
        }


    }
    public void encerrarAluguel(){
        carro.devolver();
        cliente.notificar("Devolução conclída para o carro: "+carro.getModelo()+ " Placa: " + carro.getPlaca());
    }
    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cli){
        this.cliente = cli;
    }
    public Funcionario getFuncionario() {
        return this.funcionario;
    }
    public void setFuncionario(Funcionario func){
        this.funcionario = func;
    }
    public Date getDataInicio() {
        return this.dataInicio;
    }
    public void setDataInicio(Date d){
        this.dataInicio = d;
    }
    public Date getDataFim() {
        return this.dataFim;
    }
    public void setDataFim(Date d){
        this.dataFim = d;
    }
    }
