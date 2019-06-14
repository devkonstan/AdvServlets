package Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//przechowuje tylko 1 (aktualnego) uzytkownika
@WebServlet("/adduser")
public class SaveToSessionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = new User(name, surname, email, password);
        HttpSession httpSession = req.getSession(true);
        httpSession.setAttribute("user", user);
        resp.getWriter().println("Saved to session!" + user);
    }
}
