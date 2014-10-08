package CodeGenerator.CodeGraph;

public class ImportMember implements CodeMember
{
    private String name;

    public ImportMember(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
