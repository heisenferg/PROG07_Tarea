import org.w3c.dom.ls.LSOutput;

public class Banco {

    private CuentaBancaria[] listCuenta;
    private int Ncuentas;
    public static final int CAPACIDAD = 100;
    float ingreso, retirada, saldo;
    int tipocuenta;

    /*Declaramos el constructor inicializando el número de vehículos en 0
    y determinando el array con el máximo de capacidad.
    */

    public int getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(int tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    public Banco() {
        Ncuentas = 0;
        listCuenta = new CuentaBancaria[CAPACIDAD];
    }

//Abrir cuenta
    public boolean abrirCuenta(float saldo, String iban,  Persona cliente){
        if (Ncuentas < CAPACIDAD) {

                CuentaBancaria cuenta = new CuentaBancaria(saldo, iban, cliente);
                listCuenta[Ncuentas] = cuenta;
                Ncuentas++;
                System.out.println("Cuenta bancaria creada.");

            return true;
        }
        return false;
    }
//Listar Cuenta
    public void listadoCuentas(){
        for(int i =0; i < Ncuentas; i++){
            System.out.println(listCuenta[i].toString());
        }
    }

//Información cuenta. Pide iban

    public String informacionCuenta(String iban){

        for (int i=0; i<100;i++){
            if (listCuenta[i].getIban().equals(iban)){
                return listCuenta[i].toString();
            }
            System.out.println("No existe la cuenta.");
        }
        return null;
    }




//Ingreso cuenta.REVISAR

    public boolean ingresoCuenta(String iban, float ingreso){
        if (ingreso == 0) {
            throw new IllegalArgumentException("El importe a ingresar no puede ser cero.");
        }
        if (ingreso < 0) {
            throw new IllegalArgumentException("El importe a ingresar no puede ser negativo.");
        }
        for (int i=0; i<Ncuentas; i++){
            if (listCuenta[i].getIban().equals(iban)){
                listCuenta[i].saldoActualizado(ingreso);
                System.out.println("Ingreso de dinero realizado con éxito.");

                return true;
            }
            System.out.println("NO existe esa cuenta.");
        }
        return false;
    }

//SACAr dinero

    public boolean retiradaCuenta(String iban, float retirada){
        if (retirada == 0) {
            throw new IllegalArgumentException("El importe a retirar no puede ser cero.");
        }
        if (retirada < 0) {
            throw new IllegalArgumentException("El importe a retirar no puede ser negativo.");
        }

        for (int i=0; i<Ncuentas; i++){
            if (listCuenta[i].getIban().equals(iban)){
                if (listCuenta[i].getSaldo()< retirada) {
                    System.out.println("NO hay fondos suficientes.");
                    break;
                }

                listCuenta[i].saldoRetirado(retirada);
                System.out.println("Retirada de dinero realizada correctamente.");
                return true;
            }
        }
        return false;
    }

//Ver saldo.

    public double obtenerSaldo(String iban){
        for (int i=0; i<Ncuentas;i++){
            if (listCuenta[i].getIban().equals(iban)){
                return listCuenta[i].getSaldo();
            }
        }
        return -1;
    }

}
