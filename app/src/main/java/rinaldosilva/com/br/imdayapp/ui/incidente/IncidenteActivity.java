package rinaldosilva.com.br.imdayapp.ui.incidente;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.HashMap;
import java.util.List;

import rinaldosilva.com.br.imdayapp.R;
import rinaldosilva.com.br.imdayapp.model.incidente.IncidenteOwner;
import rinaldosilva.com.br.imdayapp.model.incidente.IncidentesResponse;
import rinaldosilva.com.br.imdayapp.ui.incidente.adapter.IncidenteAdapter;
import rinaldosilva.com.br.imdayapp.ui.sobre.SobreActivity_;

@EActivity(R.layout.activity_incidente_drawer)
public class IncidenteActivity extends AppCompatActivity implements IncidentePresenterView.view, NavigationView.OnNavigationItemSelectedListener {
    @ViewById
    RecyclerView recyclerView;

    private IncidenteAdapter incidenteAdapter;

    RecyclerView.LayoutManager layoutManager;

    private IncidentePresenterView.presenter presenter;

    @ViewById
    DrawerLayout drawerLayout;

    @ViewById
    NavigationView navegationView;

    @AfterViews
    void init() {
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        presenter = new IncidentePresenter(this);

        presenter.getIncidenteList(this);

        navegationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.msg_open, R.string.msg_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public void bind(List<IncidenteOwner> incidenteList) {
        incidenteAdapter = new IncidenteAdapter(this, incidenteList);
        recyclerView.setAdapter(incidenteAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.btn_drawer) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.sobre) {
            SobreActivity_.intent(this).start();
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
        if (item.getItemId() == R.id.lista) {
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }
}
