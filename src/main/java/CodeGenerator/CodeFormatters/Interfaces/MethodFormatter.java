package CodeGenerator.CodeFormatters.Interfaces;

import CodeGenerator.CodeGraph.MethodMember;

import java.util.List;

public interface MethodFormatter extends CodeFormatter
{
    public List<String> format(MethodMember methodMember);
}
