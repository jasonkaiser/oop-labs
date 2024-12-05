package org.example;
import javax.accessibility.Accessible;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Start {


    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {

        List<Integer> jasonGrades = new ArrayList<>();
        jasonGrades.add(3);
        jasonGrades.add(5);
        jasonGrades.add(2);
        jasonGrades.add(5);

        Student jason = new Student("jason" ,"A01", jasonGrades);
        GradeAnalyzer jasonGrade = new GradeAnalyzer(jason.getGrades());


        /* ======== GET FIELDS / VALUES ============================= //
        Field[] studentFields = jason.getClass().getDeclaredFields();

        for(Field field : studentFields){
            field.setAccessible(true);
            System.out.println(field.getName() + " - " + field.get(jason));
        }

        Field[] gradeFields = jasonGrade.getClass().getDeclaredFields();

        for(Field field : gradeFields){
            field.setAccessible(true);
            System.out.println(field.getName() + " - " + field.get(jasonGrade));
        }

        // ========================================================== //
         */
        Method[] gradeMethods = jasonGrade.getClass().getDeclaredMethods();

        for(Method method : gradeMethods){
            if(method.getName().startsWith("calculate") || method.getName().startsWith("print")){
                if(method.getReturnType() != void.class){
                    Object result = method.invoke(jasonGrade);
                    System.out.println(method.getName() + " - Result: " + result);
                } else {
                    System.out.println(method.getName() + " - Completed: Invoked");
                }
            }
        }


    }

}
