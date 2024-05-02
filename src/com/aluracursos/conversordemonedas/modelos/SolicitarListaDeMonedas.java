package com.aluracursos.conversordemonedas.modelos;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SolicitarListaDeMonedas {
    public static String[] getCodigoDeMoneda() throws IOException {
        // URL de la API
        String apiUrl = "https://v6.exchangerate-api.com/v6/08850a06505587ec25364674/codes";

        // Crear objeto URL
        URL url = new URL(apiUrl);

        // Abrir conexión HTTP
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Configurar método GET
        connection.setRequestMethod("GET");

        // Obtener la respuesta de la API
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Dividir la respuesta en líneas y retornar
        return response.toString().split(",");
    }
}



