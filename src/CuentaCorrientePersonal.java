public class CuentaCorrientePersonal extends CuentaBancaria{
    float comision;
    String entidades_cobro;

    public CuentaCorrientePersonal(float saldo, String iban, String entidades_cobro, float comision) {
        super(saldo, iban);
        this.entidades_cobro=entidades_cobro;
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
