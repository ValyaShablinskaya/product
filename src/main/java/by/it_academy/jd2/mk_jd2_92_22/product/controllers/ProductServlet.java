package by.it_academy.jd2.mk_jd2_92_22.product.controllers;

import by.it_academy.jd2.mk_jd2_92_22.product.services.ProductServices;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private final ProductServices productServices = ProductServices.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
       req.setCharacterEncoding("UTF-8");
       resp.setContentType("text/html; charset=UTF-8");
       req.setAttribute("productData", productServices.get());
       req.getRequestDispatcher("productForm.jsp").forward(req, resp);
    }
}