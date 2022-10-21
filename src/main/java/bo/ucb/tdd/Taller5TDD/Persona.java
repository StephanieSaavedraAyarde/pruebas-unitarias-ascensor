package bo.ucb.tdd.Taller5TDD;

public class Persona {

    private int piso_origen;
    private int piso_destino;

    public Persona() throws Exception{
        piso_origen = (int) (Math.random()*(3-1+1)+1);
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

    public void setPiso_destino(){
        do {
            piso_destino = (int) (Math.random() * (3 - 1 + 1) + 1);
            System.out.println("La persona se encuentra en el piso #" + piso_destino);
        } while(piso_destino == piso_origen);
    }
    
}
