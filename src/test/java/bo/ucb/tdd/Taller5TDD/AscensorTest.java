package bo.ucb.tdd.Taller5TDD;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AscensorTest {

    Persona persona;
    Ascensor ascensor;

    // Al crear una persona, esta será situada en un piso aleatorio entre 1 y 3
    @Test
    public void crearPersonaEnPisoAleatorio(){

        System.out.println("Test Case: crearPersonaEnPisoAleatorio");

        System.out.println(persona.getPiso_origen());

        assertTrue(persona.getPiso_origen() < 4 && persona.getPiso_origen() > 0);
    }

    // Se asignará el piso destino aleatoriamente verificando que no sea el mismo que el piso origen
    @Test
    public void asignarPisoDeDestinoDePersona(){
        System.out.println("Test Case: asignarPisoDeDestinoDePersona");

        persona.setPiso_destino();

        System.out.println("Piso origen: " + persona.getPiso_origen());
        System.out.println("Piso Destino: " + persona.getPiso_destino());
        
        assertTrue(persona.getPiso_origen() < 4 && persona.getPiso_origen() > 0);
        assertNotEquals(persona.getPiso_origen(), persona.getPiso_destino());
    }

    // Al instanciar el ascensor por primera vez, este debe estar en el piso 1
    @Test
    public void primerPisoAlInicioDelDia(){
        System.out.println("Test Case: primerPisoAlInicioDelDia");

        assertEquals(1, ascensor.getPiso_origen());
    }

    // Llamada al ascensor
    @Test
    public void llamarAscensor(){
        System.out.println("Test Case: llamarAscensor");

        ascensor.llamada_ascensor(persona.getPiso_origen());

        assertTrue(ascensor.getAscensor_en_camino());
        assertEquals(persona.getPiso_origen(), ascensor.getPiso_destino());
    }

    //El ascensor recoje a la persona y la lleva a su destino
     
    @Test
    public void recogerPersona(){
        System.out.println("Test Case: recogerPersona");

        persona.setPiso_destino();

        ascensor.llamada_ascensor(persona.getPiso_origen());
        ascensor.recoger_persona(persona.getPiso_destino());

        assertTrue(ascensor.getAscensor_lleno());
        assertEquals(ascensor.getPiso_destino(), persona.getPiso_destino());
    }

    // El ascensor deja a la persona y se mueva al nuevo destino
    @Test
    public void dejarPersona(){
        System.out.println("Test Case: dejarPersona");

        persona.setPiso_destino();

        ascensor.llamada_ascensor(persona.getPiso_destino());
        ascensor.recoger_persona(persona.getPiso_destino());
        ascensor.dejar_persona();

        assertFalse(ascensor.getAscensor_lleno());
        assertEquals(ascensor.getPiso_origen(), persona.getPiso_destino());
    }
}
