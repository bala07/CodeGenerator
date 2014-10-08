package CodeGenerator.CodeGraph;

import java.util.List;

public class ClassMember implements CodeMember
{
    private VisibilityQualifier visibilityQualifier;
    private String name;
    private List<FieldMember> fieldMembers;
    private List<MethodMember> methodMembers;

    public ClassMember(VisibilityQualifier visibilityQualifier, String name, List<FieldMember> fieldMembers, List<MethodMember> methodMembers)
    {
        this.visibilityQualifier = visibilityQualifier;
        this.name = name;
        this.fieldMembers = fieldMembers;
        this.methodMembers = methodMembers;
    }

    public List<FieldMember> getFieldMembers()
    {
        return fieldMembers;
    }

    public List<MethodMember> getMethodMembers()
    {
        return methodMembers;
    }

    public String getVisibilityQualifier()
    {
        return VisibilityQualifier.get(this.visibilityQualifier);
    }

    public String getName()
    {
        return name;
    }
}

