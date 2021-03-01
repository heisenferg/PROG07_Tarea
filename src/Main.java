import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int opcion=0;
        Scanner teclado = new Scanner(System.in);


        while(opcion!=7) {
            System.out.println("\nIntroduce alguna de las opciones siguientes: \n");
            System.out.println("1. Abrir una nueva cuenta.");
            System.out.println("2. Ver un listado de las cuentas disponibles.");
            System.out.println("3. Obtener los datos de una cuenta concreta.");
            System.out.println("4. Realizar un ingreso.");
            System.out.println("5. Retirar efectivo de una cuenta.");
            System.out.println("6. Consultar el saldo acutal de una cuenta.");
            System.out.println("7. Salir de la aplicación.");
            opcion = teclado.nextInt();
        }
    }
}
