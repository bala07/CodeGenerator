package CodeGenerator.Builders;

import CodeGenerator.CodeGraph.ClassMember;
import CodeGenerator.CodeGraph.ImportMember;
import CodeGenerator.CodeGraph.PackageMember;

import java.util.ArrayList;
import java.util.List;

public class PackageBuilder {
    private String name;
    private List<ImportMember> importMembers;
    private List<ClassMember> classMembers;

    public PackageBuilder withName(String name) {
        this.name = name;

        return this;
    }

    public PackageBuilder withImports(List<ImportMember> imports) {
        this.importMembers = imports;

        return this;
    }

    public PackageBuilder withClasses(List<ClassMember> classes) {
        this.classMembers = classes;

        return this;
    }

    public PackageBuilder withDefaults() {
        this.name = "foobar";

        importMembers = new ArrayList<>();
        importMembers.add(new ImportMember("import1"));
        importMembers.add(new ImportMember("import2"));

        classMembers = new ArrayList<>();
        classMembers.add(new ClassBuilder().withDefaults().build());

        return this;
    }

    public PackageMember build() {
        return new PackageMember(name, importMembers, classMembers);
    }


}
