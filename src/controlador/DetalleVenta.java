package controlador;

public class DetalleVenta {

    //Atributos
    private int idDetalleVenta;
    private int idCabeceraVenta;
    private int idCebecera;

    //agregar mas 
    private String nombre;
    private int cantidad;
    private double subtotal;
    private double precioUnitario;
    private double descuento;
    private double igv;
    private double totalPagar;
    private int estado;
    
    
    //constructor
    public DetalleVenta(){
        this.idDetalleVenta = 0;
        this.idCabeceraVenta = 0;
        this.idCebecera = 0;
        this.nombre ="";
        this.cantidad = 0;
        this.subtotal = 0.0;
        this.precioUnitario = 0.0;
        this.descuento = 0;
        this.igv = 0.0;
        this.totalPagar = 0.0;
        this.estado = 0;
    }
    
    //constructor sobrecargado

    public DetalleVenta(int idDetalleVenta, int idCabeceraVenta, int idCebecera, String nombre, int cantidad, double subtotal, double precioUnitario, double descuento, double igv, double totalPagar, int estado) {
        this.idDetalleVenta = idDetalleVenta;
        this.idCabeceraVenta = idCabeceraVenta;
        this.idCebecera = idCebecera;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.precioUnitario = precioUnitario;
        this.descuento = descuento;
        this.igv = igv;
        this.totalPagar = totalPagar;
        this.estado = estado;
    }
    
    //get an set

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getIdCabeceraVenta() {
        return idCabeceraVenta;
    }

    public void setIdCabeceraVenta(int idCabeceraVenta) {
        this.idCabeceraVenta = idCabeceraVenta;
    }

    public int getIdCebecera() {
        return idCebecera;
    }

    public void setIdCebecera(int idCebecera) {
        this.idCebecera = idCebecera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    //toSTRING

    @Override
    public String toString() {
        return "DetalleVenta{" + "idDetalleVenta=" + idDetalleVenta + ", idCabeceraVenta=" + idCabeceraVenta + ", idCebecera=" + idCebecera + ", nombre=" + nombre + ", cantidad=" + cantidad + ", subtotal=" + subtotal + ", precioUnitario=" + precioUnitario + ", descuento=" + descuento + ", igv=" + igv + ", totalPagar=" + totalPagar + ", estado=" + estado + '}';
    }
    
    
    
    
    
}
