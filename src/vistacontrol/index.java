package vistacontrol;

import java.util.List;
import modelo.producto;
import modelo.proveedor;
import modeloDAO.productoDAO;
import modeloDAO.proveedorDAO;
import utils.Leer;

public class index {
    public static void Agregarproducto(){
        String codigo;
        String nombre;
        float precio;
        int stock;
        String estado;
        System.out.println("Agregar Nuevo producto");
        System.out.print("Codigo: ");
        codigo = Leer.cadena();
        System.out.print("Nombre: ");
        nombre = Leer.cadena();
        System.out.print("Precio: ");
        precio = (float) Leer.decimal();
        System.out.print("Stock: ");
        stock = Leer.entero();
        System.out.print("Estado: ");
        estado = Leer.cadena();
        producto producto = new producto(codigo, nombre, precio, stock, estado);
        productoDAO productoDAO = new productoDAO();
        productoDAO.agregarproducto(producto);
        
    }
     public static void Agregarproveedor(){
        
        String nombre;
        String ruc;
        String direccion;
        String estado;
        System.out.println("Agregar Nuevo proveedor");
        System.out.print("Nombre: ");
        nombre = Leer.cadena();
        System.out.print("Ruc: ");
        ruc = Leer.cadena();
        System.out.print("Direccion: ");
        direccion =  Leer.cadena();
        System.out.print("Estado: ");
        estado = Leer.cadena();
        
        proveedor proveedor = new proveedor(nombre, ruc,direccion, estado);
        proveedorDAO proveedorDAO = new proveedorDAO();
        proveedorDAO.agregarproveedor(proveedor);
        
    }
    public static void Eliminarproducto(){
        Listarproducto();
        System.out.print("Ingrese el ID del producto a Eliminar: ");
        int id = Leer.entero();
        productoDAO productoDAO = new productoDAO();
        productoDAO.eliminarproducto(id);
    }
     public static void Eliminarproveedor(){
        Listarproveedor();
        System.out.print("Ingrese el ID del proveedor a Eliminar: ");
        int id = Leer.entero();
        proveedorDAO proveedorDAO = new proveedorDAO();
        proveedorDAO.eliminarproveedor(id);
        
    }
     
     public static void Editarproducto(){
        Listarproducto();
        System.out.print("Ingrese el ID del producto a Editar: ");
        int id = Leer.entero();
        String codigo;
        String nombre;
        float precio;
        int stock;
        String estado;
        System.out.println("Editar producto");
        System.out.print("Nuevo Codigo: ");
        codigo = Leer.cadena();
        System.out.print("Nuevo Nombre: ");
        nombre = Leer.cadena();
        System.out.print("Nuevo Precio: ");
        precio = (float) Leer.decimal();
        System.out.print("Nuevo Stock: ");
        stock = Leer.entero();
        System.out.print("Nuevo Estado: ");
        estado = Leer.cadena();
        producto producto = new producto(id, codigo, nombre, precio, stock, estado);
        productoDAO productoDAO = new productoDAO();
        productoDAO.editarproducto(producto);
    }
    public static void Editarproveedor(){
        Listarproveedor();
        System.out.print("Ingrese el ID del proveedor a Editar: ");
        int id = Leer.entero();
        String nombre;
        String ruc;
        String direccion;
        String estado;
        
        System.out.println("Editar proveedor");
        System.out.print("Nuevo Nombre: ");
        nombre = Leer.cadena();
        System.out.print("Nueva Ruc: ");
        ruc = Leer.cadena();
        System.out.print("Nueva Direccion: ");
        direccion =  Leer.cadena();
        System.out.print("Nuevo Estado: ");
        estado = Leer.cadena();
       
        proveedor proveedor = new proveedor(id,  nombre, ruc, direccion, estado);
        proveedorDAO proveedorDAO = new proveedorDAO();
        proveedorDAO.editarproveedor(proveedor);
    }
     public static void Listarproducto(){
        productoDAO productoDAO = new productoDAO();
        List<producto> productos = productoDAO.listarproducto();
        System.out.println("ID\tCodigo\t\tNombre\t\tPrecio\t\tStock\t\tEstado");
        for (producto producto : productos) {
            System.out.println( producto.getIdproducto()+ "\t" + 
                                darFormato(producto.getCodigo()) + "\t" + 
                                producto.getNombre() + "\t" +
                                producto.getPrecio()+ "\t" +
                                producto.getStock()+ "\t" +
                                producto.getEstado());            
        }
        
    }
    
