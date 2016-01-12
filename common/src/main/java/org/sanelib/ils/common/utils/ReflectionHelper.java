package org.sanelib.ils.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class ReflectionHelper {

    public static <T1, T2>  void copy(T1 src, T2 dest) throws IllegalAccessException, NoSuchFieldException {

        Class<?> srcClass = src.getClass();
        Class<?> destClass = dest.getClass();

        Map<Field, Object> srcFields = new HashMap<>();

        while(srcClass.getSuperclass() != null){
            Field[] fromFields = srcClass.getDeclaredFields();
            for (Field field : fromFields){
                if(Modifier.isFinal(field.getModifiers())){
                    continue;
                }
                field.setAccessible(true);
                Object value = field.get(src);
                srcFields.put(field, value);
            }
            srcClass = srcClass.getSuperclass();
        }

        Map<String, Field> destFields = new HashMap<>();

        while(destClass.getSuperclass() != null){
            Field[] fromFields = destClass.getDeclaredFields();
            for (Field field : fromFields){
                if(Modifier.isFinal(field.getModifiers())){
                    continue;
                }
                field.setAccessible(true);
                destFields.put(field.getName(), field);
            }

            destClass = destClass.getSuperclass();
        }

        for (Field srcField : srcFields.keySet()){
            Field destField = destFields.get(srcField.getName());
            Object value = srcFields.get(srcField);
            destField.set(dest, value);
        }
    }
}
