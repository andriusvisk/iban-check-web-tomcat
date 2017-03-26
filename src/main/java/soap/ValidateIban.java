package soap;

import iban.IbanCheck;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrius on 23/03/2017.
 */

@WebService(endpointInterface = "soap.ValidateIbanInt")
public class ValidateIban implements ValidateIbanInt {

    public void ValidateIban() {}

    @WebMethod
    public String validate(String ibanStr) {

        return new IbanCheck().validateIban(ibanStr).build().toString();

    }

    @WebMethod
    public String validateList(@WebParam(name = "list")final String[] list) {

        return new IbanCheck().validateList(list);

    }
}
