package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.Cart;
import com.cart.CartDAO;
import com.item.Item;
import com.item.ItemDAO;
import com.tree.Tree;
import com.tree.TreeDAO;
import com.user.User;
@WebServlet("/botServlet")
public class botServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/thanks.jsp";
        String action = req.getParameter("action");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Cart cart = new Cart();
		if (CartDAO.checkExistCart(user.getId())) {
            cart = CartDAO.selectCartByUid(user.getId());
        }
        else
        {
            cart.setUser(user);
            CartDAO.addCart(cart);
        }

        if(action.equals("Empty my cart"))
        {
            ItemDAO.deleteAllUnpaidItems(cart.getId());
        }
        else if (action.equals("filter"))
        {
            String type = req.getParameter("type");
            if(type.equals("Climber"))
            {
                type = "Climbers+%26+Creepers";
            }
            PrintWriter out = resp.getWriter();
            out.println("action=loadProduct&brand=All&type=" + type);
        }
        else if (action.equals("addToCart"))
        {
            String plantName = req.getParameter("plantName");
            Integer amount = 1;
            try
            {
                amount = Integer.parseInt(req.getParameter("amount"));  
            }
            catch(NumberFormatException nfe)
            {}
            Tree tree = TreeDAO.selectTreeByName(plantName);
            if(tree != null)
            {


                cart = CartDAO.selectCartByUid(user.getId());
                if(cart == null)
                {

                }
                Item item = new Item();
                item.setCart(cart);
                item.setTree(tree);
                item.setPrice(tree.getPrice());
                item.setState("order");
                item.setQuality(amount);

                ItemDAO.addItem(item);
            }


        }
		
    }
}
