import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        int opcion=0;
        Scanner teclado = new Scanner(System.in);
        Banco banco = new Banco();


//Menú principal
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

            //Switch de opciones
            switch(opcion){
                case 1:
                    System.out.print("Introduzca nombre del titular: ");
                    String nombre = teclado.next();

                    System.out.print("Introduzca los dos apellidos: ");
                    String apellidos = teclado.next();

                    System.out.print("Introduzca el DNI: ");
                    String DNI = teclado.next();

                    Persona cliente = new Persona(nombre, apellidos, DNI);

                    System.out.print("Introduzca el saldo inicial: ");
                    float saldo = teclado.nextFloat();

                    System.out.print("Introduzca el IBAN: ");
                    String iban = teclado.next();
                    if (!CuentaBancaria.cIban(iban)){
                        throw new Exception ("El formato del Iban no es correcto.");
                    }

                    System.out.println("------------------------------------------------");
                    System.out.println("\nIntroduzca el tipo de cuenta que desea crear: ");
                    System.out.println("1. Cuenta de ahorro.");
                    System.out.println("2. Cuenta corriente personal.");
                    System.out.println("3. Cuenta corriente de empresa.");
                    int tipocuenta = teclado.nextInt();

                    //Switch tipo cuenta
                    switch (tipocuenta){
                        case 1:
                            System.out.println("CUENTA DE AHORRO.");
                            System.out.println("-----------------");

                            System.out.print("Introduce el tipo de interés de remuneración: ");
                            float tipo_interes = teclado.nextFloat();

                            banco.abrirCuenta(saldo, iban, tipo_interes, cliente);
                            break;
                        case 2:
                            System.out.println("CUENTA CORRIENTE PERSONAL.");
                            System.out.println("--------------------------");

                            System.out.print("Introduce la comisión de mantenimiento: ");
                            float comision = teclado.nextFloat();

                            System.out.print("Introduce las entidades que harán cobros en la cuenta: ");
                            String entidades_cobro = teclado.next();

                            CuentaCorrientePersonal personal = new CuentaCorrientePersonal(saldo, iban, entidades_cobro,comision);
                            break;

                        case 3:
                            System.out.println("CUENTA CORRIENTE EMPRESA.");
                            System.out.println("-------------------------");

                            System.out.print("Introduce el interés descubierto: ");
                            float interes_descubierto = teclado.nextFloat();

                            System.out.print("Introduce el máximo descubierto permitido: ");
                            float maximo_descubierto = teclado.nextFloat();

                            System.out.print("Introduce la comisiçon de descubierto: ");
                            float comision_descubierto = teclado.nextFloat();

                            System.out.print("Introduce las entidades que harán cobros en la cuenta: ");
                            entidades_cobro = teclado.next();

                            CuentaCorrienteEmpresa empresa = new CuentaCorrienteEmpresa(saldo, iban, entidades_cobro, interes_descubierto, maximo_descubierto, comision_descubierto);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Ver un listado de las cuentas disponibles (código de cuenta, titular y saldo actual).");
                    System.out.println("---------------------------------------------------------------------------------------");
                    banco.listadoCuentas();

            }
        }
    }
}
