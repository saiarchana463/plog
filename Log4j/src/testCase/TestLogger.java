package testCase;

import org.apache.log4j.Logger;

/**
 * 
 * @author savant
 *
 */
/*
 * levels of logging - trace(+)> debug> info> warn> error> fatal(-)
 * if you mention DEBUG you won't get trace information you will get DEBUG,INFO,WARN,ERROR,FATAL
 * if you mention WARN you will WARN, ERROR , FATAL
 */
public class TestLogger {
	static Logger log = Logger.getLogger(TestLogger.class.getName());
	public static void main(String[] args) {
		log.debug("debug msg");
		log.info("info msg");
	}
}
