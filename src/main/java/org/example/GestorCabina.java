package org.example;

import java.util.ArrayList;
import java.util.List;

public class GestorCabina {
    private List<CabinaTelefonica> cabinas;

    public GestorCabina() {
        this.cabinas = new ArrayList<>();
    }

    public void agregarCabina() {
        cabinas.add(new CabinaTelefonica(cabinas.size() + 1));
    }

    public CabinaTelefonica obtenerCabina(int id) {
        return (id > 0 && id <= cabinas.size()) ? cabinas.get(id - 1) : null;
    }

    public void mostrarConsolidado() {
        int totalLlamadas = 0, totalMinutos = 0;
        double totalCosto = 0;

        for (CabinaTelefonica cabina : cabinas) {
            totalLlamadas += cabina.getNumeroLlamadas();
            totalMinutos += cabina.getDuracionTotal();
            totalCosto += cabina.getCostoTotal();
        }

        System.out.println(" CONSOLIDADO TOTAL ");
        System.out.println("TOTAL LLAMADAS: " + totalLlamadas);
        System.out.println("DURACION TOTAL: " + totalMinutos + " MIN");
        System.out.println("COSTO TOTAL: $" + totalCosto);
        System.out.println(".");
    }

    public List<CabinaTelefonica> getCabinas() {
        return cabinas;
    }
}