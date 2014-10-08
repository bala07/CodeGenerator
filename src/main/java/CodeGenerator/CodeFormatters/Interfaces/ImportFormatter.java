package CodeGenerator.CodeFormatters.Interfaces;

import CodeGenerator.CodeGraph.ImportMember;

import java.util.List;

public interface ImportFormatter extends CodeFormatter
{
    public List<String> format(ImportMember importMemberCodeObject);
}
