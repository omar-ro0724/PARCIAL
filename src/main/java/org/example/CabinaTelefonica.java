package org.example;
import java.util.ArrayList;
import java.util.List;

public class CabinaTelefonica {
    private int id;
    private List<Llamada> llamadas;

    public CabinaTelefonica(int id) {
        this.id = id;
        this.llamadas = new ArrayList<>();
    }

    public void registrarLlamada(Llamada.TipoLlamada tipo, int duracion) {
        llamadas.add(new Llamada(tipo, duracion));
    }

    public int getNumeroLlamadas() {
        return llamadas.size();
    }

    public int getDuracionTotal() {
        return llamadas.stream().mapToInt(Llamada::getDuracion).sum();
    }

    public double getCostoTotal() {
        return llamadas.stream().mapToDouble(Llamada::getCosto).sum();
    }

    public void reiniciarCabina() {
        llamadas.clear();
    }

    public int getId() { return id; }

    @Override
    public String toString() {
        return "CABINA " + id + ": " + getNumeroLlamadas() + " LLAMADAS, " + getDuracionTotal() +
                " MINUTOS, COSTO TOTAL : $" + getCostoTotal();
    }
}