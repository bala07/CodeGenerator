package CodeGenerator.CodeFormatters.Interfaces;

import CodeGenerator.CodeGraph.Class;

import java.util.List;

public interface ClassFormatter extends CodeFormatter
{
    public List<String> format(Class classCodeObject);
}
