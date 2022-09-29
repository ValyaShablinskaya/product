package by.it_academy.jd2.mk_jd2_92_22.product.controllers;

import by.it_academy.jd2.mk_jd2_92_22.product.controllers.util.Converter;
import by.it_academy.jd2.mk_jd2_92_22.product.entity.Product;

import by.it_academy.jd2.mk_jd2_92_22.product.services.ProductServices;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "ProductAddServlet", urlPatterns = "/productAdd")
public class ProductAddServlet extends HttpServlet {
    private final ProductServices productServices = ProductServices.getInstance();
    private final Converter converter = new Converter();
    private final ObjectMapper mapper = new ObjectMapper();

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

        BufferedReader bufferedReader = req.getReader();
        String jsonToString = converter.convertToString(bufferedReader);
        Product product = productServices.add(convertToProduct(jsonToString));
        resp.getWriter().write(mapper.writeValueAsString(product));
    }

    private Product convertToProduct(String productJson) {
        Product product;
        try {
            product = mapper.readValue(productJson, Product.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return product;
    }
}