package cn.es.util;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.Id;
import javax.persistence.Table;

public class GenricsUtil {

	@SuppressWarnings("unchecked")
	public static Class getSuperClassGenricType(Class clazz, int index) {
		Type genType = clazz.getGenericSuperclass();
		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		if (index >= params.length || index < 0) {
			throw new RuntimeException("你输入的索引" + (index < 0 ? "不能小于0" : "超出了参数的总数"));
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[index];
	}

	public static String getEntityName(Class<?> clazz) {
		String tableName = clazz.getSimpleName();
		Table tableClazz = clazz.getAnnotation(Table.class);
		if (null != tableClazz && "".equals(tableClazz.name())) {
			tableName = tableClazz.name();
		}
		return tableName;
	}

	public static String getIdName(Class<?> entityClazz) {
		String defaultIDName = "ID";
		for (Method m : entityClazz.getMethods()) {
			defaultIDName = m.getName().substring(3);
			if (defaultIDName.startsWith("set")) {
				continue;
			}
			if (null != m.getAnnotation(Id.class)) {

				defaultIDName = defaultIDName.substring(0, 1).toLowerCase().concat(defaultIDName.substring(1));
				System.out.println("Found id setter method ,it's name is ".concat(defaultIDName));
				break;
			}
		}
		System.out.println("id name is :"+defaultIDName);
		return defaultIDName;
	}
}
