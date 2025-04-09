public enum TipoConta {
    CC("cc"),
    POUPANCA("pp");

    private final String tipo;
    TipoConta(String tipo) {
        this.tipo = tipo;
    }
    public String getTipo() {
        return tipo;
    }
}
