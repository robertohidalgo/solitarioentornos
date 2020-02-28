package sinJUnit;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MetaClazzesExample {

    @SuppressWarnings({"rawtypes", "unchecked"})

    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("solitarioconpolimorfismo.util.Intervalo");
            Object object = clazz.getConstructor(double.class, double.class).newInstance(1., 3.);
            System.out.println("Objeto: " + object);
            Method method = clazz.getDeclaredMethod("longitud");
            double longitud  = (double) method.invoke(object);
            System.out.println("Longitud: " + longitud);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
}
