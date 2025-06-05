public abstract class Cliente extends Pessoa implements Notificacao{
    private String cnh;

    public Cliente(){}

    public Cliente(String nome,int idade, String cpf,
                   String endereco,String telefone,String email,
                   String cnh) {
        super(nome,idade,cpf,endereco,telefone,email);
        this.cnh = cnh;

    }
    public String getCnh() {
        return this.cnh;
    }
    public void setCNH(String cnh) {
       try{
           if(!validarCNH(cnh)){
               throw new IllegalArgumentException("CNH deve conter 11 dígitos numéricos");
           }
           else{
               this.cnh = cnh;
               System.out.println("CNH atualizado com sucesso");
           }

       }catch(IllegalArgumentException e){
           System.out.println("Erro: "+ e.getMessage());
        }
    }

    // #todo ALTERAR VALIDAÇÂO DE CNH PARA FORMA SIMPLES.
    public boolean validarCNH(String cnh) {
        if (!cnh.matches("^\\d{11}$")) return false;
        if (cnh.chars().distinct().count() == 1) return false;

        long v = 0; int j = 9;
        for (int i = 0; i < 9; i++, j--){
            v += (cnh.charAt(i) - '0') * j;
        }
        long vl1 = v % 11;
        long dsc = (vl1 >= 10) ? 2 : 0;
        if (vl1 >= 10) vl1 = 0;

        v = 0; j = 1;
        for (int i = 0; i < 9; i++, j++){
            v += (cnh.charAt(i) - '0') * j;
        }
        long x = v % 11;
        long vl2 = (x >= 10) ? 0 : x - dsc;

        return cnh.endsWith("" + vl1 + vl2);
    }
    @Override
    public void notificar(String mensagem){
        System.out.println("Notificação para "+ getNome()+ "CNH: " + getCnh()+ "\n"+mensagem);

    }


}
