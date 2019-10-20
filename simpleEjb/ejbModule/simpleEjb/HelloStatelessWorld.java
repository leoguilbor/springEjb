package simpleEjb;

import javax.ejb.Remote;

@Remote
public interface HelloStatelessWorld {
	 String getHelloWorld();
}
