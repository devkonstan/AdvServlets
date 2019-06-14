package Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//wystarczy podac sciezke z ta nazwa i pokaze sie dodany wczesniej uzytkownik
@WebServlet("/getuser")
public class GetFromSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(true);
        User user = (User) httpSession.getAttribute("user");
        resp.getWriter().println(user);

    }
}
