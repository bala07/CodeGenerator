package CodeGenerator.CodeGraph;

public enum VisibilityQualifier
{
    PRIVATE, PROTECTED, PUBLIC;

    public static String get(VisibilityQualifier visibilityQualifier)
    {
        switch(visibilityQualifier)
        {
            case PRIVATE:
                return "private";
            case PROTECTED:
                return "protected";
            case PUBLIC:
                return "public";
            default:
                return null;
        }
    }
}
