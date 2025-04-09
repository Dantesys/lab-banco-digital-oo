public enum TipoTransferencia {
    PIX("pix",false,0),
    TED("ted",false,0),
    DOC("doc",true, 4999.99F);

    private final String tipo;
    private final boolean limitado;
    private final float limite;

    TipoTransferencia(String tipo, boolean limitado,float limite) {
        this.tipo = tipo;
        this.limite = limite;
        this.limitado = limitado;
    }
    public String getTipo() {
        return tipo;
    }
    public boolean temLimite() {
        return limitado;
    }
    public float getLimite() {
        return limite;
    }
}
