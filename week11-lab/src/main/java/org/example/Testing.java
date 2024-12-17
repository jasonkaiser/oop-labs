package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Testing{




    @Test
    public void CheckIfaStudentIsPresent(){

        try{
            StudentSystem test = new StudentSystem("students.csv");
            assertTrue(test.noOfStudents() > 0);

        } catch (Exception e) {
            e.printStackTrace();
        }


    };

    @Test
    public void CheckStudent100Exists(){

        try {
            StudentSystem test = new StudentSystem("students.csv");
            assertTrue(test.getStudentById(100).isEmpty());

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testHighestGpaStudent(){

        try{
            StudentSystem test = new StudentSystem("students.csv");
            assertEquals(12, test.getStudentByHighestGPA());
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void testExceptionForEmptyStudentList(){

        List<Student> test = new ArrayList<>();
        StudentSystem emptyList = new StudentSystem(test);

        EmptyStudentListException testException = assertThrows(EmptyStudentListException.class, emptyList::getStudentByHighestGPA);
        assertEquals("This Student List is empty!", testException.getMessage());

    }

}
