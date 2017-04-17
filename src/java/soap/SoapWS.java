package soap;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
   @WebService(serviceName = "SOAP")
public class SoapWS {

    private final String _usr = "2015090632";
    private final String _psw = "RIOS";

    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "usr") String usr, @WebParam(name = "psw") String psw) {
        return new Boolean(usr.equals(_usr) && psw.equals(_psw)).toString();
    }
    
    @WebMethod(operationName = "calculadora")
    public String calculadora(@WebParam(name = "num1") String num1, @WebParam(name = "num2") String num2, @WebParam(name = "operacion") String operacion){
        Double res = new Double(0.00);
        switch(operacion)
        {
            case "+":
                res = new Double(num2) + new Double(num1);
                break;
            case "-":
                res = new Double(num2) - new Double(num1);
                break;
            case "*":
                res = new Double(num2) * new Double(num1);
                break;
            case "/":
                res = new Double(num1) / new Double(num2);
                break;
            case "euro":
                res = new Double(num1) * 0.0506699;
                break;
            case "dolar":
                res = new Double(num1) * 0.05379;
            default:
                res = 0.0;
                break;
        }
        return res.toString();
    }
}
