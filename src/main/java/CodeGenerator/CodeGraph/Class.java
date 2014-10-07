package CodeGenerator.CodeGraph;

import java.util.List;

public class Class implements CodeMember
{
    private VisibilityQualifier visibilityQualifier;
    private String name;
    private List<Field> fields;
    private List<Method> methods;

    public Class(VisibilityQualifier visibilityQualifier, String name, List<Field> fields, List<Method> methods)
    {
        this.visibilityQualifier = visibilityQualifier;
        this.name = name;
        this.fields = fields;
        this.methods = methods;
    }

    public List<Field> getFields()
    {
        return fields;
    }

    public List<Method> getMethods()
    {
        return methods;
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

