package mk.ukim.finki.wp.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by ristes on 11/18/16.
 */
public class RedirectingServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    req.setAttribute("servlet", "redirect-servlet");

    req.getSession().setAttribute("redirect", new Date().getTime());

    resp.sendRedirect("/dispatching-servlet");

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
