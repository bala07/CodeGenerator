package CodeGenerator.CodeGraph;

public class Import implements CodeMember
{
    private String name;

    public Import(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