    public static String darFormato(String cadena){
        if (cadena.length()>=28) {
            cadena = cadena.substring(0,29) + "..";
        }else if (cadena.length()>=23) {
            // 
        }else if (cadena.length()>=17) {
            cadena = cadena + "\t";
        }else if (cadena.length()>=10) {
            cadena = cadena + "\t\t";
        }
        return cadena;
    }
    
    public static void Listarproveedor(){
        proveedorDAO proveedorDAO = new proveedorDAO();
        List<proveedor> proveedores = proveedorDAO.listarproveedor();
        System.out.println("ID\tNombre\t\tRuc\t\tDireccion\t\tEstado");
        for (proveedor proveedor : proveedores) {
            System.out.println( proveedor.getIdproveedor()+ "\t" + 
                                darFormato(proveedor.getNombre()) + "\t" + 
                                proveedor.getRuc() + "\t" +
                                proveedor.getDireccion()+ "\t" +
                               
                                proveedor.getEstado());            
        }
        
    }

    
    public static void salir(){
        System.out.println("Gracias por su visita");
    }
    
    public static void atras(){
        inicio();
    }
    
    
    public static void error(int tipo){
        switch(tipo){
            case 1:
                System.out.println("Opción fuera de rango");
                break;
            case 2:
                System.out.println(".....");
                break;
        }
        
    }
    public static void menu(){
        System.out.println("Menu Principal");
        System.out.println("1. Producto");
        System.out.println("2. Proveedor");
        
        
    }
    public static void menuproducto(){
        System.out.println("1. Agregar producto");
        System.out.println("2. Eliminar producto");
        System.out.println("3. Editar producto");
        System.out.println("4. Listar producto");
        System.out.println("5. Atras");
        System.out.print("Elegir las opciones [1-5]: ");
        
    }
    public static void menuproveedor(){
        System.out.println("1. Agregar proveedor");
        System.out.println("2. Eliminar proveedor");
        System.out.println("3. Editar proveedor");
        System.out.println("4. Listar proveedor");
        System.out.println("5. Atras");
        System.out.print("Elegir las opciones [1-5]: ");
        
    }
    public static void inicio(){
        int opcion;
            menu();
            System.out.println("INGRESAR VALOR");
            opcion=Leer.entero();
            //if(opcion == 1){
            switch(opcion){
                case 1 : 
                menuproducto();
                int producto;
                producto=Leer.entero();
                switch(producto){
                    case 1:
                    Agregarproducto();
                    break;
                case 2:
                    Eliminarproducto();
                    break;
                case 3:
                    Editarproducto();
                    break;
                case 4:
                    Listarproducto();
                    break;
                case 5:
                    atras();
                    break;
                default:
                    error(1);   
                }
                
                
                case 2 :
                     menuproveedor();
                int proveedor;
                proveedor=Leer.entero();
                    //pones tus datos
                    switch(proveedor){
                    case 1:
                    Agregarproveedor();
                    break;
                case 2:
                    Eliminarproveedor();
                    break;
                case 3:
                    Editarproveedor();
                    break;
                case 4:
                    Listarproveedor();
                    break;
                case 5:
                    atras();
                    break;
                default:
         
                    
                    break;
                    
            }
            
    }
    }
         
    public static void main(String[] args) {
        inicio();
    }    
}
