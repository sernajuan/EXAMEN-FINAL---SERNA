
package modeloDAO;
import config.bd.ConectaBD;
import interfaces.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.producto;

public class productoDAO {
      ConectaBD cn = new ConectaBD();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    producto e = new producto();
    
    public List listarproducto() {
        ArrayList<producto> productos = new ArrayList<>();
        String consulta = " select *  "
                        + "from producto ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while(rs.next()){
                producto producto = new producto();
                producto.setIdproducto(rs.getInt("idproducto"));
                producto.setCodigo(rs.getString("codigo"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getFloat("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getString("estado"));
                productos.add(producto);
            }            
        } catch (SQLException e) {
            System.out.println("Error durante el select");
        }
        return productos;
    }
    
    public producto buscarproducto(int idproducto) {
        String consulta = " select *  "
                        + "from producto  "
                        + "where idproducto = " + idproducto + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {                
                e.setIdproducto(rs.getInt("idproducto"));
                e.setCodigo(rs.getString("codigo"));
                e.setNombre(rs.getString("nombre"));
                e.setPrecio(rs.getFloat("precio"));
                e.setStock(rs.getInt("stock"));
                e.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error durante el select");        
        }
        return e;
    }  
    
    public boolean editarproducto(producto producto) {
        String consulta = " update producto  "
                        + " set  "
                        + " codigo = '"+ producto.getCodigo()+"', "
                        + " nombre = '"+ producto.getNombre()+"', "
                        + " precio = '"+ producto.getPrecio()+"', "
                        + " stock = '"+ producto.getStock()+"', "
                        + " estado = '"+ producto.getEstado()+"'  "
                        + " where "
                        + " idproducto = " + producto.getIdproducto()+ "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error durante la edición del estudiante");
            return true;
        }
        return false;
    }

    public boolean eliminarproducto(int idproducto) {
        String consulta = " delete  "
                        + " from estudiante  "
                        + " where "
                        + " idproducto = " + idproducto;
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error durante la edición del producto");
            return true;
        }
        return false;
    }    

    public boolean agregarproducto(producto producto) {
        String consulta = " insert into producto(codigo, nombre, precio, stock, estado)  "
                        + " values(  "
                        + "'"+ producto.getCodigo()+"', "
                        + "'"+ producto.getNombre() +"',  "
                        + "'"+ producto.getPrecio()+"',  "
                        + "'"+ producto.getStock()+"',  "
                        + "'"+ producto.getEstado() +"'); ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error durante la insert del nuevo producto");
            return true;
        }
        return false;
        
    }
    
}
