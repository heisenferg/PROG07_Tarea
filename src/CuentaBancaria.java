import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class CuentaBancaria {
    protected float saldo;
    protected String iban;
    Persona p1 = new Persona();

    public CuentaBancaria() {
    }

    public CuentaBancaria(float saldo, String iban) {
        this.saldo = saldo;
        this.iban = iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getIban() {
        return iban;
    }

    public Persona getP1() {
        return p1;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setP1(Persona p1) {
        this.p1 = p1;
    }

    //COMPROBAR IBAN
    public static boolean cIban(String iban) {
        boolean comprobar = true;
        Pattern matr = Pattern.compile("[ES]+([0-9]{12})");
        Matcher mat = matr.matcher(iban);
        comprobar = mat.matches();
        return comprobar;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "saldo=" + saldo +
                ", iban='" + iban + '\'' +
                 '}';
    }
}
