
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodigoDeBarras {

    public static void main(String[] args) {

        leituraCodigoBarras("015035168850378511191205103921124");
        leituraCodigoBarras("012088452120219817280411102320161N");
        leituraCodigoBarras("01503516885037851103921124");
        leituraCodigoBarras("012080190221071917290930112410081014F24K0051");
        leituraCodigoBarras("0117898330282292112409201727092010T33990");
        leituraCodigoBarras("011697462929073317202510102211003071");
    }

    private static void leituraCodigoBarras(String codigoLido) {
        LoteVencto lote = quebraCodigoLido(codigoLido);
        System.out.println("CodigoLido: " + codigoLido);
        if (lote != null) {
            System.out.println("Código: " + lote.getCoditprod());
            System.out.println("Lote: " + lote.getLote());
            System.out.println("Data de Vencimento: " + lote.getDtVencto());
            System.out.println("Data de Fabricação: " + lote.getDtFabricacao());
            System.out.println("-----------------------");
        } else {
            System.out.println("Código não reconhecido.");
            System.out.println("-----------------------");
        }
    }

    public static LoteVencto quebraCodigoLido(String codigo) {
        LoteVencto auxLote = new LoteVencto();

        // Pattern: (01)13/14 + (17)6 + (10)variable
        Pattern p1 = Pattern.compile("^(\\d{13,14})(\\d{6})(\\d+)$");
        // Pattern: (01)13/14 + (11)6 + (10)variable
        Pattern p2 = Pattern.compile("^(\\d{13,14})(\\d{6})(\\d+)$");
        // Pattern: (01)13/14 + (17)6 + (11)6 + (10)variable
        Pattern p3 = Pattern.compile("^(\\d{13,14})(\\d{6})(\\d{6})(\\d+)$");
        // Pattern: (01)13/14 + (11)6 + (17)6 + (10)variable
        Pattern p4 = Pattern.compile("^(\\d{13,14})(\\d{6})(\\d{6})(\\d+)$");
        // Pattern: (01)13/14 + (10)variable
        Pattern p5 = Pattern.compile("^(\\d{13,14})(\\d+)$");

        Matcher m;
        if ((m = p3.matcher(codigo)).matches()) {
            auxLote.setCoditprod(Long.parseLong(m.group(1)));
            auxLote.setDtVencto(m.group(2));
            auxLote.setDtFabricacao(m.group(3));
            auxLote.setLote(m.group(4));
        } else if ((m = p4.matcher(codigo)).matches()) {
            auxLote.setCoditprod(Long.parseLong(m.group(1)));
            auxLote.setDtFabricacao(m.group(2));
            auxLote.setDtVencto(m.group(3));
            auxLote.setLote(m.group(4));
        } else if ((m = p1.matcher(codigo)).matches()) {
            auxLote.setCoditprod(Long.parseLong(m.group(1)));
            auxLote.setDtVencto(m.group(2));
            auxLote.setLote(m.group(3));
        } else if ((m = p2.matcher(codigo)).matches()) {
            auxLote.setCoditprod(Long.parseLong(m.group(1)));
            auxLote.setDtFabricacao(m.group(2));
            auxLote.setLote(m.group(3));
        } else if ((m = p5.matcher(codigo)).matches()) {
            auxLote.setCoditprod(Long.parseLong(m.group(1)));
            auxLote.setLote(m.group(2));
        } else {
            return null;
        }
        return auxLote;
    }

    private static class LoteVencto {
        private long coditprod;
        private String lote;
        private String dtVencto;
        private String dtFabricacao;

        public long getCoditprod() {
            return coditprod;
        }

        public void setCoditprod(long coditprod) {
            this.coditprod = coditprod;
        }

        public String getLote() {
            return lote;
        }

        public void setLote(String lote) {
            this.lote = lote;
        }

        public String getDtVencto() {
            return dtVencto;
        }

        public void setDtVencto(String dtVencto) {
            this.dtVencto = dtVencto;
        }

        public String getDtFabricacao() {
            return dtFabricacao;
        }

        public void setDtFabricacao(String dtFabricacao) {
            this.dtFabricacao = dtFabricacao;
        }
    }
}
