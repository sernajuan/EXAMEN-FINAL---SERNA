package modeloDAO;
import config.bd.ConectaBD;
import interfaces.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.proveedor;

public class proveedorDAO {
      ConectaBD cn = new ConectaBD();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    proveedor e = new proveedor();
    
    public List listarproveedor() {
        ArrayList<proveedor> proveedores = new ArrayList<>();
        String consulta = " select *  "
                        + "from proveedor ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while(rs.next()){
                proveedor proveedor = new proveedor();
                proveedor.setIdproveedor(rs.getInt("idproveedor"));
                proveedor.setNombre(rs.getString("nombre"));
                proveedor.setRuc(rs.getString("ruc"));
                proveedor.setDireccion(rs.getString("direccion"));
                proveedor.setEstado(rs.getString("estado"));
                proveedores.add(proveedor);
            }            
        } catch (SQLException e) {
            System.out.println("Error durante el select");
        }
        return proveedores;
    }
    
    public proveedor buscarproveedor(int idproveedor) {
        String consulta = " select *  "
                        + "from proveedor  "
                        + "where idproveedor = " + idproveedor+ "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {                
                e.setIdproveedor(rs.getInt("idproveedor"));
                e.setNombre(rs.getString("nombre"));
                e.setRuc(rs.getString("ruc"));
                e.setDireccion(rs.getString("direccion"));
                e.setEstado(rs.getString("estado"));
                
            }
        } catch (SQLException e) {
            System.out.println("Error durante el select");        
        }
        return e;
    }  
    
    public boolean editarproveedor(proveedor proveedor) {
        String consulta = " update proveedor  "
                        + " set  "
                        + " idproveedor = '"+ proveedor.getIdproveedor()+"', "
                        + " nombre = '"+ proveedor.getNombre()+"', "
                        + " ruc = '"+ proveedor.getRuc()+"', "
                        + " direccion = '"+ proveedor.getDireccion()+"', "
                        + " estado = '"+ proveedor.getEstado()+"'  "
                        + " where "
                        + " idproveedor = " + proveedor.getIdproveedor()+ "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error durante la edición del proveedor");
            return true;
        }
        return false;
    }

    public boolean eliminarproveedor(int idproveedor) {
        String consulta = " delete  "
                        + " from proveedor  "
                        + " where "
                        + " idproveedor = " + idproveedor;
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error durante la edición del proveedor");
            return true;
        }
        return false;
    }    

    public boolean agregarproveedor(proveedor proveedor) {
        String consulta = " insert into proveedor( nombre, ruc, direccion, estado)  "
                        + " values(  "
                        + "'"+ proveedor.getNombre() +"',  "
                        + "'"+ proveedor.getRuc()+"',  "
                        + "'"+ proveedor.getDireccion()+"',  "
                        + "'"+ proveedor.getEstado() +"'); ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error durante la insert del nuevo proveedor");
            return true;
        }
        return false;
        
    }
    
}
