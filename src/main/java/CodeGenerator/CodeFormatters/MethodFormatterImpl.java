package CodeGenerator.CodeFormatters;

import CodeGenerator.CodeFormatters.Interfaces.MethodFormatter;
import CodeGenerator.CodeGraph.MethodMember;

import java.util.ArrayList;
import java.util.List;

import static CodeGenerator.CodeFormatters.SpecialCharacters.*;

public class MethodFormatterImpl implements MethodFormatter
{
    @Override
    public List<String> format(MethodMember methodMember)
    {
        List<String> result = new ArrayList<>();

        result.add(methodMember.getVisibilityQualifier() + SPACE + methodMember.getReturnType() + SPACE + methodMember.getName() + OPEN_PARANTHESES + CLOSE_PARANTHESES + SPACE + OPEN_BRACE);
        for(String statement : methodMember.getStatements())
        {
            result.add(new String(TAB + statement + LINE_TERMINATOR));
        }
        result.add(new String(CLOSE_BRACE));

        return result;
    }
}
