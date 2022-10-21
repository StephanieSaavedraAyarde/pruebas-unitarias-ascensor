package test.java.bo.ucb.tdd.Taller5TDD;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PersonaTest {

    private Ascensor ascensor;

    /***
     * El metodo .setDestino() creara numeros aleatorios hasta que sean diferentes
     * del piso actual
     */
    @Test
    public void obtenerPisoDeDestinoDePersona(){
        System.out.println();
        System.out.println("======================================");
        System.out.println("Testing obtenerPisoDeDestinoDePersona...");
        System.out.println();

        // 1. Preparacion de la prueba
        Persona p;

        // 2. Logica de la prueba
        p = new Persona();
        p.setDestino();

        // 3. Verificacion (Assert)
        System.out.println("Piso actual: " + p.getPiso());
        System.out.println("Destino: " + p.getDestino());
        assertTrue(p.getPiso() < 4 && p.getPiso() > 0);
        assertNotEquals(p.getPiso(), p.getDestino());

        System.out.println("======================================");
    }
}
