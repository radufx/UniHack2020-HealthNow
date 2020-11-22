package ValidatoriFireBase;

import java.util.Date;

public class validatorPacientFireBase {

    public void validate (String nume, String prenume, String adresa, String cnp){
        String errors = "";

        errors += valid_numee(nume);
        errors += valid_prenumee(prenume);
        errors += valid_adresaa(adresa);
        errors += valid_cnpp(cnp);
    }

    public String valid_numee(String Nume) {
        String s = "";
        if(Nume == "" || Nume.matches("[a-zA-Z\\s,.]+") == false)
            s = "Nume invalid!\n";
        return s;
    }

    public String valid_prenumee(String Prenume) {
        String s = "";
        if(Prenume == "" || Prenume.matches("[a-zA-Z\\s,.]+") == false)
            s = "Prenume invalid!\n";
        return s;
    }

    public String valid_adresaa(String Adresa) {
        String s = "";
        if(Adresa == "" || Adresa.matches("[a-zA-Z0-9\\s,.]+") == false)
            s = "Adresa invalida!\n";
        return s;
    }

    public String valid_cnpp(String Cnp) {
        String s = "";
        if (Cnp.length() != 13)
            s = "Cnp invalid!\n";
        else {
            if (Cnp.matches("[0-9]+") == false) s = "Cnp invalid!\n";
            else {
                if (Cnp.charAt(0) <= '0' && Cnp.charAt(0) > '6')
                    s = "Cnp invalid!\n";
                else {
                    int sum = 0, cc;
                    int[] a = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
                    for (int i = 0; i < 13; ++i)
                        sum += (Cnp.charAt(i) - '0') * a[i];
                    if (sum % 11 <= 10)
                        cc = sum % 11;
                    else
                        cc = 1;
                    if (cc + '0' != Cnp.charAt(12))
                        s = "Cnp invalid!\n";

                }
            }
        }
        return s;
    }

}
