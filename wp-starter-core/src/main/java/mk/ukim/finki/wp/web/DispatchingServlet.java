package mk.ukim.finki.wp.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by ristes on 11/18/16.
 */
public class DispatchingServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    RequestDispatcher dispatcher = req.getRequestDispatcher("print-params.jsp");

    req.getSession().setAttribute("dispatching", "string 1");

    Cookie[] cookies = req.getCookies();
    req.setAttribute("servlet", "dispating-servlet");

    Cookie newCookie = new Cookie("user", "riste");
    newCookie.setMaxAge(30); // 3 sec
//    newCookie.setDomain("http://finki.ukim.mk");
//    newCookie.setPath("/wp");


    resp.addCookie(newCookie);


    dispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
