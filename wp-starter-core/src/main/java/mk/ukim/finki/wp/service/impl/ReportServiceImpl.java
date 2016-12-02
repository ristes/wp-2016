package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.service.Printer;
import mk.ukim.finki.wp.service.ReportService;
import mk.ukim.finki.wp.web.mvc.ReportController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by ristes on 11/25/16.
 */
@Service
@Scope(value = "session")
public class ReportServiceImpl implements ReportService {

  private Printer printer;


  @Autowired
  public ReportServiceImpl(Printer printer) {
    this.printer = printer;
  }

  @PostConstruct
  public void init() {
    generateReport();
  }

  @PreDestroy
  public void destroy() {

  }

  public void generateReport() {
    printer.print("Report 1");

    printer.print("line 1");
    printer.print("line 2");
    printer.print("line 3");
    printer.print("line 5");

    printer.print("footer");

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
}
