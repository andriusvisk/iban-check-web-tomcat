package soap;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrius on 26/03/2017.
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface ValidateIbanInt {

    @WebMethod String validate(String ibanStr);
    @WebMethod String validateList(String[] list);

}
