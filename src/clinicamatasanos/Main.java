
package clinicamatasanos;

import java.lang.reflect.*;
import java.util.Date;

public class Main {
    
    public static void main (String args[]){
    
        // CREAMOS LOS OBJETOS PARA LA PRUEBA
        
        // Persona y sus atributos
        Persona persona = new Persona();
        persona.setRUN("20151855-5");
        persona.setNombres("Sebastian Andres");
        persona.setApellidos("Alday Núñez");
        Date nacimiento = new Date(1999,05,31);
        persona.setFechaNacimiento(nacimiento);
        
        // Usuario y sus atributos
        Usuario usuario = new Usuario();
        usuario.persona = persona;
        usuario.setDerivacion("Derivado una clínica mental.");
        
        // StakeHolder y  sus atributos
        Stakeholder stkholder = new Stakeholder();
        stkholder.persona = persona;
        stkholder.setPassword("Bad Bunny");
        
        // Profesional
        Profesional profesional = new Profesional();
        profesional.stakeholder = stkholder;
        
        // Administrador
        Administrador administrador = new Administrador();
        administrador.stakeholder = stkholder;
        
        // Secretaria 
        Secretaria secretaria = new Secretaria();
        secretaria.stakeholder = stkholder;
        

        // AHORA HACEMOS COPIAS DE LA CLASE DE CADA
        // UNO DE LOS OBJETOS CREADOS
        
        Class reflect_per = persona.getClass();
        Class reflect_usu = usuario.getClass();
        Class reflect_stk = stkholder.getClass();
        Class reflect_pro = profesional.getClass();
        Class reflect_adm = administrador.getClass();
        Class reflect_sec = secretaria.getClass();
        
        
        // LAS AGREGAMOS A UN ARRAY DE OBJETOS
        
        Class[] clases = new Class[6];
        clases[0] = reflect_per;
        clases[1] = reflect_usu;
        clases[2] = reflect_stk;
        clases[3] = reflect_pro;
        clases[4] = reflect_adm;
        clases[5] = reflect_sec;

        
        // MOSTRAMOS LOS DATOS DE CADA UNO DE LAS CLASES REFLEJADOS
        
        try{
            for (Class o: clases){
                
                System.out.println("\n--------------------- INFORMACIÓN DE LA CLASE: "+ o.getSimpleName().toUpperCase() +" -------------------");

                
                // Se obtiene el valor del modificador de la clase reflejada
                int mod = o.getModifiers();
                
                // Se muestra el valor decodificado. Utilizando el método: Modifier.toString (int mod)
                System.out.println("\nModificador de la clase: " + Modifier.toString(mod));
                
                // Constructor de clase
                Constructor[] cons = o.getDeclaredConstructors();
                for (Constructor c: cons){System.out.println("Constructor: " + c);}
                
                // Clase y nombre 
                System.out.println("Clase: " + o);
                System.out.println("Nombre de clase: " + o.getSimpleName());
                
                System.out.println("\n---------------------- ATRIBUTOS DE LA CLASE: "+ o.getSimpleName().toUpperCase() +" --------------------\n");
                
                // Campos (AtributoS)
                Field[] campos = o.getDeclaredFields();
                for (Field f: campos){System.out.println("Campo (Atributo): " + f);}
                
                System.out.println("\n---------------------- MÉTODOS DE LA CLASE: "+ o.getSimpleName().toUpperCase() +" ----------------------");

                // Métodos y sus modificadores
                Method[] metodos = o.getDeclaredMethods();
                for (Method m: metodos){
                    int mod_m = m.getModifiers();
                    System.out.println("\nMetodo: " + m);
                    System.out.println("Modificador: " + Modifier.toString(mod_m)); // Se utiliza nuevamente el método: Modifier.toString()
                }
                
                System.out.println("\n\n\n");
            }
        }
        catch(Exception ex){System.out.println(ex.getMessage());}
    }
    
    
}
