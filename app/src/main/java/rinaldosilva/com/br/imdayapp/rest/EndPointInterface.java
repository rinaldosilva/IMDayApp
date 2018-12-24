package rinaldosilva.com.br.imdayapp.rest;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import rinaldosilva.com.br.imdayapp.model.incidente.IncidentesResponse;

public interface EndPointInterface {
    @GET("/")
    Call<HashMap<String,String>> getIncidentesList();
}
