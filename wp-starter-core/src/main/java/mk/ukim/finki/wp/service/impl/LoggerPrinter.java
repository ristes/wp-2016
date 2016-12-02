package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.service.Printer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Created by ristes on 11/25/16.
 */
@Service
@Primary
public class LoggerPrinter implements Printer {

  static final Logger logger = LoggerFactory.getLogger(
    LoggerPrinter.class);


  public void print(String text) {
    logger.info(text);
  }
}
