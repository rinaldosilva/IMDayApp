package rinaldosilva.com.br.imdayapp.ui.splash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import rinaldosilva.com.br.imdayapp.ui.incidente.IncidenteActivity_;
import rinaldosilva.com.br.imdayapp.R;
import rinaldosilva.com.br.imdayapp.ui.incidente.IncidenteActivity;

@EActivity(R.layout.activity_splash)
public class SplashActivity extends AppCompatActivity implements SplashPresenterView.view {
    @ViewById
    ImageView ivLogo;

    private SplashPresenterView.presenter presenter;

    @AfterViews
    void init() {
        Glide.with(this).load(R.drawable.splash_logo).into(ivLogo);
        presenter = new SplashPresenter(this);
        presenter.showIncidentes();
    }

    @Override
    public void openListagem() {
        IncidenteActivity_.intent(this).start();
        finish();
    }
}
