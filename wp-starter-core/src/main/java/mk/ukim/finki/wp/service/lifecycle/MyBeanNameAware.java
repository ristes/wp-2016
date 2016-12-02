package mk.ukim.finki.wp.service.lifecycle;

import mk.ukim.finki.wp.service.impl.LoggerPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * Created by ristes on 11/25/16.
 */
@Component
public class MyBeanNameAware implements BeanNameAware {

  static final Logger logger = LoggerFactory.getLogger(
    MyBeanNameAware.class);

  public void setBeanName(String s) {
    logger.debug("Setting bean in BeanNameAware:  {}", s);
  }
}
