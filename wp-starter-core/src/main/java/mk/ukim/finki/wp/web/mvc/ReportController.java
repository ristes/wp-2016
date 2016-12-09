package mk.ukim.finki.wp.web.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by ristes on 11/25/16.
 */
@Controller
@RequestMapping(value = "/report")
public class ReportController {

  static final Logger logger = LoggerFactory.getLogger(
    ReportController.class);

  @RequestMapping(value = "/generate/{title}",
    method = RequestMethod.GET)
  public ModelAndView generate(
    @RequestParam(defaultValue = "wp") String name,
    @PathVariable String title,
    HttpServletRequest request,
    HttpServletResponse response,
    HttpSession session
  ) {
    logger.debug("generate invoked");
    logger.debug("request: {}", request);
    logger.debug("response: {}", response);
    logger.debug("session: {}", session);
    logger.debug("Request param name: {}", name);
    ModelAndView result = new ModelAndView("default");
    result.addObject("title", title);
    result.addObject("name", name);
    return result;
  }


}
