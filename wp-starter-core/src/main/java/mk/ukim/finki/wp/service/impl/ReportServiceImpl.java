package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.service.Printer;
import mk.ukim.finki.wp.service.ReportService;
import mk.ukim.finki.wp.web.mvc.ReportController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by ristes on 11/25/16.
 */
@Service
//@Scope(value = "session")
public class ReportServiceImpl implements ReportService, BeanNameAware, ApplicationContextAware, BeanPostProcessor {

  static final Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);

  private Printer printer;


  @Autowired
  public ReportServiceImpl(Printer printer) {
    this.printer = printer;
  }

  @PostConstruct
  public void init() {
    logger.debug("@PostConstruct method invoked");
  }

  @PreDestroy
  public void destroy() {

  }

  public void generateReport() {
    logger.debug(">>>generating report started");
    printer.print("Report 1");

    printer.print("line 1");
    printer.print("line 2");
    printer.print("line 3");
    printer.print("line 5");

    printer.print("footer");
    logger.debug(">>>generating report finished");
  }

  public Printer getPrinter() {
    return printer;
  }

  public void setPrinter(Printer printer) {
    this.printer = printer;
  }

  public static void main(String[] args) {

    ReportService reportService = new ReportServiceImpl(
      new MockPrinter()
    );

    reportService.generateReport();

  }

  public void setBeanName(String s) {
    logger.debug("setBeanName({})", s);
  }

  public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
    logger.debug("postProcessBeforeInitialization({},{})", o, s);
    return o;
  }

  public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
    logger.debug("postProcessAfterInitialization({},{})", o, s);
    return o;
  }

  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    logger.debug("setApplicationContext({},{})", applicationContext);

  }
}
