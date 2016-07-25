package services.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/webApi")
public class MyApplication extends Application{

	private Set<Class<?>> classes = new HashSet<>();
	
	public MyApplication() {
		classes = new HashSet<>();
		classes.add(MyResource.class);
	}
	@Override
	public Set<Class<?>> getClasses() {
		// TODO Auto-generated method stub
		return super.getClasses();
	}
	@Override
	public Set<Object> getSingletons() {
		// TODO Auto-generated method stub
		return super.getSingletons();
	}
}
