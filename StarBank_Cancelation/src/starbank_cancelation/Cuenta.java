package starbank_cancelation;

public class Cuenta {

    private String tipo;
    private int saldo;
    private Boolean isActive;
    private String sucursal_padre;

    public Cuenta(String tipo, int saldo, Boolean isActive, String sucursal_padre) {
        this.tipo = tipo;
        this.saldo = saldo;
        this.isActive = isActive;
        this.sucursal_padre = sucursal_padre;
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
        
        return null;
        
    }
    
    
}
