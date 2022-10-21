package bo.ucb.tdd.Taller5TDD;

import java.util.Random;

public class Ascensor {

    Random r = new Random();
    private int piso_origen; 
    private int piso_destino;
    private boolean ascensor_en_camino = false; 
    private boolean ascensor_lleno = false; 

    public Ascensor(){
        piso_origen = 1;
    }

    public void llamada_ascensor(int destino){
        ascensor_en_camino = true;
        piso_destino = destino;
    }
     
    public void recoger_persona(int nuevo_destino){
        ascensor_en_camino = true;
        ascensor_lleno = true;
        piso_origen = piso_destino;
        piso_destino = nuevo_destino;
    }
     
    public void dejar_persona(){
        ascensor_en_camino = false;
        ascensor_lleno = false;
        piso_origen = piso_destino;
    }
   
    public Persona crearPersona() throws Exception{ 
        return new Persona();
    }

    public int getPiso_origen(){
        return piso_origen;
    }

    public void setPiso_origen(int piso_origen) {
        this.piso_origen = piso_origen;
    }

    public int getPiso_destino(){
        return piso_destino;
    }

    public void setPiso_destino(int piso_destino) {
        this.piso_destino = piso_destino;
    }

    public boolean getAscensor_en_camino(){
        return ascensor_en_camino;
    }

    public void setAscensor_en_camino(boolean ascensor_en_camino) {
        this.ascensor_en_camino = ascensor_en_camino;
    }

    public boolean getAscensor_lleno(){
        return ascensor_lleno;
    }

    public void setAscensor_lleno(boolean ascensor_lleno) {
        this.ascensor_lleno = ascensor_lleno;
    }    
}
