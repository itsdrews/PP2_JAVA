public enum MarcasDeCarro {
    BYD(new String[]{"DOLPHIN","KING"}),
    CHEVROLET(new String[]{"TRAILBLAZER","TRACKER"}),
    VOLKSWAGEN(new String[]{"TIGUAN","TCROSS"}),
    FIAT(new String[]{"PULSE","TORO"});

    private final String[] modelos;

    MarcasDeCarro(String[] modelos) {
        this.modelos = modelos;
    }
    public boolean validarModelo(String modelo) {
        for (String m : modelos) {
            if(m.equalsIgnoreCase(modelo)){
                return true;
            }
        }
        return false;
    }
    public String[] getModelos() {
        return this.modelos;
    }

}
