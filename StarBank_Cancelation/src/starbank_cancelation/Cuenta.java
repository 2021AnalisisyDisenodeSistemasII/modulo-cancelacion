package starbank_cancelation;

public class Cuenta {

    private String id_cuenta;
    private String id_cliente;
    private String tipo;
    private int saldo;
    private Boolean isActive;
    private String sucursal_padre;
    private String[] historial;

    public Cuenta(String id_cuenta, String id_cliente, String tipo, int saldo, Boolean isActive, String sucursal_padre) {
        this.id_cuenta = id_cuenta;
        this.id_cliente = id_cliente;
        this.tipo = tipo;
        this.saldo = saldo;
        this.isActive = isActive;
        this.sucursal_padre = sucursal_padre;
        //pendiente
        this.historial = null;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getSucursal_padre() {
        return sucursal_padre;
    }

    public void setSucursal_padre(String sucursal_padre) {
        this.sucursal_padre = sucursal_padre;
    }
    
    @Override
    public String toString() {
        
        //Metodo incompleto
        return null;
        
    }
    
    
}
