package log4jDemo.log4j_maven;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * sample maven project with loggers
 *
 */
public class App 
{
	private final static Logger log = Logger.getLogger(App.class.getName());
    public static void main( String[] args )
    {
//    	BasicConfigurator.configure();
       log.debug("degub info");
       log.fatal("fatal msg");
    }
}
