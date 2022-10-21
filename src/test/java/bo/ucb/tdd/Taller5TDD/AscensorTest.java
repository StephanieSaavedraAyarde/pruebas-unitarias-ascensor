package test.java.bo.ucb.tdd.Taller5TDD;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ucb.tdd.test.Ascensor;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AscensorTest {

    private Ascensor ascensor;

    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Before
    public void before(){
        ascensor = new Ascensor();
    }

    // Al crear una persona, esta será situada en un piso aleatorio entre 1 y 3

    @Test
    public void crearPersonaEnPisoAleatorio() throws Exception{
        System.out.println("Test Case crearPersonaEnPisoAleatorio");

        // 1. Preparación de la prueba
        System.out.println("======================================" + ascensor);

        // 2. Lógica de la prueba
        Persona persona = ascensor.crearPersona();

        // 3. Verificación (Assert)
        assertNotNull(persona);
    }

    /***
     * Segun la logica utilizada para este caso, se sabe que se crea un asensor al inicio del
     * dia. Por lo que, al momento de instanciar un nuevo ascensor, este debe estar situado
     * en el piso uno.
     */
    @Test
    public void puertaEnPrimerPisoAlInicioDelDia(){
        System.out.println();
        System.out.println("============================================");
        System.out.println("Testing puertaEnPrimerPisoAlInicioDelDia...");
        System.out.println();

        // 1. Preparacion de la prueba
        Ascensor a;

        // 2. Logica de la prueba
        a = new Ascensor();

        // 3. Verificacion (Assert)
        assertEquals(1, a.getPiso());

        System.out.println("============================================");
    }

    /***
     * El metodo .recibirLlamada() simula el apretar el boton por parte de la persona
     */
    @Test
    public void apretarBotonDeLlamada(){
        System.out.println();
        System.out.println("============================================");
        System.out.println("Testing apretarBotonDeLlamada...");
        System.out.println();

        // 1. Preparacion de la prueba
        Ascensor ascensor;
        Persona persona;

        // 2. Logica de la prueba
        ascensor = new Ascensor();
        persona = new Persona();
        ascensor.recibirLlamada(persona.getPiso());

        // 3. Verificacion (Assert)
        assertTrue(ascensor.estaEnCamino());
        assertEquals(persona.getPiso(), ascensor.getDestino());

        System.out.println("============================================");
    }

    /***
     * El metodo .recogerPersona() hace que el ascensor recoja a la persona y obtenga su destino
     */
    @Test
    public void recogerPersona(){
        System.out.println();
        System.out.println("============================================");
        System.out.println("Testing recogerPersona...");
        System.out.println();

        // 1. Preparacion de la prueba
        Ascensor ascensor;
        Persona persona;

        // 2. Logica de la prueba
        persona = new Persona();
        persona.setDestino();

        ascensor = new Ascensor();
        ascensor.recibirLlamada(persona.getPiso());
        ascensor.recogerPersona(persona.getDestino());

        // 3. Verificacion (Assert)
        assertTrue(ascensor.estaLleno());
        assertEquals(ascensor.getDestino(), persona.getDestino());

        System.out.println("============================================");
    }

    /***
     * El metodo .dejarPersona() hace que el ascensor se mueva al destino y deje a la persona
     */
    @Test
    public void dejarPersona(){
        System.out.println();
        System.out.println("============================================");
        System.out.println("Testing dejarPersona...");
        System.out.println();

        // 1. Preparacion de la prueba
        Ascensor ascensor;
        Persona persona;

        // 2. Logica de la prueba
        persona = new Persona();
        persona.setDestino();

        ascensor = new Ascensor();
        ascensor.recibirLlamada(persona.getPiso());
        ascensor.recogerPersona(persona.getDestino());
        ascensor.dejarPersona();

        // 3. Verificacion (Assert)
        assertFalse(ascensor.estaLleno());
        assertEquals(ascensor.getPiso(), persona.getDestino());

        System.out.println("============================================");
    }
}
