package cn.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author xiaochen
 * @create 2021-06-21 16:56
 */
public class WebUtils {
    /**
     * 把Map中的值注入到对应的JavaBean属性中。
     * @param value
     * @param bean
     * @param <T>
     * @return
     */
    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            System.out.println("注入之前: " + bean);
            BeanUtils.populate(bean, value);
            System.out.println("注入之后: " + bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     *
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt, int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
