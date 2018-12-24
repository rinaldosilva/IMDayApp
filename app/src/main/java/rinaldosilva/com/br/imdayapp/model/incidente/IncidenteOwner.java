package rinaldosilva.com.br.imdayapp.model.incidente;

public class IncidenteOwner {
    private String data,name;

    public IncidenteOwner(String data, String name) {
        this.data = data;
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
