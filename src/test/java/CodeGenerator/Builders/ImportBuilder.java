package CodeGenerator.Builders;

import CodeGenerator.CodeGraph.ImportMember;

public class ImportBuilder {
    private String name;

    public ImportBuilder withName(String name) {
        this.name = name;

        return this;
    }

    public ImportBuilder withDefaults() {
        this.name = "Import";

        return this;
    }

    public ImportMember build() {
        return new ImportMember(name);
    }
}

