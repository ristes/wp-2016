package mk.ukim.finki.wp.web;


import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by ristes on 11/18/16.
 */
public class MyFilter implements Filter {
  public void destroy() {
  }

  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
    long start = System.currentTimeMillis();
    System.out.println("In filter");
    Map<String, String[]> allParams = req.getParameterMap();
    for (Map.Entry<String, String[]> entry : allParams.entrySet()) {
      req.setAttribute("p_" + entry.getKey(), entry.getValue()[0]);
    }
    if (req.getParameter("name") == null) {
      req.getRequestDispatcher("no-name.jsp").forward(req, resp);
      return;
    }

    synchronized (MyFilter.class) {
      req.getServletContext().setAttribute("contextAttr", "attrValue");
    }

    chain.doFilter(req, resp);


    HttpServletResponse httpResponse = (HttpServletResponse) resp;
    httpResponse
      .setHeader("processing-time",
        "" + (System.currentTimeMillis() - start));

  }

  public void init(FilterConfig config) throws ServletException {

  }

}
