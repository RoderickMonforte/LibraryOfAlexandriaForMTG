package edu.matc.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by student on 5/6/17.
 */
public class AlertTest {
    Alert alert;
    @Before
    public void setUp() throws Exception {
        alert = new Alert(3);
        alert.initField(0,"Field1", "Value1");
        alert.initField(1,"Field2", "Value2");
        alert.initField(2,"Field3", "Value3");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void initialize() throws Exception {
        alert.initialize();

        assertEquals("Must be equal" ," ", alert.getMessage());
    }

    @Test
    public void fieldPassed() throws Exception {
        alert.fieldPassed("Field2");
        String classValue = alert.getField(1).getFieldClass();
        assertEquals("Must be equal" ," has-success has-feedback",
                classValue);

    }

    @Test
    public void normalize() throws Exception {
        alert.normalize();
        String classValue = alert.getField(1).getFieldClass();
        assertEquals("Must be equal" ,"",
                classValue);

    }

    @Test
    public void initField() throws Exception {
        String classValue = alert.getField(1).getValue();
        assertEquals("Must be equal" ,"Value2", classValue);

    }

    @Test
    public void error() throws Exception {
        alert.error("error");
        assertEquals("Must be equal" ,"alert alert-danger", alert.getType());

    }

    @Test
    public void errorWithField() throws Exception {
        alert.error(0, "error");
        String classValue = alert.getField(0).getValue();
        assertEquals("Must be equal" ,"Value1", alert.getField
                (0).getValue());
        assertEquals("Must be equal" ," <br><strong>Error: </strong>error",
                alert.getMessage());

    }

    @Test
    public void warning() throws Exception {
        alert.warning("error");
        assertEquals("Must be equal" ,"alert alert-warning", alert.getType());

    }

    @Test
    public void warningWithField() throws Exception {
        alert.warning(0, "warning");
        String classValue = alert.getField(0).getValue();
        assertEquals("Must be equal" ,"Value1", alert.getField
                (0).getValue());
        assertEquals("Must be equal" ,"<strong>Warning: </strong>warning",
                alert.getMessage());

    }
    @Test
    public void info() throws Exception {
        alert.info("error");
        assertEquals("Must be equal" ,"alert alert-info", alert.getType());

    }

    @Test
    public void infoWithField() throws Exception {
        alert.info(0, "info");
        String classValue = alert.getField(0).getValue();
        assertEquals("Must be equal" ,"Value1", alert.getField
                (0).getValue());
        assertEquals("Must be equal" ,"<strong>Information: </strong>info",
                alert.getMessage());

    }

    @Test
    public void success() throws Exception {
        alert.success("error");
        assertEquals("Must be equal" ,"alert alert-success", alert.getType());
    }

    @Test
    public void successWithField() throws Exception {
        alert.success(0, "success");
        String classValue = alert.getField(0).getValue();
        assertEquals("Must be equal" ,"Value1", alert.getField
                (0).getValue());
        assertEquals("Must be equal" ,"<strong>Success: </strong>success",
                alert.getMessage());

    }

    @Test
    public void getField() throws Exception {
        Field field = alert.getField(0);
        assertEquals("Must be equal" ,"Field1", field.getFieldName());
    }

    @Test
    public void getField1() throws Exception {
        Field field = alert.getField("Field3");
        assertEquals("Must be equal" ,"Value3", field.getValue());

    }

}