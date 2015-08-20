package vp;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Unit test for simple App.
 */
public class AppTest 
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
        Persona p9 = new Persona("Gastón", "Arotztegui",25);
        personas.addAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9));
    }

    @Test
    public void testListaPersonas(){
        List<Persona> retorno = personas.stream().filter(p->p.getNombre().startsWith("R")).collect(Collectors.toList());
        Assert.assertEquals(retorno.get(0), new Persona("Rodrigo", "Lauber", 32));
    }

    @Test
    public void testNombreApellido(){
        personas.stream().map(x->x.getNombre()+" "+x.getApellido()).forEach(System.out::println);
    }

    @Test
    public void testTODOSAMAYUSCULAS(){
        personas.stream().map(x->(x.getNombre()+" "+x.getApellido()).toUpperCase()).forEach(System.out::println);
    }

    @Test
    public void testEdadPromedio(){
        double edadTotal= personas.stream().map(x->x.getEdad()).reduce(0,(a,b)->a+b).doubleValue();
        double promedio = edadTotal/personas.size();
        System.out.println(promedio);
    }









    @Test
    public void testGoodiesGoodies(){
        System.out.println(personas.stream().collect(Collectors.averagingDouble(x -> x.getEdad())));
    }


}
