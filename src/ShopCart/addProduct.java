package ShopCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addproduct")
public class addProduct extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String product = req.getParameter("product");
        String type = req.getParameter("type");
        Integer amount = Integer.parseInt(req.getParameter("amount"));
        Cart cart = new Cart(product, type, amount);
        HttpSession httpSession = req.getSession(true);
        List<Cart> products = (List<Cart>) httpSession.getAttribute("cart");
        if (products == null) {
            products = new ArrayList<>();
        }
        products.add(cart);
        httpSession.setAttribute("cart", products);
        resp.getWriter().println("Added to cart: " + products);
    }
}

