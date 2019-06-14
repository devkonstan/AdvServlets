package Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addate")
public class addDateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String day = req.getParameter("day");
        String month = req.getParameter("month");
        String year = req.getParameter("year");
        Date date = new Date(day, month, year);
        HttpSession httpSession = req.getSession(true);
        httpSession.setAttribute("date", date);
        resp.getWriter().println("Saved to session! " + date);
    }
}
