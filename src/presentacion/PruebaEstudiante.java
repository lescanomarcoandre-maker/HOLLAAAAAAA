package presentacion;

import accesoDatos.ListaEstudiantes;
import entidades.Estudiante;
import java.io.*;
/** 
 * @author FreddyIQ
 */
public class PruebaEstudiante {
    public static void main(String[] args) throws IOException {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Estudiante oE;        
        //Crea un obj para acceder a la clase ListaEstudiantes q esta el archivo
        ListaEstudiantes lista= new ListaEstudiantes();   
        
        //Variables primitivas
        String id, nom, car;    
        int N;
        
        System.out.println("Ingrese N estudiantes: ");
        N = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <=N; i++) {                    
            //Captura de datos
            System.out.println("Id: ");
            id = br.readLine();
            System.out.println("Nombre: ");
            nom= br.readLine();
            System.out.println("Carrera: ");
            car = br.readLine();

            //Se crea el Obj 
            oE= new Estudiante(id, nom, car);            
            //Se agrega el obj a la coleccion
            lista.agregarEst(oE);
        }         
        //Se escribe en el archivo la coleccion de objetos
        lista.escribirArchivo();
        
        //Se lee del archivo la coleccion de objetos
        System.out.println(lista.leerArchivo());    
        
        //Buscar Estudiantes por Id
         System.out.println("Id a buscar: ");
         id = br.readLine();         
         oE= lista.buscarEstxId(id);         
         System.out.println(oE);                         
    }    
}


