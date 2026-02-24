import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        int opcion = 0;

        while (opcion != 7) {
            System.out.println("******************************************");
            System.out.println("Sea bienvenido al Conversor de Moneda de Nayi =]");
            System.out.println("1) Dólar => Sol Peruano\n2) Sol Peruano => Dólar\n3) Dólar => Real Brasileño\n4) Real Brasileño => Dólar\n5) Dólar => Peso Colombiano\n6) Peso Colombiano => Dólar\n7) Salir");
            System.out.print("Elija una opción válida: ");
            opcion = lectura.nextInt();

            if (opcion == 7) break;

            System.out.print("Ingrese el valor que desea convertir: ");
            double valor = lectura.nextDouble();


            String base = (opcion % 2 != 0) ? "USD" : (opcion == 2 ? "PEN" : opcion == 4 ? "BRL" : "COP");
            String destino = (opcion % 2 != 0) ? (opcion == 1 ? "PEN" : opcion == 3 ? "BRL" : "COP") : "USD";

            Moneda moneda = consulta.buscarMoneda(base);
            if (moneda != null && moneda.conversion_rates() != null) {
                double tasa = moneda.conversion_rates().get(destino);
                System.out.println("El valor " + valor + " [" + base + "] corresponde a => " + (valor * tasa) + " [" + destino + "]");
            } else {
                System.out.println("¡Ups! No pude obtener los datos de la moneda.");
            }
        }
    }
}
