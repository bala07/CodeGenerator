package CodeGenerator.CodeFormatters;

import CodeGenerator.CodeFormatters.Interfaces.MethodFormatter;
import CodeGenerator.CodeGraph.Method;

import java.util.ArrayList;
import java.util.List;

import static CodeGenerator.CodeFormatters.SpecialCharacters.*;

public class MethodFormatterImpl implements MethodFormatter
{
    @Override
    public List<String> format(Method method)
    {
        List<String> result = new ArrayList<>();

        result.add(method.getVisibilityQualifier() + SPACE + method.getReturnType() + SPACE + method.getName() + OPEN_PARANTHESES + CLOSE_PARANTHESES + SPACE + OPEN_BRACE);
        for(String statement : method.getStatements())
        {
            result.add(new String(TAB + statement));
        }
        result.add(new String(CLOSE_BRACE));

        return result;
    }
}
