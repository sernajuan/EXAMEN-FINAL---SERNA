
package interfaces;
import java.util.List;
import modelo.producto;
import modelo.proveedor;

public interface CRUD {
    public List listarproducto();
    public producto buscarproducto(int idestudiante);
    public boolean agregarproducto(producto producto);
    public boolean editarproducto(producto producto);
    public boolean eliminarproducto(int idproducto);
    
    public List listarproveedor();
    public proveedor buscarproveedor(int idproveedor);
    public boolean agregarproveedor(proveedor proveedor);
    public boolean editarproveedor(proveedor proveedor);
    public boolean eliminarproveedor(int idproveedor);
}
