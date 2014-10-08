package CodeGenerator.CodeFormatters;

import java.util.ArrayList;
import java.util.List;

import CodeGenerator.CodeFormatters.Interfaces.ClassFormatter;
import CodeGenerator.CodeFormatters.Interfaces.FieldFormatter;
import CodeGenerator.CodeFormatters.Interfaces.MethodFormatter;
import CodeGenerator.CodeGraph.ClassMember;
import CodeGenerator.CodeGraph.FieldMember;
import CodeGenerator.CodeGraph.MethodMember;
import com.google.inject.Inject;

import static CodeGenerator.CodeFormatters.SpecialCharacters.*;

public class ClassFormatterImpl implements ClassFormatter
{
    private FieldFormatter fieldFormatter;
    private MethodFormatter methodFormatter;

    @Inject
    public ClassFormatterImpl(FieldFormatter fieldFormatter, MethodFormatter methodFormatter)
    {
        this.fieldFormatter = fieldFormatter;
        this.methodFormatter = methodFormatter;
    }

    @Override
    public List<String> format(ClassMember classMemberCodeObject)
    {
        List<String> result = new ArrayList<>();
        result.add(classMemberCodeObject.getVisibilityQualifier() + SPACE
                + "class" + SPACE
                + classMemberCodeObject.getName() + SPACE + OPEN_BRACE);

        for(FieldMember fieldMember : classMemberCodeObject.getFieldMembers())
        {
            result.add(TAB + fieldFormatter.format(fieldMember).get(0));
        }

        for(MethodMember methodMember : classMemberCodeObject.getMethodMembers())
        {
            List<String> formattedMethod = methodFormatter.format(methodMember);
            for(String line : formattedMethod)
            {
                result.add(TAB + line);
            }
        }

        result.add(CLOSE_BRACE);

        return result;
    }
}
