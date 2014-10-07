package CodeGenerator.CodeFormatters;

import java.util.ArrayList;
import java.util.List;

import CodeGenerator.CodeFormatters.Interfaces.ClassFormatter;
import CodeGenerator.CodeFormatters.Interfaces.FieldFormatter;
import CodeGenerator.CodeFormatters.Interfaces.MethodFormatter;
import CodeGenerator.CodeGraph.Class;
import CodeGenerator.CodeGraph.Field;
import CodeGenerator.CodeGraph.Method;

import static CodeGenerator.CodeFormatters.SpecialCharacters.*;

public class ClassFormatterImpl implements ClassFormatter
{
    private FieldFormatter fieldFormatter;
    private MethodFormatter methodFormatter;

    public ClassFormatterImpl()
    {
        fieldFormatter = new FieldFormatterImpl();
        methodFormatter = new MethodFormatterImpl();
    }

    @Override
    public List<String> format(Class classCodeObject)
    {
        List<String> result = new ArrayList<>();
        result.add(classCodeObject.getVisibilityQualifier() + SPACE
                + "class" + SPACE
                + classCodeObject.getName() + SPACE + OPEN_BRACE);

        for(Field field : classCodeObject.getFields())
        {
            result.add(TAB + fieldFormatter.format(field).get(0));
        }

        for(Method method : classCodeObject.getMethods())
        {
            List<String> formattedMethod = methodFormatter.format(method);
            for(String line : formattedMethod)
            {
                result.add(TAB + line);
            }
        }

        result.add(CLOSE_BRACE);

        return result;
    }
}
