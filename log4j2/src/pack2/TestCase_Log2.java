package pack2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestCase_Log2 {

	
	private static Logger log4j=LogManager.getLogger();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		log4j.debug("Dubug");
		
		log4j.info("info");
		
		log4j.error("error");
		
		log4j.fatal("fatal");
		
		log4j.info("welcome to log4j");
		
	}

}
