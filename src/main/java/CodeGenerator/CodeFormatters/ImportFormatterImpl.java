package CodeGenerator.CodeFormatters;

import CodeGenerator.CodeFormatters.Interfaces.ImportFormatter;
import CodeGenerator.CodeGraph.Import;

import java.util.ArrayList;
import java.util.List;

import static CodeGenerator.CodeFormatters.SpecialCharacters.LINE_TERMINATOR;

public class ImportFormatterImpl implements ImportFormatter
{
    @Override
    public List<String> format(Import importCodeObject)
    {
        String formattedImport = "import " + importCodeObject.getName() + LINE_TERMINATOR;
        ArrayList<String> result = new ArrayList<>();
        result.add(formattedImport);

        return result;
    }
}
