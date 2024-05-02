package com.aluracursos.conversordemonedas.modelos;

public class PedirDatos {

    public String base_code;
    public String target_code;
    public String conversion_rate;

    public PedirDatos(String base_code, String target_code, String conversion_rate) {
        this.base_code = base_code;
        this.target_code = target_code;
        this.conversion_rate = conversion_rate;
    }


}
