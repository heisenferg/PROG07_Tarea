public class CuentaAhorro extends CuentaBancaria{
    float tipo_interes;
    Persona cliente = new Persona();

    public CuentaAhorro(float saldo, String iban, float tipo_interes) {
        super(saldo, iban);
        this.tipo_interes = tipo_interes;
    }

    public CuentaAhorro(float saldo, String iban, float tipo_interes, Persona cliente) {
        super(saldo, iban);
        this.tipo_interes = tipo_interes;
        this.cliente = cliente;
    }



    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
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
                cliente +
                '}';
    }
}
