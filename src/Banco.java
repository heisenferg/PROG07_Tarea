

public class Banco {

    private CuentaBancaria[] listCuenta;
    private int Ncuentas;
    public static final int CAPACIDAD = 100;
    float ingreso, retirada;

    /*Declaramos el constructor inicializando el número de vehículos en 0
    y determinando el array con el máximo de capacidad.
    */


    public Banco() {
        Ncuentas = 0;
        listCuenta = new CuentaBancaria[CAPACIDAD];
    }

//Abrir cuenta
    public boolean abrirCuenta(double saldo, String iban, String entidades_cobro, Persona p1){
        if (Ncuentas < CAPACIDAD) {
            CuentaBancaria cuenta = new CuentaBancaria(saldo, iban, entidades_cobro, p1);
            return true;
        }
        return false;
    }
//Listar Cuenta
    public void listadoCuentas(){
        for(int i =0; i < Ncuentas; i++){
            System.out.println("asfd " + listCuenta[i].toString());
        }
    }

//Información cuenta. Pide iban

    public String informacionCuenta(String iban){
        for (int i=0; i<Ncuentas;i++){
            if (listCuenta[i].getIban().equals(iban)){
                return listCuenta[i].toString();
            }
        }
        return null;
    }

//Ingreso cuenta.REVISAR

    public boolean ingresoCuenta(String iban, float ingreso, double saldo){
        for (int i=0; i<Ncuentas; i++){
            if (listCuenta[i].getIban().equals(iban)){
               listCuenta[i].setSaldo(saldo+ingreso);
                System.out.println("Ingreso de dinero realizado con éxito.");
                return true;
            }
        }
        return false;
    }

//SACAr dinero

    public boolean retiradaCuenta(String iban, float retirada, double saldo){
        for (int i=0; i<Ncuentas; i++){
            if (listCuenta[i].getIban().equals(iban)){
                if (listCuenta[i].getSaldo()< retirada) {
                    System.out.println("NO hay fondos suficientes.");
                }
                System.out.println("Retirada de dinero realizada correctamente.");
                listCuenta[i].setSaldo(saldo-retirada);
                return true;
            }
        }
        return false;
    }

//Ver saldo.

    public double obtenerSaldo(String iban, double saldo){
        for (int i=0; i<Ncuentas;i++){
            if (listCuenta[i].getIban().equals(iban)){
                return listCuenta[i].getSaldo();
            }
        }
        return -1;
    }

}
