package pekidz;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


import java.util.logging.Logger;

public class TestRunner {
    private static final Logger logger = Logger.getLogger(TestRunner.class.getName());

	public static void main(String[] args) {
Result result = JUnitCore.runClasses(TestStan.class, TestAgencijaProdajeStanova.class);
		
		Logger l = Logger.getLogger(TestRunner.class.toString());
		
		for (Failure f: result.getFailures()) {
			l.warning(f.toString());
		}
		
		l.info("Vreme izvrsavanja:" + result.getRunTime());
		l.info("Broj testova:"+ result.getRunCount());
		
		l.info("Uspesno testova:" + (result.getRunCount()-result.getFailureCount()-result.getIgnoreCount()-result.getAssumptionFailureCount()));
		l.info("Broj palih testova:"+ result.getFailureCount());
		l.info("Broj preskocenih:"+ result.getIgnoreCount());
		l.info("Broj dinamicki preskocenih:" + result.getAssumptionFailureCount());
		
		if (result.wasSuccessful()) 
			l.info("Svi testovi su uspesno izvrseni");
		else
			l.warning("Postoje greske u testovima");

	}
	
	
}
