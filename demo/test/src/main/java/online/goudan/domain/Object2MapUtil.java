package online.goudan.domain;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenglongliu
 * @date 2021/4/7 11:58
 * @desc 对象转成map集合
 */
public class Object2MapUtil {

    public static Map<String, Object> object2Map(Object o) {
        Map<String, Object> map = new HashMap<>();
        Class<?> clazz = o.getClass();
        if (clazz.isPrimitive()) {
            return map;
        }
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Class<?> type = declaredField.getType();
            try {
                if (type.isPrimitive() || "String".equals(type.getSimpleName())) {
                    map.put(declaredField.getName(), declaredField.get(o));
                } else {
                    map.put(declaredField.getName(), object2Map(declaredField.get(o)));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
