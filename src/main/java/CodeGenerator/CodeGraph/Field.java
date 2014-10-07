package CodeGenerator.CodeGraph;

public class Field implements CodeMember
{
    private VisibilityQualifier visibilityQualifier;
    private String type;
    private String name;

    public Field(VisibilityQualifier visibilityQualifier, String type, String name)
    {
        this.visibilityQualifier = visibilityQualifier;
        this.type = type;
        this.name = name;
    }

    public String getVisibilityQualifier()
    {
        return VisibilityQualifier.get(this.visibilityQualifier);
    }

    public String getType()
    {
        return type;
    }

    public String getName()
    {
        return name;
    }
}
