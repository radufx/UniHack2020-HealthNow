package ValidatoriFireBase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class validatorMedicFireBase {

    public void validate (String nume, String prenume, String cnp, String telefon) throws Exception {
        String errors = "";

        errors += valid_numee(nume);
        errors += valid_telefonn(telefon);
        errors += valid_prenumee(prenume);
        errors += valid_cnpp(cnp);

        if (errors.length() > 0) throw new Exception(errors);

    }

    public String valid_numee (String Nume){
        String s = "";
        if (Nume == "")
            s = "Nume invalid!\n";
        return s;
    }

    public String valid_prenumee (String Prenume){
        String s = "";
        if (Prenume == "")
            s = "Prenume invalid!\n";
        return s;
    }

    public String valid_telefonn (String telefon){
        String s = "";
        Pattern pattern = Pattern.compile("^(\\d{3}[- .]?){2}\\d{4}$");
        Matcher matcher = pattern.matcher(telefon);
        if (matcher.matches() == false) s = "Numar de telefon invalid!\n";
        return s;
    }

    public String valid_cnpp (String cnp) {
        String s = "";
        if (cnp.length() != 13) s = "Cnp invalid!\n";
        else {
            if (cnp.matches("[0-9]+") == false) s = "Cnp invalid!\n";
            else {
                if (cnp.charAt(0) <= '0' && cnp.charAt(0) > '6') s = "Cnp invalid!\n";
                else {
                    int sum = 0, cc;
                    int[] a = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
                    for (int i = 0; i < 13; ++i) {
                        sum += (cnp.charAt(i) - '0') * a[i];
                    }
                    if (sum % 11 <= 10) cc = sum % 11;
                    else cc = 1;
                    if (cc + '0' != cnp.charAt(12)) s = "Cnp invalid!\n";

                }
            }
        }
        return s;
    }

}
