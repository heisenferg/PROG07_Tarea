public class CuentaCorrientePersonal extends CuentaBancaria{
    float comision;
    String entidades_cobro;
/*
Constructor
 */
    /**
     *
     * @param saldo
     * @param iban
     * @param p1
     * @param entidades_cobro
     * @param comision
     */
    public CuentaCorrientePersonal(double saldo, String iban, Persona p1, String entidades_cobro, float comision) {
        super(saldo, iban, p1);
        this.entidades_cobro=entidades_cobro;
        this.comision = comision;
    }

    /**
     *
     * @return comision
     */
    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    /**
     *
     * @return string con todos los datos de la cuenta corriente personal.
     */
    @Override
    public String toString() {
        return "CuentaCorrientePersonal{" +
                "saldo=" + saldo +
                ", iban='" + iban + '\'' +
                ", entidades_cobro='" + entidades_cobro + '\'' +
                ", comision=" + comision +
                '}';
    }


}
