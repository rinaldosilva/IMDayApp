package rinaldosilva.com.br.imdayapp.ui.incidente;

import android.content.Context;

import java.util.HashMap;
import java.util.List;

import rinaldosilva.com.br.imdayapp.model.incidente.IncidenteOwner;
import rinaldosilva.com.br.imdayapp.model.incidente.IncidentesResponse;

public interface IncidentePresenterView {
    interface view{
        void bind(List<IncidenteOwner> incidenteList);
    }

    interface presenter{
        void getIncidenteList(Context context);
    }

    interface model{
        void getIncidenteList(Context context,IncidentePresenter incidentePresenter);
    }

}
