package CodeGenerator.CodeFormatters;

import CodeGenerator.CodeFormatters.Interfaces.FieldFormatter;
import CodeGenerator.CodeGraph.FieldMember;
import CodeGenerator.CodeGraph.VisibilityQualifier;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FieldMemberFormatterImplTest
{
    private FieldFormatter fieldFormatter;

    @Before
    public void setup()
    {
        fieldFormatter = new FieldFormatterImpl();
    }

    @Test
    public void shouldFormatTheFieldCodeObject()
    {
        FieldMember fieldMember = new FieldMember(VisibilityQualifier.PRIVATE, "int", "func1");

        List<String> formattedField = fieldFormatter.format(fieldMember);

        System.out.println("formattedField.get(0) = " + formattedField.get(0));

        String expectedFormattedField = "private int func1;";
        assertThat(formattedField.get(0), is(expectedFormattedField));
    }
}
