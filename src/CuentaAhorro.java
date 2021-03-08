public class CuentaAhorro extends CuentaBancaria{
    float tipo_interes;

    /**
     *
     * @param saldo
     * @param iban
     * @param p1
     * @param tipo_interes
     */
/*
Constructores.
 */
    public CuentaAhorro(double saldo, String iban, Persona p1, float tipo_interes) {
        super(saldo, iban, p1);
        this.tipo_interes = tipo_interes;
    }



    public CuentaAhorro() {
    }

    /*
    Métodos get y set.
     */
    public float getTipo_interes() {
        return tipo_interes;
    }

    public void setTipo_interes(float tipo_interes) {
        this.tipo_interes = tipo_interes;
    }


    /**
     * ToString que devuelve
     * @return tipo_interes, saldo e iban
     */
    @Override
    public String toString() {
        return "CuentaAhorro{" +
                "tipo_interes=" + tipo_interes +
                ", saldo=" + saldo +
                ", iban='" + iban + '\'' +

                '}';
    }


}
