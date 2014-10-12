package CodeGenerator;

import CodeGenerator.CodeFormatters.Interfaces.PackageFormatter;
import CodeGenerator.CodeGraph.PackageMember;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class CodeGeneratorTest {
    private CodeGenerator codeGenerator;
    @Mock
    private PackageFormatter packageFormatterMock;
    @Mock
    private PackageMember packageMemberMock;

    @Before
    public void setup() {
        initMocks(this);
        codeGenerator = new CodeGenerator();
        codeGenerator.packageFormatter = packageFormatterMock;
    }



    @Test
    public void shouldFormatTheCodeFromPackageObject() throws IOException {
        String fileName = "foobar";

        codeGenerator.generateToFile(packageMemberMock, fileName);

        verify(packageFormatterMock, times(1)).format(packageMemberMock);
    }

    @Test
    public void shouldWriteTheCodeToFile() throws IOException {
        List<String> formattedCode = new ArrayList<>();
        formattedCode.add("foobar");
        String fileName = "foobar.java";

        when(packageFormatterMock.format(packageMemberMock)).thenReturn(formattedCode);

        codeGenerator.generateToFile(packageMemberMock, fileName);

        List<String> fileContents = Files.readAllLines(Paths.get(fileName));
        assertThat(fileContents.size(), is(1));
        assertThat(fileContents.get(0), is("foobar"));

        Files.delete(Paths.get(fileName));
    }
}