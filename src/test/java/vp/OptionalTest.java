package vp;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by imosca on 19/08/2015.
 */
public class OptionalTest
        extends TestCase
{
    private final List<Persona> personas = new ArrayList<>();

    @BeforeClass
    public void setUp(){
        Persona p1 = new Persona("Ignacio", "Mosca",26);
        Persona p2 = new Persona("Gabriel", "Balbuena",29);
        Persona p3 = new Persona("Santiago", "Gonzalez",30);
        Persona p4 = new Persona("Rodrigo", "Lauber",32);
        Persona p5 = new Persona("Santiago", "Ferreiro",35);
        Persona p6 = new Persona("Aniela Ramona", "Amy",30);
        Persona p7 = new Persona("Giovanina", "Chirione",32);
        Persona p8 = new Persona("Santiago", "Zabalza",29);
        Persona p9 = new Persona("Gastón", "Arotztegui",24);
        personas.addAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9));
    }

    @Test
    public void testOptional(){
        personas.stream().filter(p->p.getNombre().startsWith("Z")).findAny().ifPresent(System.out::println);
    }

    @Test
    public void testOptional2(){
        if(!personas.stream().filter(p->p.getNombre().startsWith("Z")).findAny().isPresent()) System.out.println("WAAAH");
    }

    @Test
    public void testOptionalAPartirDeNull(){
        Optional o = Optional.ofNullable(null);
        if(o.isPresent()){
            System.out.println(o.toString());
        }else{
            System.out.println("no hay nada");
        }
    }

    @Test
    public void testOptionalAPartirDeAlgoQueObtenego(){
        Optional o = personas.stream().filter(p->p.getEdad()>30).findAny();
        if(o.isPresent()){
            System.out.println(o.toString());
        }else{
            System.out.println("no hay nada");
        }
    }


}
