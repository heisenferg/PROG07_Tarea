import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class  CuentaBancaria {
    protected double saldo;
    protected String iban;
    Persona p1 = new Persona();



    /*
    Constructores
     */

    public CuentaBancaria() {
    }

    /**
     *
     * @param saldo
     * @param iban
     * @param p1
     */
    public CuentaBancaria(double saldo, String iban, Persona p1) {
        this.saldo = saldo;
        this.iban = iban;
        this.p1 = p1;
    }

    /*
    métodos get y set
     */

    /**
     *
     * @return saldo, iban, cliente, iban
     */
    public double getSaldo() {
        return saldo;
    }

    public String getIban() {
        return iban;
    }

    public Persona getP1() {
        return p1;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setP1(Persona p1) {
        this.p1 = p1;
    }

    //COMPROBAR IBAN

    /**
     *
     * @param iban
     * @return comprobacion iban
     */
    public static boolean cIban(String iban) {
        boolean comprobar = true;
        Pattern matr = Pattern.compile("[ES]+([0-9]{12})");
        Matcher mat = matr.matcher(iban);
        comprobar = mat.matches();
        return comprobar;
    }

    /**
     *
     * @return string con datos
     */
    @Override
    public String toString() {
        return "Cuenta Bancaria con un saldo de " +
                saldo +
                " euros, cuyo IBAN es " + iban + " pertenece a " + p1 +
                ".";
    }

    //Suma del ingreso.

    /**
     *
     * @param ingreso
     */
    public void saldoActualizado(float ingreso){
        this.saldo += ingreso;
    }


    //Retirada de dinero.

    /**
     *
     * @param retirada
     */
    public void saldoRetirado(float retirada){
        this.saldo -= retirada;
    }
}
