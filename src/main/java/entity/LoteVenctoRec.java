package entity;

public record LoteVenctoRec(int codfil,
                            int coditprod,
                            String lote,
                            String dtVencto,
                            double qtd,
                            Double reserva,
                            int status,
                            double bloqueado,
                            String tonalidade,
                            int ordem,
                            String selecionado,
                            double qtdComprada) {
    public LoteVenctoRec() {
        this(0, 0, "", "", 0.0, null, 0, 0.0, "", 0, "", 0.0);
    }
}
