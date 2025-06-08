public class Carro {
    private String modelo;
    private String marca;
    private String cor;
    private String placa;
    private boolean disponibilidade = true;
    private double combustivel=0;
    private double valorDiaria;
    private String avarias;
    private boolean motorOk =true;

    public Carro() {
    }

    public Carro(String modelo, String marca, String cor, String placa) {
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.placa = placa;


    }

    public double getValorDiaria() {
        return this.valorDiaria;
    }
    public void setValorDiaria(double valorDiaria) {
        try{
            if(!validarValorDiaria(valorDiaria)){
                throw new IllegalArgumentException("Valor: "+ valorDiaria+ " de diária inválido!!");
            }
            else{
                this.valorDiaria = valorDiaria;
                System.out.println("Valor de diária: "+ valorDiaria + " setado com sucesso!");
            }
        }catch(IllegalArgumentException e){
            System.out.println("Erro: "+e.getMessage());
        }
    }
    private static boolean validarValorDiaria(double valorDiaria){
        if(valorDiaria<0||valorDiaria>430){
            return false;
        }
        return true;
    }
    public String getAvarias(){
        return this.avarias;
    }
    public void setAvarias(String avarias){
        this.avarias = avarias;
    }
    public double getCombustivel() {
        return this.combustivel;
    }

    public void addCombustivel(double combustivelExtra) {
        if (this.combustivel < 100) {
            this.combustivel += combustivelExtra;
        }
        if (this.combustivel >= 100) {
            this.combustivel = 100;
        }
    }

    public boolean isDisponivel() {
        return this.disponibilidade;
    }

    public String getModelo() {

        return this.modelo;
    }

    public void setModelo(String modelo) {
        try {
            if (validarModelo(modelo)) {
                this.modelo = modelo;
                System.out.println("Modelo: " + modelo + " setado com suceso!");
            } else {
                throw new IllegalArgumentException("Modelo " + modelo + " inválido!");
            }
            ;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }

    private boolean validarModelo(String modelo) {
        for (MarcasDeCarro marca : MarcasDeCarro.values()) {
            if (marca.validarModelo(modelo)) {
                this.modelo = modelo;
                return true;
            }
        }
        return false;

    }

    public String getMarca() {
        return this.marca;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        try {
            if (!validarMarca(marca)) {
                throw new IllegalArgumentException("Marca " + marca + " não existe!");
            } else {
                this.marca = marca;
                System.out.println("Marca: " + marca + " setado com suceso!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static boolean validarMarca(String nomeMarca) {
        for (MarcasDeCarro m : MarcasDeCarro.values()) {
            if (m.name().equals(nomeMarca)) {
                return true;
            }
        }
        return false;
    }

    public void alugar() {
        this.disponibilidade = false;
    }

    public void devolver() {
        this.disponibilidade = true;
    }

    public boolean isMotorOk() {
        return this.motorOk;
    }
    public void setMotorOk(boolean motorOk) {
        this.motorOk = motorOk;
    }

}

