public class CuentaAhorro extends CuentaBancaria{
    float tipo_interes;



    public CuentaAhorro(float saldo, String iban, Persona p1, float tipo_interes) {
        super(saldo, iban, p1);
        this.tipo_interes = tipo_interes;
    }



    public CuentaAhorro() {
    }

    public float getTipo_interes() {
        return tipo_interes;
    }

    public void setTipo_interes(float tipo_interes) {
        this.tipo_interes = tipo_interes;
    }

    @Override
    public String toString() {
        return "CuentaAhorro{" +
                "tipo_interes=" + tipo_interes +
                ", saldo=" + saldo +
                ", iban='" + iban + '\'' +

                '}';
    }
}
