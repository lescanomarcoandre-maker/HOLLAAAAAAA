package accesoDatos;
/** 
 * @author FreddyIQ
 */
import entidades.Estudiante;    //importa a clase Estudiante de otro paquete
import java.io.*;               //entrada y salida datos
import java.util.*;             //importa colecciones

public class ListaEstudiantes {        
    //Declaración de variables de referencia           
    Estudiante oE;        
    ObjectOutputStream oup = null;      //Escritura    
    ObjectInputStream  inp = null;      //Lectura
    ArrayList<Estudiante> lstEst= null; //Coleccion  
    File mf = null;                     //Archivo
    
    //Constructor
    public ListaEstudiantes() {	
        //Se crea la coleccion y se especifica que almacene Estudiantes
        lstEst = new ArrayList<Estudiante>();
        //Crea el fichero de texto      
        mf = new File("ArchivoEstudiantes.txt");
    }
    
    //*********Metodos de Mantenimiento de la Coleccion de Estudiantes**********
    public void agregarEst(Estudiante oE) {        
        lstEst.add(oE);    //Se agrega a la coleccion        
    }    
    
    public Estudiante buscarEstxId(String id){
        Estudiante oE=null;
        //Recorre la coleccion
        for (Estudiante e: lstEst ){
            if(id.equals(e.getId()))
                oE = e;        
        }
        return oE;
    }   
    
    public Estudiante buscarEstxIndice(int i) {
        return lstEst.get(i);//Retorna el obj Estudiante
    }

    public void eliminarEst(Estudiante oE) {   
        lstEst.remove(oE);
    }   
    
    public int obtenerNEst() {
        return lstEst.size();
    }   
           
    public String listarEst() {
        String cad="";
        //Recorre la coleccion
        for (Estudiante c: lstEst )
            cad= cad + c.toString() + "\n";        
        return cad; //Retorna la informacion de todas las Estudiantes
    }   
    
    //******************Metodos de Acceso al Archivo de texto*******************
    public void escribirArchivo() {        
        try {
            //Permite la Serializacion
            oup = new ObjectOutputStream(new FileOutputStream(mf));        
            //Escribe la coleccion en el archivo
            oup.writeObject(lstEst);
            //Cierra el archivo
            oup.close();
            System.out.println("Se Registró en Archivo");
        }catch(Exception ex) {                
            System.out.println("Error con serializacion");
        }    
    }
    
    public String leerArchivo() {        
       try {
            //Permite la Deserializacion
            inp = new ObjectInputStream(new FileInputStream(mf));
            //Lee datos del archivo y lo pasa a una coleccion
            lstEst= (ArrayList<Estudiante>)inp.readObject();
            //Cierra el archivo
            inp.close();
        } catch (IOException | ClassNotFoundException ex) {                    
            System.out.println("Error con archivo");
        }        
        return listarEst();//Llama al método listarEst() y devuelve la lista de estudiantes en cadena
    }
}

















