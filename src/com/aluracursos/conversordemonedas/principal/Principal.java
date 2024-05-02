package com.aluracursos.conversordemonedas.principal;

import com.aluracursos.conversordemonedas.modelos.ConectarConAPI;

import java.io.IOException;
import java.util.Scanner;
import static com.aluracursos.conversordemonedas.modelos.SolicitarListaDeMonedas.getCodigoDeMoneda;


public class Principal{
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        while (true) {
            System.out.println("""
                    ****************************************
                    Sea bienvenido(a) al Conversor de Moneda

                    1) Dólar =>> Peso Argentino
                    2) Peso Argentino =>> Dólar
                    3) Dólar =>> Real Brasileño
                    4) Real Brasileño =>> Dólar
                    5) Dólar =>> Peso Colombiano
                    6) Peso Colombiano =>> Dólar
                    7) Otras Monedas
                    8) Salir
                    Elija una opción válida:
                    ****************************************
                    """);
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    ConectarConAPI conectarConAPI1 = new ConectarConAPI("USD", "ARS");
                    break;
                case 2:
                    ConectarConAPI  conectarConAPI2 = new ConectarConAPI("ARS", "USD");
                    break;
                case 3:
                    ConectarConAPI conectarConAPI3 = new ConectarConAPI("USD", "BRL");
                    break;
                case 4:
                    ConectarConAPI conectarConAPI4 = new ConectarConAPI("BRL", "USD");
                    break;
                case 5:
                    ConectarConAPI conectarConAPI5 = new ConectarConAPI("USD", "COP");
                    break;
                case 6:
                    ConectarConAPI conectarConAPI6 = new ConectarConAPI("COP", "USD");
                    break;
                case 7:
                    //getCurrenciesListAndConvert();
                    Scanner entrada2 = new Scanner(System.in);
                    int opcion2;
                    while (true) {
                        System.out.println("""
                            ****************************************
                            Otras Monedas
        
                            1) Lista de Otras Monedas Disponibles
                            2) Convertir a otras Monedas
                            3) Regresar al Menú Anterior
                            Elija una opción válida:
                            ****************************************
                            """);
                        opcion2 = entrada2.nextInt();
                        switch (opcion2) {
                            case 1:
                                // mostrar lista en pantalla
                                try {
                                    String[] codigoDeMoneda = getCodigoDeMoneda();
                                    System.out.println("Lista de códigos de moneda:");
                                    for (String codigo : codigoDeMoneda) {
                                        System.out.println(codigo);
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                continue;
                            case 2:
                                // conversion de otras monedas
                                System.out.println("Ingrese la primera moneda: ");
                                Scanner ingreso = new Scanner(System.in);
                                String monedaUno = ingreso.nextLine();
                                System.out.println("Ingrese la segunda moneda: ");
                                Scanner ingreso2 = new Scanner(System.in);
                                String monedaDos = ingreso2.nextLine();
                                ConectarConAPI conectarConAPI7 = new ConectarConAPI(monedaUno, monedaDos);
                                continue;
                            case 3:
                                System.out.println("Regresando al Menú Anterior");
                                break;
                            default:
                                System.out.println("Opción inválida. Por favor, elija una opción del menú.");
                                break;
                        }
                        break;
                    }
                    break;
                case 8:
                    System.out.println("Gracias por utilizar el Conversor de Moneda. ¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción del menú.");
                    break;
            }
        }

    }
}

