package CodeGenerator.CodeFormatters;

import CodeGenerator.CodeFormatters.Interfaces.ImportFormatter;
import CodeGenerator.CodeGraph.ImportMember;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ImportMemberFormatterImplTest
{
    private ImportFormatter importFormatter;

    @Before
    public void setup()
    {
        importFormatter = new ImportFormatterImpl();
    }

    @Test
    public void shouldFormatImportStatement()
    {
        ImportMember importMemberCodeObject = new ImportMember("java.util");
        List<String> formattedImportStatement = importFormatter.format(importMemberCodeObject);

        String expectedImportStatement = "import java.util;";
        assertThat(formattedImportStatement.get(0), is(expectedImportStatement));
    }
}