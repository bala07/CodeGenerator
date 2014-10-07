package CodeGenerator.CodeGraph;

import java.util.List;

public class Package implements CodeMember
{
    private String name;
    private List<Import> imports;
    private List<Class> classes;

    public Package(String name, List<Import> imports, List<Class> classes)
    {
        this.name = name;
        this.imports = imports;
        this.classes = classes;
    }

    public String getName()
    {
        return name;
    }

    public List<Import> getImports()
    {
        return imports;
    }

    public List<Class> getClasses()
    {
        return classes;
    }
}
