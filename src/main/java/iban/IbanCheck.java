package iban;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.QueryParam;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by andrius on 22/03/2017.
 */
public class IbanCheck {

    private static final Logger LOGGER = Logger.getLogger(IbanCheck.class.getName());

    private final BigDecimal BD97 = new BigDecimal(97);

    public Iban validate(Iban iban) {

        if (iban.getCountryDesc() != null) {

            if (iban.getLength() == iban.getCountryDesc().getLength()) {

                String[] format = iban.getCountryDesc().getBbanFormat().split(",");

                // BBAN format check

                int counter = 0;
                boolean valid = true;
                for (String formatas : format) {
                    String ch = formatas.substring(formatas.length() - 1);
                    int count = Integer.parseInt(formatas.substring(0, formatas.length() - 1));
                    String testingInterval = iban.getBban().substring(counter, counter + count);
                    switch (ch) {
                        case "a":
                            if (!isAlphaCharacters(testingInterval)) {
                                valid = false;
                            }
                            counter = counter + count;
                            break;
                        case "n":
                            if (!isNumericCharacters(testingInterval)) {
                                valid = false;
                            }
                            counter = counter + count;
                            break;
                        case "c":
                            if (!isMixedCharacters(testingInterval)) {
                                valid = false;
                            }
                            counter = counter + count;
                            break;
                    }
                    if (!valid) {
                        iban.addError("Bad BBAN format");
                        break;
                    }
                }

                // Check digits test

                String rearrangedIban = iban.getBban() + iban.getCountryCode() + iban.getCheckDigits();

                StringBuilder sb = new StringBuilder(rearrangedIban);

                for (int i = 0; i < sb.length(); i++) {
                    char ch = sb.charAt(i);
                    ch = Character.toUpperCase(ch);
                    if (ch >= 'A' && ch <= 'Z') {
                        sb.deleteCharAt(i);
                        String s = Integer.toString(ch - 'A' + 10);
                        sb.insert(i, s);
                    }
                }

                if (new BigDecimal(sb.toString()).remainder(BD97).intValue() != 1) {
                    iban.addError("Check digit test did not passed");
                }

            } else {
                iban.addError("Length is invalid");
            }
        }

        return iban;
    }

    public boolean isAlphaCharacters(String str) {
        return str.matches("[A-Z]+");
    }

    public boolean isNumericCharacters(String str) {
        return str.matches("[0-9]+");
    }

    public boolean isMixedCharacters(String str) {
        return str.matches("[A-Z0-9]+");
    }

    public String validateList(final String[] list) {

        JsonArrayBuilder jsonArray = Json.createArrayBuilder();

        for (String ibanStr : list) {
            jsonArray.add(validateIban(ibanStr));
        }
        return jsonArray.build().toString();
    }

    public javax.json.JsonObjectBuilder validateIban(String ibanStr) {
        Iban iban = new Iban(ibanStr); //MK07250120000058984
        iban = validate(iban);
        if (iban.getErrors().size() == 0) {
            return Json.createObjectBuilder()
                    .add("iban", iban.getIbanString())
                    .add("valid", true);
        } else {

            JsonObjectBuilder jsonBuilder = Json.createObjectBuilder()
                    .add("iban", iban.getIbanString()).add("errors", getErrorsInJson(iban));
            return jsonBuilder;
        }
    }

    private JsonArrayBuilder getErrorsInJson(Iban iban){
        JsonArrayBuilder jsonArray = Json.createArrayBuilder();
        for(String error:iban.getErrors()){
            jsonArray.add(error);
        }
        return jsonArray;
    }

}
