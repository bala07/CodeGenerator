package CodeGenerator.CodeFormatters;

import CodeGenerator.CodeFormatters.Interfaces.FieldFormatter;
import CodeGenerator.CodeGraph.FieldMember;

import java.util.ArrayList;
import java.util.List;

import static CodeGenerator.CodeFormatters.SpecialCharacters.*;

public class FieldFormatterImpl implements FieldFormatter
{
    @Override
    public List<String> format(FieldMember fieldMember)
    {
        String formattedField = fieldMember.getVisibilityQualifier() + SPACE
                + fieldMember.getType() + SPACE
                + fieldMember.getName() + LINE_TERMINATOR;

        ArrayList<String> result = new ArrayList<>();
        result.add(formattedField);

        return result;
    }
}
