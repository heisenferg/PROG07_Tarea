

public class Banco {

    private CuentaBancaria[] listCuenta;
    private int Ncuentas;
    public static final int CAPACIDAD = 100;
    float ingreso, retirada;
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
    public boolean abrirCuenta(float saldo, String iban, float tipo_interes, Persona cliente){
        if (Ncuentas < CAPACIDAD) {
            if (tipocuenta==1) {
                CuentaBancaria ahorro = new CuentaAhorro(saldo, iban, tipo_interes, cliente);
                listCuenta[Ncuentas] = ahorro;
                Ncuentas++;
                System.out.println("Cuenta de Ahorro creada.");
            } else if (tipocuenta==2){
                CuentaBancaria personal = new CuentaCorrientePersonal(saldo, iban, entidades_cobro, comision);
                listCuenta[Ncuentas] = personal;
                Ncuentas++;
                System.out.println("Cuenta corriente personal creada.");
            }
            return true;
        }
        return false;
    }
//Listar Cuenta
    public void listadoCuentas(){
        for(int i =0; i < Ncuentas; i++){
            System.out.println(listCuenta[i].toString());
            System.out.println("HOla");
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

    public boolean ingresoCuenta(String iban, float ingreso, float saldo){
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

    public boolean retiradaCuenta(String iban, float retirada, float saldo){
        for (int i=0; i<Ncuentas; i++){
            if (listCuenta[i].getIban().equals(iban)){
                if (listCuenta[i].getSaldo()< retirada) {
                    System.out.println("NO hay fondos suficientes.");
                }
                System.out.println("Retirada de dinero realizada correctamente.");
                listCuenta[i].setSaldo(saldo);
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
