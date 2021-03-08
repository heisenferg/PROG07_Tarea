public class Banco {

    private CuentaBancaria[] listCuenta;
    private int Ncuentas;
    public static final int CAPACIDAD = 100;
    double ingreso;
    double retirada;
    double saldo;
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
    public boolean abrirCuenta(CuentaBancaria cuenta){
        if (Ncuentas < CAPACIDAD) {
                listCuenta[Ncuentas] = cuenta;
                Ncuentas++;
                return true;
        } else
        return false;
    }

//Listar Cuenta
    public void listadoCuentas(){
        for(int i =0; i < Ncuentas; i++){
            System.out.println(listCuenta[i].devolverInfoString());
        }
    }

//Información cuenta. Pide iban

    public String informacionCuenta(String iban){

        for (int i=0; i<listCuenta.length;i++){
            if (listCuenta[i].getIban().equals(iban)){
                return listCuenta[i].devolverInfoString();
            }
            System.out.println("No existe la cuenta.");
        }
        return null;
    }




//Ingreso cuenta.

    public boolean ingresoCuenta(String iban, double ingreso){
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

    //-------------------------------------

    private CuentaBancaria buscarCuenta (String iban){
        CuentaBancaria cuenta = null;
        for (int i =0; i <Ncuentas; i++){
            if (listCuenta[i].getIban().equals(iban)) {
                cuenta = listCuenta[i];
            }
        }
        return cuenta;
    }

//Sacar dinero de la cuenta.

    public boolean retiradaCuenta(String iban, double retirada){
        if (retirada == 0) {
            throw new IllegalArgumentException("El importe a retirar no puede ser cero.");
        }
        if (retirada < 0) {
            throw new IllegalArgumentException("El importe a retirar no puede ser negativo.");
        }

        CuentaBancaria cuenta = buscarCuenta(iban);
        if (cuenta != null){
            return cuenta.retiradaCuenta(retirada);
        }

        System.out.println("No existe la cuenta.");
        return false;
    }

//Ver saldo.

    public double obtenerSaldo(String iban){
        for (int i=0; i<listCuenta.length;i++){
            if (listCuenta[i].getIban().equals(iban)){
                System.out.println(listCuenta[i].getSaldo() + " euros.");

            }System.out.println("No existe la cuenta.");

        }

        return -1;
    }

}
