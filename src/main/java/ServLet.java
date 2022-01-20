import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ServLet extends HttpServlet{
        private static Logger logger = LoggerFactory.getLogger(ServLet.class);
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            logger.info("get information");
            System.out.println("Redirect");
            List<Product> products = new ArrayList<>();
            products.add(new Product(1,"Oranges",90.10f));
            products.add(new Product(2,"Apples",68.00f));
            products.add(new Product(3,"Plums",190.60f));
            products.add(new Product(4,"Pears",109.20f));
            products.add(new Product(5,"Kiwi",190.50f));
            products.add(new Product(6,"Bread",50f));
            products.add(new Product(7,"Milk",98f));
            products.add(new Product(8,"Potato",45.50f));
            products.add(new Product(9,"Butter",145.80f));
            products.add(new Product(10,"Tea",300.00f));

            PrintWriter out = resp.getWriter();
            products.stream().forEach(p->out.printf("<html><body><h1>" + p.getId() + ". " +
                    p.getTitle() + " - " + p.getCost() + "</h1></body></html>"));
            out.close();
        }
    }
