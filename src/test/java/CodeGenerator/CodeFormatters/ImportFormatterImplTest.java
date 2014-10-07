package CodeGenerator.CodeFormatters;

import CodeGenerator.CodeFormatters.Interfaces.ImportFormatter;
import CodeGenerator.CodeGraph.Import;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ImportFormatterImplTest
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
        Import importCodeObject = new Import("java.util");
        List<String> formattedImportStatement = importFormatter.format(importCodeObject);

        String expectedImportStatement = "import java.util;";
        assertThat(formattedImportStatement.get(0), is(expectedImportStatement));
    }
}