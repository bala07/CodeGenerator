package CodeGenerator;


import CodeGenerator.CodeFormatters.Interfaces.PackageFormatter;
import CodeGenerator.CodeGraph.PackageMember;
import com.google.common.annotations.VisibleForTesting;
import com.google.inject.Inject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CodeGenerator {

    @Inject
    private PackageFormatter packageFormatter;

    public void generate(PackageMember packageMember, String fileName) throws IOException {
        List<String> formattedCode = packageFormatter.format(packageMember);
        writeFormattedCodeToFile(formattedCode, fileName);
    }

    private void writeFormattedCodeToFile(List<String> formattedCode, String fileName) throws IOException {
        PrintWriter fileWriter = new PrintWriter(new FileWriter(fileName));

        formattedCode.forEach(fileWriter::println);

        fileWriter.close();
    }

    @VisibleForTesting
    public CodeGenerator(PackageFormatter packageFormatter) {
        this.packageFormatter = packageFormatter;
    }
}
