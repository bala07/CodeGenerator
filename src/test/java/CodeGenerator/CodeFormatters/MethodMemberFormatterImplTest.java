package CodeGenerator.CodeFormatters;

import CodeGenerator.CodeFormatters.Interfaces.MethodFormatter;
import CodeGenerator.CodeGraph.MethodMember;
import CodeGenerator.CodeGraph.VisibilityQualifier;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(Theories.class)
public class MethodMemberFormatterImplTest
{
    private MethodFormatter methodFormatter;

    @Before
    public void setup()
    {
        methodFormatter = new MethodFormatterImpl();
    }

    @Test
    public void shouldFormatMethod()
    {
        MethodMember methodMember = new MethodMember(VisibilityQualifier.PRIVATE, "void", "testMethod", new ArrayList<String>());
        methodMember.addStatement("System.out.println(\"Hello World\")");


        List<String> formattedMethod = methodFormatter.format(methodMember);

        assertThat(formattedMethod.size(), is(3));
        assertThat(formattedMethod.get(0), is("private void testMethod() {"));
        assertThat(formattedMethod.get(1), is("\tSystem.out.println(\"Hello World\");"));
        assertThat(formattedMethod.get(2), is("}"));
    }
}