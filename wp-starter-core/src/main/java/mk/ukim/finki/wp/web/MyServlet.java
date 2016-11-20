package mk.ukim.finki.wp.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ristes on 11/18/16.
 */
public class MyServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(resp.getOutputStream());
      writer.append("<h1>Hello from MyServlet</h1>");

      writer.append("<div>");
      if (req.getParameter("name") == null) {
        throw new IllegalArgumentException("no name parameter avaialble");
      }
      writer.append(req.getParameter("name"));
      writer.append("</div>");

      writer.flush();
    } finally {
      if (writer != null)
        writer.close();
    }

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
