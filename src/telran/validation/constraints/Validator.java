package telran.validation.constraints;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import telran.annotation.examples.AnnotationsProcessor;

public class Validator {
	
	public static ArrayList<String> validate(Object obj) {
		ArrayList<String> res = new ArrayList<>();
		
		List<Field> listOfAnnotatedFields = Arrays.stream(obj.getClass().getDeclaredFields())
				.peek(x -> System.out.println(x.getAnnotations()!=null))
				.filter(field -> field.getAnnotations()!=null && field.getAnnotations().length > 0)
				.toList();
		
		listOfAnnotatedFields.stream().forEach(field -> {
			var arrayOfAnnotations = field.getAnnotations();
			for (var annotation: arrayOfAnnotations) {
				String methodName = "validate"+annotation.annotationType().getSimpleName();
				 try {
					String tempRes = (String) AnnotationsProcessor.class
							.getMethod(methodName, field.getClass(), obj.getClass())
							.invoke(obj, field, obj);
					res.add(tempRes);
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		});
		return res;
	}
}
