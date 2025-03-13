package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorCabina gestor = new GestorCabina();

        while (true) {
            System.out.println("MENU");
            System.out.println("1. CREAR CABINA TELEFONICA");
            System.out.println("2. REGISTRAR LLAMADA");
            System.out.println("3. MOSTRAR INFO DE UNA CABINA");
            System.out.println("4. MOSTRAR TODAS LAS CABINAS");
            System.out.println("5. REINICIAR LAS CABINAS");
            System.out.println("6. SALIR");
            System.out.print("ELIJA UNA OPCION: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    gestor.agregarCabina();
                    System.out.println("NUEVA CABINA CREADA");
                }
                case 2 -> {
                    System.out.print("INGRESE EL NUMERO DE CABINA: ");
                    int idCabina = scanner.nextInt();
                    CabinaTelefonica cabina = gestor.obtenerCabina(idCabina);

                    if (cabina == null) {
                        System.out.println("CABINA NO ENCONTRADA");
                        break;
                    }

                    System.out.println("QUE TIPO DE LLAMADA:");
                    System.out.println("1. LOCAL");
                    System.out.println("2. LARGA DISTANCIA");
                    System.out.println("3. CELULAR");
                    int tipoLlamada = scanner.nextInt();

                    System.out.print("INGRESE LA DURACION DE LA LLAMADA EN MINUTOS: ");
                    int duracion = scanner.nextInt();

                    Llamada.TipoLlamada tipo = switch (tipoLlamada) {
                        case 1 -> Llamada.TipoLlamada.LOCAL;
                        case 2 -> Llamada.TipoLlamada.LARGA_DISTANCIA;
                        case 3 -> Llamada.TipoLlamada.CELULAR;
                        default -> null;
                    };

                    if (tipo != null) {
                        cabina.registrarLlamada(tipo, duracion);
                        System.out.println("LLAMADA REGISTRADA CON EXITO");
                    } else {
                        System.out.println("OPCION NO VALIDA.");
                    }
                }
                case 3 -> {
                    System.out.print("INGRESE EL NUMERO DE CABINA: ");
                    int idInfo = scanner.nextInt();
                    CabinaTelefonica cabinaInfo = gestor.obtenerCabina(idInfo);

                    if (cabinaInfo != null) {
                        System.out.println(cabinaInfo);
                    } else {
                        System.out.println("CABINA NO ENCONTRADA.");
                    }
                }
                case 4 -> gestor.mostrarConsolidado();
                case 5 -> {
                    System.out.print("INGRESE LA CABINA QUE QUIERE REINICIAR: ");
                    int idReiniciar = scanner.nextInt();
                    CabinaTelefonica cabinaReiniciar = gestor.obtenerCabina(idReiniciar);

                    if (cabinaReiniciar != null) {
                        cabinaReiniciar.reiniciarCabina();
                        System.out.println("CABINA REINICIADA CON EXITO.");
                    } else {
                        System.out.println("CABINA NO EXISTE");
                    }
                }
                case 6 -> {
                    System.out.println("SALIENDO...");
                    return;
                }
                default -> System.out.println("NO VALIDO, VUELVA A INTENTAR.");
            }
        }
    }
}