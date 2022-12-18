package telran.annotation.examples;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

import telran.annotation.*;

public class AnnotationsProcessor {
	static public Long getIdValue(Object obj) throws Exception {
		Field[] fields = obj.getClass().getDeclaredFields();
		Long id = null;
		for (Field field : fields) {
			field.setAccessible(true);
			if (field.isAnnotationPresent(Id.class)) {
				id = field.getLong(obj);
				break;
			}
		}
		return id;
	}

	static public String validatePattern(Object obj) {
		Field[] fields = obj.getClass().getDeclaredFields();
		String res = "";
		for (Field field : fields) {
			field.setAccessible(true);
			Pattern pattern = field.getAnnotation(Pattern.class);
			if (pattern != null) {
				try {
					String strValue = (String) field.get(obj);
					String regEx = pattern.value();
					if (!strValue.matches(regEx)) {
						res += ";" + pattern.message();
					}
				} catch (Exception e) {
					res += e.getMessage();
				}
			}
		}
		return res;
	}

	static public String validatePattern(Field field, Object obj) {
		String res = "";
		try {
			field.setAccessible(true);
			String strValue = (String) field.get(obj);
			String regEx = field.getAnnotation(Pattern.class).value();
			if (!strValue.matches(regEx)) {
				res = field.getAnnotation(Pattern.class).message();
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			res = e.getMessage();
		}
		return res;
	}

	static public String validateMin(Object obj) {
		String res = "";
		return res;
	}

	static public String validateMin(Field field, Object obj) {
		String res = "";
		try {
			field.setAccessible(true);
			double minValue = field.getAnnotation(Min.class).value();
			var fldValue = field.get(obj);
			if (fldValue instanceof String) {
				res = ((String) fldValue).length() < minValue ? null : "too long";
			} else if (fldValue instanceof Integer || fldValue instanceof Double) {
				res = (Double) fldValue < minValue ? null : "bigget than min value";
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return res;
	}

	static public String validateMax(Object obj) {
		String res = "";
		return res;
	}

	static public String validateMax(Field field, Object obj) {
		String res = "";
		return res;
	}

	static public String validateNotEmpty(Object obj) {
		String res = "";
		return res;
	}

	static public String validateNotEmpty(Field field, Object obj) {
		String res = "";
		return res;
	}
}
