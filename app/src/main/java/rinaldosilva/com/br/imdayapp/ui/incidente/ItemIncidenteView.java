package rinaldosilva.com.br.imdayapp.ui.incidente;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import rinaldosilva.com.br.imdayapp.R;
import rinaldosilva.com.br.imdayapp.model.incidente.IncidenteOwner;

@EViewGroup(R.layout.item_incidente_view)
public class ItemIncidenteView extends RelativeLayout {
    @ViewById
    TextView tvData, tvName;

    public ItemIncidenteView(Context context) {
        super(context);
    }

    public ItemIncidenteView(Context context, AttributeSet attrs, TextView tvData) {
        super(context, attrs);
        this.tvData = tvData;
    }

    public void bind(IncidenteOwner owner) {
        if (!owner.getName().isEmpty() && !owner.getData().isEmpty()) {
            tvData.setText(owner.getData());
            tvName.setText(owner.getName());
        }
    }
}
