package util;

public final class funcoes {
    public static double Arredonda(double arr, double casas){
        double respma =  Math.round( arr * Math.pow( 10 , casas ) ) / Math.pow(10, casas);
        return respma;
    }


}
