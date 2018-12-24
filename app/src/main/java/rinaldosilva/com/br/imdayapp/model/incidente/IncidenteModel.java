package rinaldosilva.com.br.imdayapp.model.incidente;

import android.content.Context;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.HashMap;

import rinaldosilva.com.br.imdayapp.rest.RestApiTask;
import rinaldosilva.com.br.imdayapp.ui.incidente.IncidentePresenter;
import rinaldosilva.com.br.imdayapp.ui.incidente.IncidentePresenterView;

@EBean
public class IncidenteModel implements IncidentePresenterView.model{

    @Override
    public void getIncidenteList(Context context,IncidentePresenter incidentePresenter) {
        new RestApiTask().getIncidenteList(context,incidentePresenter);
    }
}
