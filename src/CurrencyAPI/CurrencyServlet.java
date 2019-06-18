package CurrencyAPI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//wersja wykorzystujaca API
@WebServlet("/currency")
public class CurrencyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetRateAction getRateAction = new GetRateAction();
        float amount = Float.parseFloat(req.getParameter("value"));
        String currencyIn = req.getParameter("actionIN");
        String currencyOut = req.getParameter("actionOUT");
        CurrencyConversion currencyConversion = CurrencyConversion.getCurrency(currencyIn, currencyOut);
        Rate rate = getRateAction.getCurrentRate(currencyConversion.currencyIn, currencyConversion.currencyOut);
        float result = amount * rate.rates.get(currencyConversion.currencyOut);
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(result);
    }
}
