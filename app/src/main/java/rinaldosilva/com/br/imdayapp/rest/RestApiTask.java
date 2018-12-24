package rinaldosilva.com.br.imdayapp.rest;

import android.content.Context;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rinaldosilva.com.br.imdayapp.model.incidente.IncidenteOwner;
import rinaldosilva.com.br.imdayapp.ui.incidente.IncidentePresenter;
import rinaldosilva.com.br.imdayapp.utils.Utils;

@EBean
public class RestApiTask {
    private static final String URL_BASE = "http://uol.com.br";
    private static final String FILE_NAME = "data_mock.json";
    Retrofit retrofit;
    EndPointInterface endPointInterface;
    Context context;

    void config() {
        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .dispatcher(new Dispatcher())
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        String bodyMock = Utils.loadData(context, FILE_NAME);
                        Response response = new Response.Builder()
                                .code(200)
                                .protocol(Protocol.HTTP_1_0)
                                .message("Sucess")
                                .header("content-type", "application/json")
                                .request(chain.request())
                                .body(ResponseBody.create(MediaType.parse("application/json"), bodyMock))
                                .build();
                        return response;
                    }
                });


        retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();

        endPointInterface = retrofit.create(EndPointInterface.class);
    }

    @Background
    public void getIncidenteList(Context context, final IncidentePresenter incidentePresenter) {
        this.context = context;
        config();
        ;

        Call<HashMap<String, String>> call = endPointInterface.getIncidentesList();

        call.enqueue(new Callback<HashMap<String, String>>() {
            @Override
            public void onResponse(Call<HashMap<String, String>> call, retrofit2.Response<HashMap<String, String>> response) {
                if (response.isSuccessful()) {
                    List<IncidenteOwner> list = new ArrayList<>();
                    for (Map.Entry<String, String> obj : response.body().entrySet()) {
                        if (!obj.getKey().isEmpty() && !obj.getValue().isEmpty())
                            list.add(new IncidenteOwner(obj.getKey(), obj.getValue()));
                    }
                    incidentePresenter.showResult(list);
                }
            }

            @Override
            public void onFailure(Call<HashMap<String, String>> call, Throwable t) {

            }
        });
    }
}
