public class CuentaAhorro extends CuentaBancaria{
    float tipo_interes;

    public CuentaAhorro(double saldo, String iban, String entidades_cobro, float tipo_interes,  Persona p1) {
        super(saldo, iban, entidades_cobro, p1);
        this.tipo_interes = tipo_interes;
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
                ", entidades_cobro='" + entidades_cobro + '\'' +
                '}';
    }
}
