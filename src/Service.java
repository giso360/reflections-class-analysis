
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Service {




	public void getDescription(String className) throws ClassNotFoundException {
		List<Method> methods = new ArrayList<>();
		List<String> methodNames = new ArrayList<>();
		Map<String, List<String>> descriptor = new HashMap<>();


		Class base = Class.forName(className);
		className = base.getSimpleName();

		for (Method m: base.getDeclaredMethods()){
			methods.add(m);
			methodNames.add(m.getName());

			Class<?>[] arguments = m.getParameterTypes();
			List<String> argNames = new ArrayList<>();
			for (Class<?> arg: arguments){
				argNames.add(arg.getSimpleName());
			}
			descriptor.put(m.getName(), argNames);
		}


		System.out.println("CLASS NAME: " + className);
		System.out.println("METHODS: ");
		methodNames.forEach(System.out::println);
		System.out.println("FULL DESCRIPTION:");
		for (Map.Entry<String, List<String>> entry: descriptor.entrySet()){
			String a = "";
			for (String s: entry.getValue()){
				a = a + s;
			}
			System.out.println(entry.getKey() + "\t:\t" + a);
		}
	}

}
