public class CuentaCorrienteEmpresa extends CuentaBancaria{
    float interes_descubierto;
    float maximo_descubierto;
    float comision_descubierto;
    String entidades_cobro;

    /*
    Constructor
     */

    public CuentaCorrienteEmpresa(double saldo, String iban, Persona p1, String entidades_cobro, float interes_descubierto, float maximo_descubierto, float comision_descubierto) {
        super(saldo, iban, p1);
        this.interes_descubierto = interes_descubierto;
        this.maximo_descubierto = maximo_descubierto;
        this.comision_descubierto = comision_descubierto;
    }

    /*
    Getter y setter
     */

    public float getInteres_descubierto() {
        return interes_descubierto;
    }

    public void setInteres_descubierto(float interes_descubierto) {
        this.interes_descubierto = interes_descubierto;
    }

    public double getMaximo_descubierto() {
        return maximo_descubierto;
    }

    public void setMaximo_descubierto(float maximo_descubierto) {
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
