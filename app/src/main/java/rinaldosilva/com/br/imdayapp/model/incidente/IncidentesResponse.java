package rinaldosilva.com.br.imdayapp.model.incidente;

import java.util.HashMap;

public class IncidentesResponse {
    private HashMap<String,String> listaIncidentes;

    public HashMap<String, String> getListaIncidentes() {
        return listaIncidentes;
    }

    public void setListaIncidentes(HashMap<String, String> listaIncidentes) {
        this.listaIncidentes = listaIncidentes;
    }
}
