
public class CuentaBancaria {
    double saldo;
    String iban;
    String entidades_cobro;
    Persona p1 = new Persona();

    public CuentaBancaria(double saldo, String iban, String entidades_cobro, Persona p1) {
        this.saldo = saldo;
        this.iban = iban;
        this.entidades_cobro = entidades_cobro;
        this.p1 = p1;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getEntidades_cobro() {
        return entidades_cobro;
    }

    public void setEntidades_cobro(String entidades_cobro) {
        this.entidades_cobro = entidades_cobro;
    }

    public Persona getP1() {
        return p1;
    }

    public void setP1(Persona p1) {
        this.p1 = p1;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "saldo=" + saldo +
                ", iban='" + iban + '\'' +
                ", entidades_cobro='" + entidades_cobro + '\'' +
                ", p1=" + p1 +
                '}';
    }
}
