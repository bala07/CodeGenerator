package CodeGenerator.CodeFormatters.Interfaces;

import CodeGenerator.CodeGraph.PackageMember;

import java.util.List;

public interface PackageFormatter extends CodeFormatter {
    List<String> format(PackageMember packageObject);
}
