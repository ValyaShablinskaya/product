package by.it_academy.jd2.mk_jd2_92_22.product.controllers;

import by.it_academy.jd2.mk_jd2_92_22.product.entity.Product;
import by.it_academy.jd2.mk_jd2_92_22.product.entity.ProductBuilder;
import by.it_academy.jd2.mk_jd2_92_22.product.services.ProductServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductAddServlet", urlPatterns = "/productAdd")
public class ProductAddServlet extends HttpServlet {
    private final ProductServices productServices = ProductServices.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("productData", productServices.get());
        req.getRequestDispatcher("productFormAdd.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double cost = Double.parseDouble(req.getParameter("cost"));
        double discount = Double.parseDouble(req.getParameter("discount"));
        String description = req.getParameter("description");
        Product product = ProductBuilder.create()
                .setId(id)
                .setName(name)
                .setCost(cost)
                .setDiscount(discount)
                .setDescription(description)
                .build();
        productServices.add(product);

        resp.sendRedirect(req.getContextPath() + "/product");
    }
}