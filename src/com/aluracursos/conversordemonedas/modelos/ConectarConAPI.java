package com.aluracursos.conversordemonedas.modelos;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class ConectarConAPI {

    String moneda1;
    String moneda2;


    public ConectarConAPI(String moneda1, String moneda2) throws IOException, InterruptedException {
        String direccion = "https://v6.exchangerate-api.com/v6/08850a06505587ec25364674/pair/"+moneda1+"/"+moneda2;

        HttpClient client = HttpClient.newHttpClient();         //se hace el request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client          //permite acceder al cuerpo de la respuesta
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new Gson();
        PedirDatos miPedirDatos = gson.fromJson(json, PedirDatos.class);

        Scanner teclado = new Scanner(System.in);               //capturamos por teclado el monto a convertir y lo transformamos a float
        System.out.println("Ingrese el Monto a Convertir: ");
        float montoAConvertir = teclado.nextFloat();
        float tipoDeCambio = Float.parseFloat(miPedirDatos.conversion_rate);    //tomamos del json el tipo de cambio y lo convertimos a float
        float montoConvertido = montoAConvertir * tipoDeCambio;


        System.out.println("La Primera Moneda es: "+miPedirDatos.base_code);
        System.out.println("La Segunda Moneda es: "+miPedirDatos.target_code);
        System.out.println("El Tipo de Cambio es: "+miPedirDatos.conversion_rate);
        System.out.println("El Monto Convertido es: "+montoConvertido);
    }


}
