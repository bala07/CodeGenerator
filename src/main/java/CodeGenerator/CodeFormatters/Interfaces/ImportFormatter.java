package CodeGenerator.CodeFormatters.Interfaces;

import CodeGenerator.CodeFormatters.Interfaces.CodeFormatter;
import CodeGenerator.CodeGraph.Import;

import java.util.List;

public interface ImportFormatter extends CodeFormatter
{
    public List<String> format(Import importCodeObject);
}
