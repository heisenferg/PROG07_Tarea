public class CuentaCorrienteEmpresa extends CuentaBancaria{
    float interes_descubierto;
    double maximo_descubierto;
    float comision_descubierto;

    public CuentaCorrienteEmpresa(double saldo, String iban, String entidades_cobro, float interes_descubierto, double maximo_descubierto, float comision_descubierto,  Persona p1) {
        super(saldo, iban, entidades_cobro, p1);
        this.interes_descubierto = interes_descubierto;
        this.maximo_descubierto = maximo_descubierto;
        this.comision_descubierto = comision_descubierto;
    }

    public float getInteres_descubierto() {
        return interes_descubierto;
    }

    public void setInteres_descubierto(float interes_descubierto) {
        this.interes_descubierto = interes_descubierto;
    }

    public double getMaximo_descubierto() {
        return maximo_descubierto;
    }

    public void setMaximo_descubierto(double maximo_descubierto) {
        this.maximo_descubierto = maximo_descubierto;
    }

    public float getComision_descubierto() {
        return comision_descubierto;
    }

    public void setComision_descubierto(float comision_descubierto) {
        this.comision_descubierto = comision_descubierto;
    }

    @Override
    public String toString() {
        return "CuentaCorrienteEmpresa{" +
                "saldo=" + saldo +
                ", iban='" + iban + '\'' +
                ", entidades_cobro='" + entidades_cobro + '\'' +
                ", interes_descubierto=" + interes_descubierto +
                ", maximo_descubierto=" + maximo_descubierto +
                ", comision_descubierto=" + comision_descubierto +
                '}';
    }
}
