package CodeGenerator.CodeFormatters;

import CodeGenerator.CodeFormatters.Interfaces.FieldFormatter;
import CodeGenerator.CodeGraph.Field;

import java.util.ArrayList;
import java.util.List;

import static CodeGenerator.CodeFormatters.SpecialCharacters.*;

public class FieldFormatterImpl implements FieldFormatter
{
    @Override
    public List<String> format(Field field)
    {
        String formattedField = field.getVisibilityQualifier() + SPACE
                + field.getType() + SPACE
                + field.getName() + LINE_TERMINATOR;

        ArrayList<String> result = new ArrayList<>();
        result.add(formattedField);

        return result;
    }
}
