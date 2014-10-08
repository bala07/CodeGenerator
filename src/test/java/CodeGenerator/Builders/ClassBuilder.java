package CodeGenerator.Builders;

import CodeGenerator.CodeGraph.ClassMember;
import CodeGenerator.CodeGraph.FieldMember;
import CodeGenerator.CodeGraph.MethodMember;
import CodeGenerator.CodeGraph.VisibilityQualifier;

import java.util.ArrayList;
import java.util.List;

public class ClassBuilder {
    private VisibilityQualifier visibilityQualifier;
    private String name;
    private List<FieldMember> fieldMembers;
    private List<MethodMember> methodMembers;

    public ClassBuilder withVisibilityQualifier(VisibilityQualifier visibilityQualifier) {
        this.visibilityQualifier = visibilityQualifier;

        return this;
    }

    public ClassBuilder withName(String name) {
        this.name = name;

        return this;
    }

    public ClassBuilder withFields(List<FieldMember> fieldMembers) {
        this.fieldMembers = fieldMembers;

        return this;
    }

    public ClassBuilder withMethods(List<MethodMember> methodMembers) {
        this.methodMembers = methodMembers;

        return this;
    }

    public ClassBuilder withDefaults() {
        visibilityQualifier = VisibilityQualifier.PRIVATE;
        name = "ClassName";

        fieldMembers = new ArrayList<>();
        fieldMembers.add(new FieldBuilder().withDefaults().build());
        fieldMembers.add(new FieldBuilder().withDefaults().build());

        methodMembers = new ArrayList<>();
        methodMembers.add(new MethodBuilder().withDefaults().build());
        methodMembers.add(new MethodBuilder().withDefaults().build());

        return this;
    }

    public ClassMember build() {
        return new ClassMember(visibilityQualifier, name, fieldMembers, methodMembers);
    }
}
