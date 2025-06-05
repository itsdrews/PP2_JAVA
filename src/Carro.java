public class Carro {
    private String modelo;
    private String marca;
    private String cor;
    private String placa;
    private boolean disponibilidade = true;


    public Carro(String modelo, String marca, String cor, String placa) {
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.placa = placa;


    }
        public boolean isDisponivel(){
            return this.disponibilidade;
        }
        public String getModelo() {
            return this.modelo;
        }
        public void setModelo(String modelo) {
            for(MarcasDeCarro marca: MarcasDeCarro.values()){
                if(marca.validarModelo(modelo)){
                    this.modelo = modelo;
                }
            }

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
            try{
                if(!validarMarca(marca)){
                    throw new IllegalArgumentException("Marca não existe!");
                }
                else{
                    this.marca = marca;
                }
            }catch(IllegalArgumentException e){
                System.out.println("Erro: "+e.getMessage());
            }
        }
        private static boolean validarMarca(String nomeMarca){
            for(MarcasDeCarro m: MarcasDeCarro.values()){
                if (m.name().equals(nomeMarca)){
                    return true;
                }
            }
            return false;
        }

        public void alugar(){
            this.disponibilidade = false;
        }
        public void devolver(){
            this.disponibilidade = true;
        }
}
