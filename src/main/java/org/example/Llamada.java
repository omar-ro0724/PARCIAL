package org.example;

public class Llamada {
    public  TipoLlamada { LOCAL, LARGA_DISTANCIA, CELULAR }

    private final TipoLlamada tipo;
    private final int duracion;
    private final double costo;

    public Llamada(TipoLlamada tipo, int duracion) {
        this.tipo = tipo;
        this.duracion = duracion;
        this.costo = calcularCosto(tipo, duracion);
    }

    private static double calcularCosto(TipoLlamada tipo, int duracion) {
        return switch (tipo) {
            case LOCAL -> duracion * 50;
            case LARGA_DISTANCIA -> duracion * 350;
            case CELULAR -> duracion * 150;
        };
    }

    public double getCosto() { return costo; }
    public int getDuracion() { return duracion; }
    public TipoLlamada getTipo() { return tipo; }

    @Override
    public String toString() {
        return "TIPO: " + tipo + ", DURACION: " + duracion + " MIN, COSTO: $" + costo;
    }
}
