package entity;


import util.funcoes;

public class LoteVencto {

    private int codfil;
    private long coditprod;
    private String lote;
    private String dtVencto;
    private double qtd;
    private Double reserva;
    private int status;
    private double bloqueado;
    private String tonalidade;
    private int ordem;
    private String selecionado = "N";
    private double qtdComprada = 0.0;
    private String dtFabricacao;



    public LoteVencto () {

    }


    public String toString() {
        String aux = "";
        aux =lote + " " + dtVencto + " " + qtd +" " + reserva +" " + status +" " + bloqueado +" " + tonalidade;
        return aux;
    }

    public int getCodfil() {
        return codfil;
    }




    public void setCodfil(int codfil) {
        this.codfil = codfil;
    }

    /**
     * @return the lote
     */
    public String getLote() {
        return lote;
    }




    /**
     * @param lote the lote to set
     */
    public void setLote(String lote) {
        this.lote = lote;
    }




    /**
     * @return the dtVencto
     */
    public String getDtVencto() {
        return dtVencto;
    }




    /**
     * @param dtVencto the dtVencto to set
     */
    public void setDtVencto(String dtVencto) {
        this.dtVencto = dtVencto;
    }




    /**
     * @return the qtd
     */
    public double getQtd() {
        return funcoes.Arredonda(qtd,2);
    }




    /**
     * @param qtd the qtd to set
     */
    public void setQtd(double qtd) {
        this.qtd = qtd;
    }




    /**
     * @return the reserva
     */
    public Double getReserva() {
        return reserva;
    }




    /**
     * @param reserva the reserva to set
     */
    public void setReserva(Double reserva) {
        this.reserva = reserva;
    }




    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }




    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }




    /**
     * @return the bloqueado
     */
    public double getBloqueado() {
        return bloqueado;
    }




    /**
     * @param bloqueado the bloqueado to set
     */
    public void setBloqueado(double bloqueado) {
        this.bloqueado = bloqueado;
    }




    /**
     * @return the tonalidade
     */
    public String getTonalidade() {
        return tonalidade;
    }




    /**
     * @param tonalidade the tonalidade to set
     */
    public void setTonalidade(String tonalidade) {
        this.tonalidade = tonalidade;
    }




    /**
     * @return the ordem
     */
    public int getOrdem() {
        return ordem;
    }




    /**
     * @param ordem the ordem to set
     */
    public void setOrdem(int ordem) {

        this.ordem = ordem;
        if (ordem == 0) {
            this.selecionado = "S";
        }
    }


    public String getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(String selecionado) {
        this.selecionado = selecionado;
    }

    public double getQtdComprada() {
        return qtdComprada;
    }

    public void setQtdComprada(double qtdComprada) {
        this.qtdComprada = qtdComprada;
    }

    public double diferencaQtd() {
        double diferenca = qtd - qtdComprada;

        if (diferenca < 0) {
            diferenca = qtd*100;
        }

        return diferenca;
    }

    public long getCoditprod() {
        return coditprod;
    }

    public void setCoditprod(long coditprod) {
        this.coditprod = coditprod;
    }


    public String getDtFabricacao() {
        return dtFabricacao;
    }
    public void setDtFabricacao(String dtFabricacao) {
        this.dtFabricacao = dtFabricacao;
    }

}

