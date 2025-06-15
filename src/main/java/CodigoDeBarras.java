

import entity.LoteVencto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodigoDeBarras {

    public static void main(String[] args) {
        //Fazer testes com os códigos lidos do comentário acima


        String codigoLido = "015035168850378511191205103921124";
        LoteVencto lote = quebraCodigoLido(codigoLido);
        if (lote != null) {
            System.out.println("Código: " + lote.getCoditprod());
            System.out.println("Lote: " + lote.getLote());
            System.out.println("Data de Vencimento: " + lote.getDtVencto());
            System.out.println("Data de Fabricação: " + lote.getDtFabricacao());
        } else {
            System.out.println("Código não reconhecido.");
        }
    }

    public static LoteVencto quebraCodigoLido(String codigo) {
        // Padrões regex com EAN de 13 ou 14 dígitos
        String tipo1 = "^\\(01\\)\\d{13,14}\\(17\\)\\d{6}\\(10\\).+";
        String tipo2 = "^\\(01\\)\\d{13,14}\\(11\\)\\d{6}\\(10\\).+";
        String tipo3 = "^\\(01\\)\\d{13,14}\\(17\\)\\d{6}\\(11\\)\\d{6}\\(10\\).+";
        String tipo4 = "^\\(01\\)\\d{13,14}\\(11\\)\\d{6}\\(17\\)\\d{6}\\(10\\).+";
        String tipo5 = "^\\(01\\)\\d{13,14}\\(10\\).+";

        // Compilação dos padrões
        Pattern p1 = Pattern.compile("\\(01\\)(\\d{13,14})\\(17\\)(\\d{6})\\(10\\)(.+)");
        Pattern p2 = Pattern.compile("\\(01\\)(\\d{13,14})\\(11\\)(\\d{6})\\(10\\)(.+)");
        Pattern p3 = Pattern.compile("\\(01\\)(\\d{13,14})\\(17\\)(\\d{6})\\(11\\)(\\d{6})\\(10\\)(.+)");
        Pattern p4 = Pattern.compile("\\(01\\)(\\d{13,14})\\(11\\)(\\d{6})\\(17\\)(\\d{6})\\(10\\)(.+)");
        Pattern p5 = Pattern.compile("\\(01\\)(\\d{13,14})\\(10\\)(.+)");


        //Log.e(TAG, "quebraCodigoLido = " + codigo);
        LoteVencto auxLote = new LoteVencto();
        if (codigo.matches(tipo1)) {
            //Log.e(TAG, "CODIGO TIPO 1");
            Matcher m = p1.matcher(codigo);
            if (m.find()) {
                auxLote.setCoditprod( Integer.parseInt(m.group(1)));
                auxLote.setLote(m.group(3));
                auxLote.setDtVencto(m.group(2));

            }
        } else if (codigo.matches(tipo2)) {
            //Log.e(TAG, "CODIGO TIPO 2");
            Matcher m = p2.matcher(codigo);
            if (m.find()) {
                auxLote.setCoditprod( Integer.parseInt(m.group(1)));
                auxLote.setLote(m.group(3));
                auxLote.setDtFabricacao(m.group(2));
            }
        } else if (codigo.matches(tipo3)) {
            //Log.e(TAG, "CODIGO TIPO 3");
            Matcher m = p3.matcher(codigo);
            if (m.find()) {
                auxLote.setCoditprod( Integer.parseInt(m.group(1)));
                auxLote.setLote(m.group(4));
                auxLote.setDtFabricacao(m.group(3));
                auxLote.setDtVencto(m.group(2));
            }
        } else if (codigo.matches(tipo4)) {
            //Log.e(TAG, "CODIGO TIPO 4");
            Matcher m = p4.matcher(codigo);
            if (m.find()) {
                auxLote.setCoditprod( Integer.parseInt(m.group(1)));
                auxLote.setLote(m.group(4));
                auxLote.setDtFabricacao(m.group(2));
                auxLote.setDtVencto(m.group(3));
            }
        } else if (codigo.matches(tipo5)) {
            //Log.e(TAG, "CODIGO TIPO 5");
            Matcher m = p5.matcher(codigo);
            if (m.find()) {
                auxLote.setCoditprod( Integer.parseInt(m.group(1)));
                auxLote.setLote(m.group(2));
            }
        } else {
            return null; // Código não reconhecido
        }

        return auxLote;
    }



}
