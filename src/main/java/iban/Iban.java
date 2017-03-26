package iban;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Created by andrius on 23/03/2017.
 */
public class Iban {

    private static final Logger LOGGER = Logger.getLogger(Iban.class.getName());

    private String ibanString = null;
    private CountryDesc countryDesc = null;

    private ArrayList<String> errors = new ArrayList<String>();

    public Iban(String ibanString) {
        if (ibanString != null) {
            this.ibanString = ibanString.replaceAll("\\s", "");
            try {
                countryDesc = CountryDesc.valueOf(getCountryCode().toUpperCase());

                if ((countryDesc.getCheckDigistsAllways().length() > 0)&&(countryDesc.getCheckDigistsAllways().compareTo(getCheckDigits())!=0)) {
                    errors.add("Check digits are invalid");
                }
            } catch (IllegalArgumentException e) {
                errors.add("Country is invalid");
            }
        }
    }

    public void addError(String error) {
        errors.add(error);
    }

    public String getCountryCode() {
        return ibanString.substring(0, 2);
    }

    public String getCheckDigits() {
        return ibanString.substring(2, 4);
    }

    public String getBban() {
        return ibanString.substring(4, ibanString.length());
    }

    public int getLength() {
        return ibanString.length();
    }

    public String getIbanString() {
        return ibanString;
    }

    public CountryDesc getCountryDesc() {
        return countryDesc;
    }

    public ArrayList<String> getErrors() {
        return errors;
    }
}
