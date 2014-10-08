package CodeGenerator.CodeFormatters.Interfaces;

import CodeGenerator.CodeGraph.FieldMember;

import java.util.List;

public interface FieldFormatter extends CodeFormatter
{
    public List<String> format(FieldMember fieldMember);
}

