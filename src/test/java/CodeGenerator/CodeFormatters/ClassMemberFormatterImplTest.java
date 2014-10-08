package CodeGenerator.CodeFormatters;

import CodeGenerator.Builders.FieldBuilder;
import CodeGenerator.Builders.MethodBuilder;
import CodeGenerator.CodeFormatters.Interfaces.ClassFormatter;
import CodeGenerator.CodeFormatters.Interfaces.FieldFormatter;
import CodeGenerator.CodeFormatters.Interfaces.MethodFormatter;
import CodeGenerator.CodeGraph.*;
import CodeGenerator.CodeGraph.ClassMember;
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

public class ClassMemberFormatterImplTest
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
        List<FieldMember> fieldMembers = new ArrayList<>();
        fieldMembers.add(new FieldBuilder().withDefaults().build());
        fieldMembers.add(new FieldBuilder().withDefaults().build());

        List<MethodMember> methodMembers = new ArrayList<>();
        methodMembers.add(new MethodBuilder().withDefaults().build());
        methodMembers.add(new MethodBuilder().withDefaults().build());

        ClassMember classMemberObject = new ClassMember(VisibilityQualifier.PRIVATE, "class1", fieldMembers, methodMembers);

        List<String> formattedField= new ArrayList<>();
        formattedField.add("foo");

        when(fieldFormatterMock.format(any(FieldMember.class))).thenReturn(formattedField);

        List<String> formatttedClass = classFormatter.format(classMemberObject);

        assertThat(formatttedClass.get(0), is("private class class1 {"));
        assertThat(formatttedClass.get(formatttedClass.size()-1), is("}"));
        verify(fieldFormatterMock, times(fieldMembers.size())).format(any(FieldMember.class));
        verify(methodFormatterMock, times(methodMembers.size())).format(any(MethodMember.class));
    }

}