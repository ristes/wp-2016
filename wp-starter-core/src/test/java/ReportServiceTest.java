import mk.ukim.finki.wp.service.Printer;
import mk.ukim.finki.wp.service.ReportService;
import mk.ukim.finki.wp.service.impl.ReportServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.*;

/**
 * Created by ristes on 11/25/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ReportServiceTest.class)
@Configuration
public class ReportServiceTest {


  @Autowired
  ReportService reportService;

  @Bean
  public ReportService reportService() {
    return new ReportServiceImpl(mock(Printer.class));
  }

  @Test
  public void testReportService() {
    reportService.generateReport();
  }


}
