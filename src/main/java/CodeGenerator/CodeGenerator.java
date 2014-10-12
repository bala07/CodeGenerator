package CodeGenerator;


import CodeGenerator.CodeFormatters.Interfaces.PackageFormatter;
import CodeGenerator.CodeGraph.PackageMember;
import com.google.common.annotations.VisibleForTesting;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CodeGenerator {

    PackageFormatter packageFormatter;

    public CodeGenerator() {
        Injector injector = Guice.createInjector(new AppInjector());
        packageFormatter = injector.getInstance(PackageFormatter.class);
    }

    public void generateToFile(PackageMember packageMember, String fileName) throws IOException {
        List<String> formattedCode = packageFormatter.format(packageMember);
        writeFormattedCodeToFile(formattedCode, fileName);
    }

    public void generateToConsole(PackageMember packageMember) throws IOException {
        List<String> formattedCode = packageFormatter.format(packageMember);
        for(String line : formattedCode) {
            System.out.println(line);
        }
    }

    private void writeFormattedCodeToFile(List<String> formattedCode, String fileName) throws IOException {
        PrintWriter fileWriter = new PrintWriter(new FileWriter(fileName));

        for(String line : formattedCode) {
            fileWriter.println(line);
        }

        fileWriter.close();
    }
}
