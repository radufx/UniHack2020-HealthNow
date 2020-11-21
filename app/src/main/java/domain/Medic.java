package domain;

import androidx.annotation.Nullable;

import java.util.Vector;

public class Medic extends Object {
    private String username, parola, adresa, telefon, email, cnp;
    private Vector<String> username_pacienti = new Vector<String>();

    private Vector<ConditieMedicala> conditii_medicale = new Vector<ConditieMedicala>();

    public Medic(String username, String parola, String adresa, String telefon, String email, String cnp) {
        this.username = username;
        this.parola = parola;
        this.adresa = adresa;
        this.telefon = telefon;
        this.email = email;
        this.cnp = cnp;
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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public Vector<String> getUsername_pacienti() {
        return username_pacienti;
    }

    public void add_username_pacient (String username_pacient){
        this.username_pacienti.add(username_pacient);
    }

    public void delete_username_pacient (String username_pacient){
        this.username_pacienti.remove(username_pacient);
    }

    public void add_conditie_medicala (ConditieMedicala conditie_medicala){
        this.conditii_medicale.add(conditie_medicala);
    }

    public void delete_conditie_medicala (ConditieMedicala conditie_medicala){
        this.conditii_medicale.remove(conditie_medicala);
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        Medic alt_medic = (Medic)obj;
        return super.equals(this.username.equals(alt_medic.username));
    }
}
