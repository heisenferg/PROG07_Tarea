public class CuentaCorrientePersonal extends CuentaBancaria{
    float comision;

    public CuentaCorrientePersonal(double saldo, String iban, String entidades_cobro, float comision,  Persona p1) {
        super(saldo, iban, entidades_cobro, p1);
        this.comision = comision;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

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
