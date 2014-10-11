import CodeGenerator.Builders.PackageBuilder;
import CodeGenerator.CodeGenerator;

import java.io.IOException;

public class TestMain {
    public static void main(String[] args) throws IOException {
        CodeGenerator codeGenerator = new CodeGenerator();
        codeGenerator.generateToConsole(new PackageBuilder().withDefaults().build());
    }
}
