package simpleEjb;

import javax.ejb.Stateless;

@Stateless(name = "HelloStatelessWorld")
public class HelloStatelessWorldBean implements HelloStatelessWorld {

	@Override
    public String getHelloWorld() {
		System.out.println("teste");
        return "Hello Stateless World!";
    }

}
