package domain;

public class ConditieMedicala extends Object {
    private String username_pacient, username_medic, descriere, tratament;
    private int id;

    public ConditieMedicala(String username_pacient, String username_medic, String descriere, String tratament) {
        this.username_pacient = username_pacient;
        this.username_medic = username_medic;
        this.descriere = descriere;
        this.tratament = tratament;
    }

    public String getUsername_pacient() {
        return username_pacient;
    }

    public void setUsername_pacient(String username_pacient) {
        this.username_pacient = username_pacient;
    }

    public String getUsername_medic() {
        return username_medic;
    }

    public void setUsername_medic(String username_medic) {
        this.username_medic = username_medic;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public String getTratament() {
        return tratament;
    }

    public void setTratament(String tratament) {
        this.tratament = tratament;
    }

}
