package onlien.goudan.utils;

import net.sf.cglib.beans.BeanCopier;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 刘成龙
 * @date 2021/7/5 15:50
 * @desc BeanCopierUtil
 */
public class BeanCopierUtil {

    private static Map<String, BeanCopier> beanCopierMap = new ConcurrentHashMap<>();

    public static void copyProperties(Object source, Object target) {
        String key = source.getClass().toString() + target.getClass().toString();
        BeanCopier beanCopier = null;
        if (!beanCopierMap.containsKey(key)) {
            synchronized (BeanCopierUtil.class) {
                if (!beanCopierMap.containsKey(key)) {
                    beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
                    beanCopierMap.put(key, beanCopier);
                } else {
                    beanCopier = beanCopierMap.get(key);
                }
            }
        } else {
            beanCopier = beanCopierMap.get(key);
        }
        beanCopier.copy(source, target, null);


    }


}
