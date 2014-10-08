package CodeGenerator.CodeFormatters.Interfaces;

import CodeGenerator.CodeGraph.ClassMember;

import java.util.List;

public interface ClassFormatter extends CodeFormatter
{
    public List<String> format(ClassMember classMemberCodeObject);
}
