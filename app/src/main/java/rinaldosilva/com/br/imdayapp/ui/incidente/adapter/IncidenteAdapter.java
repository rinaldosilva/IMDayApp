package rinaldosilva.com.br.imdayapp.ui.incidente.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.List;

import rinaldosilva.com.br.imdayapp.model.incidente.IncidenteOwner;
import rinaldosilva.com.br.imdayapp.ui.incidente.ItemIncidenteView;
import rinaldosilva.com.br.imdayapp.ui.incidente.ItemIncidenteView_;

public class IncidenteAdapter extends RecyclerView.Adapter<IncidenteAdapter.ViewHolder> {
    private List<IncidenteOwner> incidenteList;
    private Context context;
    public IncidenteAdapter(Context context,List<IncidenteOwner> incidenteList) {
        this.incidenteList = incidenteList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemIncidenteView item = ItemIncidenteView_.build(context);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.itemIncidenteView.bind(incidenteList.get(position));
    }

    @Override
    public int getItemCount() {
        return incidenteList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemIncidenteView itemIncidenteView;
        public ViewHolder(@NonNull ItemIncidenteView itemIncidenteView) {
            super(itemIncidenteView);
            this.itemIncidenteView = itemIncidenteView;
        }
    }
}
