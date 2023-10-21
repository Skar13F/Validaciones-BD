/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

/**
 *
 * @author labinfo04
 */
@MappedSuperclass
@Table(name = "venta_detalle")
public class VentaDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VentaDetallePK ventaDetallePK;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Venta venta;

    public VentaDetalle() {
    }

    public VentaDetalle(VentaDetallePK ventaDetallePK) {
        this.ventaDetallePK = ventaDetallePK;
    }

    public VentaDetalle(int idVenta, String idProducto) {
        this.ventaDetallePK = new VentaDetallePK(idVenta, idProducto);
    }

    public VentaDetallePK getVentaDetallePK() {
        return ventaDetallePK;
    }

    public void setVentaDetallePK(VentaDetallePK ventaDetallePK) {
        this.ventaDetallePK = ventaDetallePK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventaDetallePK != null ? ventaDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaDetalle)) {
            return false;
        }
        VentaDetalle other = (VentaDetalle) object;
        if ((this.ventaDetallePK == null && other.ventaDetallePK != null) || (this.ventaDetallePK != null && !this.ventaDetallePK.equals(other.ventaDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.VentaDetalle[ ventaDetallePK=" + ventaDetallePK + " ]";
    }
    
}
