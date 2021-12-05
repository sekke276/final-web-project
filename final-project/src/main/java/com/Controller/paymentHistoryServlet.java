package com.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.Cart;
import com.cart.CartDAO;
import com.user.User;
import com.item.Item;
import com.item.ItemDAO;
import com.tree.Tree;
@WebServlet("/ListPaymentHistory")
public class paymentHistoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/paymentHistory.jsp";
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Cart cart = new Cart();
        cart = CartDAO.selectCartByUid(user.getId());
        if(CartDAO.checkExistCart(user.getId()))
        {
            cart = CartDAO.selectCartByUid(user.getId());
        }
        else
        {
            cart.setUser(user);
            CartDAO.addCart(cart);

        }
        List<Item> listItems = new ArrayList<Item>();
        listItems = ItemDAO.SelectPaidUserProducts(cart.getId());
        List<Tree> listTrees = new ArrayList<Tree>();
        for(int i = 0 ; i < listItems.size(); i++)
        {
            Tree tree = listItems.get(i).getTree();
            listTrees.add(tree);
        }

        req.setAttribute("listTrees", listTrees);
        req.setAttribute("listItems", listItems);
    getServletContext().getRequestDispatcher(url).forward(req, resp);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
