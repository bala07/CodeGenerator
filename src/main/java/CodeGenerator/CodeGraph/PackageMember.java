package CodeGenerator.CodeGraph;

import java.util.List;

public class PackageMember implements CodeMember
{
    private String name;
    private List<ImportMember> importMembers;
    private List<ClassMember> classMembers;

    public PackageMember(String name, List<ImportMember> importMembers, List<ClassMember> classMembers)
    {
        this.name = name;
        this.importMembers = importMembers;
        this.classMembers = classMembers;
    }

    public String getName()
    {
        return name;
    }

    public List<ImportMember> getImportMembers()
    {
        return importMembers;
    }

    public List<ClassMember> getClassMembers()
    {
        return classMembers;
    }
}
