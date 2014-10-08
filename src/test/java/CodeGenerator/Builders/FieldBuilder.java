package CodeGenerator.Builders;

import CodeGenerator.CodeGraph.Field;
import CodeGenerator.CodeGraph.VisibilityQualifier;

public class FieldBuilder {

    private VisibilityQualifier visibilityQualifier;
    private String type;
    private String name;

    public FieldBuilder withVisibilityQualifier(VisibilityQualifier visibilityQualifier) {
        this.visibilityQualifier = visibilityQualifier;

        return this;
    }

    public FieldBuilder withType(String type) {
        this.type = type;

        return this;
    }

    public FieldBuilder withName(String name) {
        this.name = name;

        return this;
    }

    public FieldBuilder withDefaults() {
        this.visibilityQualifier = VisibilityQualifier.PRIVATE;
        this.type = "String";
        this.name = "bar";

        return this;
    }

    public Field build() {
        return new Field(visibilityQualifier, type, name);
    }
}
