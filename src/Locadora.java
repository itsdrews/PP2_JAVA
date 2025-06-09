import java.util.ArrayList;

public class Locadora {

    private ArrayList<Aluguel> alugueis = new ArrayList<>();


    public Locadora() {}

    public Locadora(ArrayList<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }

    public ArrayList<Aluguel> getAlugueis() {
        return this.alugueis;
    }

    public void addAluguel(Aluguel aluguel) {
        for(Aluguel a: getAlugueis()) {
            if(aluguel.getId().equals(a.getId())) {
                System.out.println("Aluguel já cadastrado!");
                return;
            }

        }
        alugueis.add(aluguel);

    }
    public void removeAluguel(Aluguel aluguel) {
        for(Aluguel a: getAlugueis()) {
            if(aluguel.getId().equals(a.getId())) {
                this.alugueis.remove(aluguel);
                return;
            }
        }
        System.out.println("Aluguel(I)D não encontrado");

    }
    public void printAlugueis() {
        if(getAlugueis().isEmpty()|| getAlugueis()==null) {
            System.out.println("Nenhum aluguel encontrado.");
            return;
        }
        for(Aluguel aluguel : getAlugueis()) {
            System.out.println(aluguel.getId());
        }
    }


}
