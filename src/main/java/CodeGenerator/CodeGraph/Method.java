package CodeGenerator.CodeGraph;

import java.util.List;

public class Method implements CodeMember
{
    private VisibilityQualifier visibilityQualifier;
    private String returnType;
    private String name;
    private List<String> statements;

    public Method(VisibilityQualifier visibilityQualifier, String returnType, String name, List<String> statements)
    {
        this.visibilityQualifier = visibilityQualifier;
        this.returnType = returnType;
        this.name = name;
        this.statements = statements;
    }

    public String getVisibilityQualifier()
    {
        return VisibilityQualifier.get(this.visibilityQualifier);
    }

    public String getReturnType()
    {
        return returnType;
    }

    public String getName()
    {
        return name;
    }

    public List<String> getStatements()
    {
        return statements;
    }

    public void addStatement(String statement)
    {
        statements.add(statement);
    }
}

