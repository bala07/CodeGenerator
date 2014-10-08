package CodeGenerator.CodeFormatters;

import CodeGenerator.CodeFormatters.Interfaces.ImportFormatter;
import CodeGenerator.CodeGraph.ImportMember;

import java.util.ArrayList;
import java.util.List;

import static CodeGenerator.CodeFormatters.SpecialCharacters.LINE_TERMINATOR;

public class ImportFormatterImpl implements ImportFormatter
{
    @Override
    public List<String> format(ImportMember importMemberCodeObject)
    {
        String formattedImport = "import " + importMemberCodeObject.getName() + LINE_TERMINATOR;
        ArrayList<String> result = new ArrayList<>();
        result.add(formattedImport);

        return result;
    }
}
