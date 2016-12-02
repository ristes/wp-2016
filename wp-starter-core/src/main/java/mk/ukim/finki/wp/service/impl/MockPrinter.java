package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.service.Printer;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by ristes on 11/25/16.
 */
@Service(value = "printer")
public class MockPrinter implements Printer {
  public void print(String text) {
    System.out.print("Mock printer: ");
    System.out.println(text);
  }
}
