package Testare;

import android.icu.util.LocaleData;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import domain.Pacient;
import infrastructura.repositoryPacient;

public class TesteRepoPacienti {
    public static void main (String[] args){
        repositoryPacient repo_pacienti = new repositoryPacient();
        assert repo_pacienti.get_all().size() == 0;
        Date data = new GregorianCalendar(2014, Calendar.SEPTEMBER, 10).getTime();
        Pacient pacient = new Pacient("1", "2", "3", "4", "5", "6", data);
        assert pacient.getUsername() == "1";
        assert pacient.getAdresa() == "5";
        assert pacient.getParola() == "2";
        assert pacient.getCnp() == "6";
        assert pacient.getEmail() == "3";
        assert pacient.getTelefon() == "4";
        assert pacient.getData_nasterii() == data;
        Pacient alt_pacient = new Pacient("1", "3", "4", "5", "6", "7", data);
        System.out.println(alt_pacient.equals(pacient));
        try{
            repo_pacienti.adauga_pacient(pacient);
        }
        catch (Exception e){

        }
        try{
            repo_pacienti.modifica_pacient(alt_pacient);
        }
        catch (Exception e){

        }

        try{
            repo_pacienti.sterge_pacient(pacient);
        }
        catch (Exception e){

        }
        try{
            repo_pacienti.sterge_pacient(pacient);
        }
        catch (Exception e){
        }
    }

}
