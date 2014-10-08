package CodeGenerator.CodeFormatters;

import CodeGenerator.CodeFormatters.Interfaces.ClassFormatter;
import CodeGenerator.CodeFormatters.Interfaces.ImportFormatter;
import CodeGenerator.CodeFormatters.Interfaces.PackageFormatter;
import CodeGenerator.CodeGraph.ClassMember;
import CodeGenerator.CodeGraph.ImportMember;
import CodeGenerator.CodeGraph.PackageMember;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import static CodeGenerator.CodeFormatters.SpecialCharacters.*;

public class PackageFormatterImpl implements PackageFormatter {

    private final ImportFormatter importFormatter;
    private final ClassFormatter classFormatter;

    @Inject
    public PackageFormatterImpl(ImportFormatter importFormatter, ClassFormatter classFormatter) {
        this.importFormatter = importFormatter;
        this.classFormatter = classFormatter;
    }
    @Override
    public List<String> format(PackageMember packageObject) {
        List<String> formattedPackage = new ArrayList<>();

        formattedPackage.add("package " + packageObject.getName() + LINE_TERMINATOR);

        for(ImportMember importMember : packageObject.getImportMembers()) {
            formattedPackage.addAll(importFormatter.format(importMember));
        }

        for(ClassMember classMember : packageObject.getClassMembers()) {
            formattedPackage.addAll(classFormatter.format(classMember));
        }

        return formattedPackage;
    }
}
