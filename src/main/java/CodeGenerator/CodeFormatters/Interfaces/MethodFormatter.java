package CodeGenerator.CodeFormatters.Interfaces;

import CodeGenerator.CodeFormatters.Interfaces.CodeFormatter;
import CodeGenerator.CodeGraph.Method;

import java.util.List;

public interface MethodFormatter extends CodeFormatter
{
    public List<String> format(Method method);
}
