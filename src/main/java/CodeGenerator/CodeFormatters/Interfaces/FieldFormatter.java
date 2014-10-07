package CodeGenerator.CodeFormatters.Interfaces;

import CodeGenerator.CodeFormatters.Interfaces.CodeFormatter;
import CodeGenerator.CodeGraph.Field;

import java.util.List;

public interface FieldFormatter extends CodeFormatter
{
    public List<String> format(Field field);
}

