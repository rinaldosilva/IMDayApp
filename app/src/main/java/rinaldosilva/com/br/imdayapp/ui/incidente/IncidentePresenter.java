package rinaldosilva.com.br.imdayapp.ui.incidente;

import android.content.Context;

import java.util.HashMap;
import java.util.List;

import rinaldosilva.com.br.imdayapp.model.incidente.IncidenteModel;
import rinaldosilva.com.br.imdayapp.model.incidente.IncidenteOwner;

public class IncidentePresenter implements IncidentePresenterView.presenter {
    IncidentePresenterView.view View;
    IncidentePresenterView.model model;
    public IncidentePresenter(IncidentePresenterView.view presenterView) {
        this.View = presenterView;
        model = new IncidenteModel();
    }

    @Override
    public void getIncidenteList(Context context) {
        model.getIncidenteList(context,this);
    }

    public void showResult(List<IncidenteOwner> result){
        View.bind(result);
    }
}
