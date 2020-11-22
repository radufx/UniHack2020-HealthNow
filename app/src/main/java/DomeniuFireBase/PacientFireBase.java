package DomeniuFireBase;


import java.util.Date;
import java.util.Vector;

public class PacientFireBase {
    private String nume, prenume, adresa, data_nasterii, cnp;

    private Vector<ConditieFireBase> conditii = new Vector<ConditieFireBase>();

    public PacientFireBase(){

    }

    public PacientFireBase(String nume, String prenume, String adresa, String data_nasterii, String cnp){
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.data_nasterii = data_nasterii;
        this.cnp = cnp;
    }

    public void adaugare_conditie (ConditieFireBase Conditie){
        this.conditii.add(Conditie);
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getData_nasterii() {
        return data_nasterii;
    }

    public void setData_nasterii(String data_nasterii) {
        this.data_nasterii = data_nasterii;
    }
}
