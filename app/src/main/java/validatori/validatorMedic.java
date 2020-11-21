package validatori;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validatorMedic {

    public void validate (String username, String parola, String email,
                          String telefon, String adresa, String cnp,
                          String Prenume, String Nume) throws Exception {
        String errors = "";

        errors += valid_usernamee(username);
        errors += valid_numee(Prenume, Nume);
        errors += valid_parolaa(parola);
        errors += valid_adresaa(adresa);
        errors += valid_telefonn(telefon);
        errors += valid_emaill(email);
        errors += valid_cnpp(cnp);

        if (errors.length() > 0) throw new Exception(errors);

    }

    public String valid_numee (String Prenume, String Nume){
        String s = "";
        if (Prenume == "" || Nume == "")
            s = "Nume/prenume invalid!\n";
        return s;
    }

    public String valid_usernamee (String username){
        String s = "";
        if (username == "")
            s = "Username invalid!\n" ;
        return s;
    }

    public String valid_parolaa (String parola){
        String s = "";
        if (parola == "")
            s = "Username invalid!\n" ;
        return s;
    }

    public String valid_emaill (String email){
        String s = "";
        String regex = "^[a-zA-Z0-9_+&*-] + (?:\\\\.[a-zA-Z0-9_+&*-]\n" +
                "+ )*@(?:[a-zA-Z0-9-]+\\\\.) + [a-zA-Z]{2,7}";
        if (!email.matches(regex)) s =  "Adresa e-mail invalida!\n";
        return s;
    }

    public String valid_telefonn (String telefon){
        String s = "";
        Pattern pattern = Pattern.compile("^(\\d{3}[- .]?){2}\\d{4}$");
        Matcher matcher = pattern.matcher(telefon);
        if (matcher.matches() == false) s = "Numar de telefon invalid!\n";
        return s;
    }

    public String valid_adresaa (String adresa){
        String s = "";
        if (adresa.length() == 0) s = "Adresa invalida!\n";
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
