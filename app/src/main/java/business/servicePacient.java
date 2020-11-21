package business;

import java.util.Date;

import infrastructura.repositoryPacient;
import validatori.validatorPacient;

public class servicePacient {
    private repositoryPacient repo_pacienti;
    private validatorPacient validator_pacienti;

    public servicePacient (repositoryPacient repo_pacienti, validatorPacient validator_pacienti){
        this.repo_pacienti = repo_pacienti;
        this.validator_pacienti = validator_pacienti;
    }

    public void adaugare_pacient (String username, String parola, String email,
                                  String telefon, String adresa, String cnp, Date data_nasterii){

    }
}
