package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;

import com.cart.Cart;
import com.cart.CartDAO;

@WebServlet("/paypalajax/*")
public class paypalAjax extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId = 0;
		try {
			userId = Integer.parseInt(req.getParameter("userId"));
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}

		// update purchase to database
		Cart cart = CartDAO.selectCartByUid(userId);
		CartDAO.updateCheckCart(cart);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
