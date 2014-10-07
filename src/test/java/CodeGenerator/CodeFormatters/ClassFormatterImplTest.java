package CodeGenerator.CodeFormatters;

import CodeGenerator.CodeFormatters.Interfaces.ClassFormatter;
import CodeGenerator.CodeFormatters.Interfaces.FieldFormatter;
import CodeGenerator.CodeFormatters.Interfaces.MethodFormatter;
import CodeGenerator.CodeGraph.*;
import CodeGenerator.CodeGraph.Class;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ClassFormatterImplTest
{
    private ClassFormatter classFormatter;
    @Mock
    private MethodFormatter methodFormatterMock;
    @Mock
    private FieldFormatter fieldFormatterMock;

    @Before
    public void setup()
    {
        initMocks(this);
        classFormatter = new ClassFormatterImpl(fieldFormatterMock, methodFormatterMock);
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

        List<String> formattedField= new ArrayList<>();
        formattedField.add("foo");

        when(fieldFormatterMock.format(any(Field.class))).thenReturn(formattedField);

        List<String> formatttedClass = classFormatter.format(classObject);

        assertThat(formatttedClass.get(0), is("private class class1 {"));
        assertThat(formatttedClass.get(3), is("}"));
        verify(fieldFormatterMock, times(2)).format(any(Field.class));
        verify(methodFormatterMock, times(2)).format(any(Method.class));
    }

}