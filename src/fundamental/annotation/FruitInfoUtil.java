package fundamental.annotation;

import java.lang.reflect.Field;

public class FruitInfoUtil {

    public static void getFruitInfo(Class<?> clazz){

        String strFruitprovider = "供应商信息";
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){

            if (field.isAnnotationPresent(FruitProvider.class)){

                FruitProvider annotation = field.getAnnotation(FruitProvider.class);
                System.out.println("供应商ID:" + annotation.id() + "供应商名字：" + annotation.name() +
                        "供应商地址："+ annotation.address());
            }

        }
    }

}
