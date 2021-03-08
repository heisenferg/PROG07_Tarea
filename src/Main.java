import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static boolean cDNI(String DNI) {
        boolean comprobar = true;
        Pattern nif = Pattern.compile("^[XYxy]?[0-9]{8}[A-Za-z]$");
        Matcher Nif = nif.matcher(DNI);
        comprobar = ((Matcher) Nif).matches();
        return comprobar;
    }

    public static void main(String[] args) throws Exception {

        int opcion=0;
        Scanner teclado = new Scanner(System.in);
        Banco banco = new Banco();
        CuentaBancaria CuentaBancaria =new CuentaBancaria();


//Menú principal
        while(opcion!=7) {
            try{
            System.out.println("\nIntroduce alguna de las opciones siguientes: \n");
            System.out.println("1. Abrir una nueva cuenta.");
            System.out.println("2. Ver un listado de las cuentas disponibles.");
            System.out.println("3. Obtener los datos de una cuenta concreta.");
            System.out.println("4. Realizar un ingreso.");
            System.out.println("5. Retirar efectivo de una cuenta.");
            System.out.println("6. Consultar el saldo actual de una cuenta.");
            System.out.println("7. Salir de la aplicación.");
            opcion = teclado.nextInt();

            //Switch de opciones
            switch(opcion){
                case 1:
                    System.out.print("Introduzca nombre del titular: ");
                    String nombre = teclado.next();

                    System.out.print("Introduzca los apellidos: ");
                    String apellidos = teclado.next();

                    System.out.print("Introduzca el DNI: ");
                    String DNI = teclado.next();
                    if (!cDNI(DNI)) {
                        throw new Exception("El formato del DNI no es el apropiado.");
                    }
                    teclado.nextLine();


                    Persona cliente = new Persona(nombre, apellidos, DNI);

                    System.out.print("Introduzca el saldo inicial: ");
                    float saldo = teclado.nextFloat();

                    System.out.print("Introduzca el IBAN: ");
                    String iban = teclado.next();
                    if (!CuentaBancaria.cIban(iban)){
                        throw new Exception ("El formato del Iban no es correcto.");
                    }
                    banco.abrirCuenta(saldo, iban, cliente);

                    System.out.println("------------------------------------------------");
                    System.out.println("\nIntroduzca el tipo de cuenta que desea crear: ");
                    System.out.println("1. Cuenta de ahorro.");
                    System.out.println("2. Cuenta corriente personal.");
                    System.out.println("3. Cuenta corriente de empresa.");
                    banco.setTipocuenta(teclado.nextInt());

                    //Switch tipo cuenta
                    switch (banco.getTipocuenta()){
                        case 1:
                            System.out.println("CUENTA DE AHORRO.");
                            System.out.println("-----------------");

                            System.out.print("Introduce el tipo de interés de remuneración: ");
                            float tipo_interes = teclado.nextFloat();

                            CuentaAhorro ahorro = new CuentaAhorro(saldo, iban, cliente, tipo_interes);
                            System.out.println("Cuenta de ahorro creada.");
                            break;
                        case 2:
                            System.out.println("CUENTA CORRIENTE PERSONAL.");
                            System.out.println("--------------------------");

                            System.out.print("Introduce la comisión de mantenimiento: ");
                            float comision = teclado.nextFloat();
                            teclado.nextLine();

                            System.out.print("Introduce las entidades que harán cobros en la cuenta: ");
                            String entidades_cobro = teclado.next();
                            CuentaBancaria personal = new CuentaCorrientePersonal(saldo, iban, cliente, entidades_cobro, comision);
                            System.out.println("Cuenta corriente personal creada.");
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
                            teclado.nextLine();

                            System.out.print("Introduce las entidades que harán cobros en la cuenta: ");
                            entidades_cobro = teclado.nextLine();

                            CuentaBancaria empresa = new CuentaCorrienteEmpresa(saldo, iban, cliente, entidades_cobro, interes_descubierto, maximo_descubierto, comision_descubierto);
                            System.out.println("Cuenta corriente de empresa creada.");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Ver un listado de las cuentas disponibles (código de cuenta, titular y saldo actual).");
                    System.out.println("---------------------------------------------------------------------------------------");
                    banco.listadoCuentas();
                    break;
                case 3:
                    System.out.print("Introduce un IBAN a buscar: ");
                    iban = teclado.next();
                    String ibanBuscar = banco.informacionCuenta(iban);
                    if (ibanBuscar != null) {
                        System.out.println(ibanBuscar);
                    } else {
                        System.out.println("El IBAN no está guardado.");
                    }
                    break;
                case 4:
                    System.out.println("REALIZAR UN INGRESO.");
                    System.out.println("--------------------");
                    System.out.println("Introduce tu cuenta (Iban): ");
                    iban = teclado.next();
                    System.out.print("Cantidad a ingresar: ");
                    float ingreso = teclado.nextFloat();
                    banco.ingresoCuenta(iban, ingreso);
                    break;
                case 5:
                    System.out.println("RETIRAR EFECTIVO DE LA CUENTA");
                    System.out.println("-----------------------------");
                    System.out.print("Introduce tu cuenta (Iban): ");
                    iban = teclado.next();
                    System.out.print("Cantidad que desea retirar: ");
                    float retirada = teclado.nextFloat();
                    banco.retiradaCuenta(iban, retirada);
                    break;
                case 6:
                    System.out.println("CONSULTAR SALDO.");
                    System.out.println("----------------");
                    System.out.print("Introduce número de cuenta (Iban)");
                    iban = teclado.next();
                    banco.obtenerSaldo(iban);
                    break;
            }
            //EXCEPCIÓN DEL MENÚ
        } catch (InputMismatchException e) {
            System.out.println("Debe introducir un número entero.");
            teclado.next();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
}
