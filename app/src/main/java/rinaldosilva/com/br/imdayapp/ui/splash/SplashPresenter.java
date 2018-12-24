package rinaldosilva.com.br.imdayapp.ui.splash;

import android.os.Handler;

public class SplashPresenter implements SplashPresenterView.presenter {

    SplashPresenterView.view splashPesenterView;

    public SplashPresenter(SplashPresenterView.view splashPesenterView) {
        this.splashPesenterView = splashPesenterView;
    }

    @Override
    public void showIncidentes() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                splashPesenterView.openListagem();
            }
        }, 2000);

    }
}
