package CodeGenerator.CodeFormatters;

import CodeGenerator.CodeFormatters.Interfaces.ClassFormatter;
import CodeGenerator.CodeGraph.*;
import CodeGenerator.CodeGraph.Class;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ClassFormatterImplTest
{
    private ClassFormatter classFormatter;

    @Before
    public void setup()
    {
        classFormatter = new ClassFormatterImpl();
    }

    @Test
    public void shouldFormatClass()
    {
        List<Field> fields = new ArrayList<>();
        fields.add(new Field(VisibilityQualifier.PRIVATE, "int", "field1"));
        fields.add(new Field(VisibilityQualifier.PRIVATE, "String", "field2"));

        Method method1 = new Method(VisibilityQualifier.PUBLIC, "void", "method1", new ArrayList<String>());
        method1.addStatement("System.out.println(\"Hello World\")");
        Method method2 = new Method(VisibilityQualifier.PUBLIC, "void", "method2", new ArrayList<String>());
        method2.addStatement("System.out.println(\"Hello World\")");

        List<Method> methods = new ArrayList<>();
        methods.add(method1);
        methods.add(method2);

        Class classObject = new Class(VisibilityQualifier.PRIVATE, "class1", fields, methods);
        List<String> formatttedClass = classFormatter.format(classObject);

        assertThat(formatttedClass.size(), is(10));
        assertThat(formatttedClass.get(0), is("private class class1 {"));
        assertThat(formatttedClass.get(1), is("\tprivate int field1;"));
        assertThat(formatttedClass.get(2), is("\tprivate String field2;"));
        assertThat(formatttedClass.get(3), is("\tpublic void method1() {"));
        assertThat(formatttedClass.get(4), is("\t\tSystem.out.println(\"Hello World\")"));
        assertThat(formatttedClass.get(5), is("\t}"));
        assertThat(formatttedClass.get(6), is("\tpublic void method2() {"));
        assertThat(formatttedClass.get(7), is("\t\tSystem.out.println(\"Hello World\")"));
        assertThat(formatttedClass.get(8), is("\t}"));
        assertThat(formatttedClass.get(9), is("}"));
    }

}