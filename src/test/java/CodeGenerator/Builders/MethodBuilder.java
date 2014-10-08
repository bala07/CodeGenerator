package CodeGenerator.Builders;

import CodeGenerator.CodeGraph.MethodMember;
import CodeGenerator.CodeGraph.VisibilityQualifier;

import java.util.ArrayList;
import java.util.List;

public class MethodBuilder {
    private VisibilityQualifier visibilityQualifier;
    private String returnType;
    private String name;
    private List<String> statements;

    public MethodBuilder withVisibilityQualifier(VisibilityQualifier visibilityQualifier) {
        this.visibilityQualifier = visibilityQualifier;

        return this;
    }

    public MethodBuilder withReturnType(String returnType) {
        this.returnType = returnType;

        return this;
    }

    public MethodBuilder withName(String name) {
        this.name = name;

        return this;
    }

    public MethodBuilder withStatements(List<String> statements) {
        this.statements = statements;

        return this;
    }

    public MethodBuilder withDefaults() {
        visibilityQualifier = VisibilityQualifier.PRIVATE;
        returnType = "void";
        name = "foo";
        statements = new ArrayList<>();
        statements.add("System.out.println(\"Hello World\")");

        return this;
    }

    public MethodMember build() {
        return new MethodMember(visibilityQualifier, returnType, name, statements);
    }
}

