package business;

import java.util.Date;

import domain.ConditieMedicala;
import domain.Medic;
import domain.Pacient;
import infrastructura.repositoryMedic;
import validatori.validatorMedic;

public class serviceMedic {
    private repositoryMedic repo_medici;
    private validatorMedic validator_medici;

    public serviceMedic(repositoryMedic repo_medici, validatorMedic validator_medici) {
        this.repo_medici = repo_medici;
        this.validator_medici = validator_medici;
    }

    public void adaugare_medic (String username, String parola, String email,
                                String telefon, String adresa, String cnp,
                                String Prenume, String Nume) throws Exception {
        this.validator_medici.validate(username,parola, email, telefon,
                adresa, cnp, Prenume, Nume);
        Medic medic = new Medic(username,parola, adresa, telefon,
                email, cnp, Prenume, Nume);
        this.repo_medici.adauga_medic(medic);
    }

    public void stergere_medic (String username) throws Exception {
        Medic medic = this.repo_medici.cauta_medic(username);
        this.repo_medici.sterge_medic(medic);
    }

    public void modifica_medic (String username, String parola, String email,
                                String telefon, String adresa, String cnp,
                                String Prenume, String Nume) throws Exception {
        this.validator_medici.validate(username,parola, email, telefon,
                adresa, cnp, Prenume, Nume);
        Medic medic = new Medic(username,parola, adresa, telefon,
                email, cnp, Prenume, Nume);
        this.repo_medici.modifica_medic(medic);
    }

    public Medic cauta_medic (String username) throws Exception {
        Medic medic = this.repo_medici.cauta_medic(username);
        return medic;
    }

    public void modifica_conditie_medicala (String username, String username_pacient, int index,
                                            servicePacient srv_pacient, String tratament) throws Exception {
        Medic medic = this.cauta_medic(username);
        Pacient pacient = srv_pacient.cauta_pacient(username_pacient);
        pacient.getConditii_medicale().get(index).setTratament(tratament);

    }

    public int get_size (){
        return this.repo_medici.size();
    }

}
