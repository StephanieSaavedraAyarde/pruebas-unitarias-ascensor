package main.java.bo.ucb.tdd.Taller5TDD;

import java.util.Random;

public class Persona {

    private int piso_origen;
    private int piso_destino;

    public Persona(int piso_origen, int piso_destino) {
        this.piso_origen = piso_origen;
        this.piso_destino = piso_destino;
    }

    public Persona(int piso_origen) throws Exception{
        this.piso_origen = piso_origen;

        if(piso_destino > 3 || piso_destino < 1){
            throw new Exception(" No existen esos pisos en el edificio");
        }

        while(piso_destino == piso_origen){
            piso_destino = (int) (Math.random() * (3 - 1 + 1) + 1);
            System.out.println("La persona se encuentra en el piso #" + piso_destino);
        }
    }

    public int getPiso_origen(){
        return piso_origen;
    }

    public void setPiso_origen(int piso_origen) {
        this.piso_origen = piso_origen;
    }
    
    public int getPiso_destino() {
        return piso_destino;
    }

    public void setDestino(int piso_destino){
        this.piso_destino = piso_destino;
    }
    
}
