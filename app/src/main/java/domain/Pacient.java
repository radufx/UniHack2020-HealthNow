package domain;

import androidx.annotation.Nullable;

import java.util.Date;
import java.util.Vector;

public class Pacient extends Object{
    private String username, parola, email, telefon, adresa, cnp;
    private String username_medic = "";
    private Date data_nasterii;

    private Vector<ConditieMedicala> conditii_medicale = new Vector<ConditieMedicala>();


    public Pacient(String username, String parola, String email,
                        String telefon, String adresa, String cnp, Date data_nasterii) {
        this.username = username;
        this.parola = parola;
        this.email = email;
        this.telefon = telefon;
        this.adresa = adresa;
        this.cnp = cnp;
        this.data_nasterii = data_nasterii;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
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

    public String getUsername_medic() {
        return username_medic;
    }

    public void setUsername_medic(String username_medic) {
        this.username_medic = username_medic;
    }

    public Vector<ConditieMedicala> getConditii_medicale() {
        return conditii_medicale;
    }

    public void add_conditie_medicala (ConditieMedicala conditie_medicala) {
        this.conditii_medicale.add(conditie_medicala);
    }

    public void delete_conditie_medicala (ConditieMedicala conditie_medicala){
        this.conditii_medicale.remove(conditie_medicala);
    }

    public Date getData_nasterii() {
        return data_nasterii;
    }

    public void setData_nasterii(Date data_nasterii) {
        this.data_nasterii = data_nasterii;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        Pacient alt_pacient = (Pacient)other;
        return this.username == alt_pacient.username;
    }
}
