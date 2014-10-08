package CodeGenerator.CodeFormatters;

import CodeGenerator.Builders.FieldBuilder;
import CodeGenerator.Builders.MethodBuilder;
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
        fields.add(new FieldBuilder().withDefaults().build());
        fields.add(new FieldBuilder().withDefaults().build());

        List<Method> methods = new ArrayList<>();
        methods.add(new MethodBuilder().withDefaults().build());
        methods.add(new MethodBuilder().withDefaults().build());

        Class classObject = new Class(VisibilityQualifier.PRIVATE, "class1", fields, methods);

        List<String> formattedField= new ArrayList<>();
        formattedField.add("foo");

        when(fieldFormatterMock.format(any(Field.class))).thenReturn(formattedField);

        List<String> formatttedClass = classFormatter.format(classObject);

        assertThat(formatttedClass.get(0), is("private class class1 {"));
        assertThat(formatttedClass.get(formatttedClass.size()-1), is("}"));
        verify(fieldFormatterMock, times(fields.size())).format(any(Field.class));
        verify(methodFormatterMock, times(methods.size())).format(any(Method.class));
    }

}