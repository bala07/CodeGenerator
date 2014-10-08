package CodeGenerator.CodeFormatters;

import CodeGenerator.Builders.ClassBuilder;
import CodeGenerator.Builders.ImportBuilder;
import CodeGenerator.CodeFormatters.Interfaces.ClassFormatter;
import CodeGenerator.CodeFormatters.Interfaces.ImportFormatter;
import CodeGenerator.CodeFormatters.Interfaces.PackageFormatter;
import CodeGenerator.CodeGraph.*;
import CodeGenerator.CodeGraph.ClassMember;
import CodeGenerator.CodeGraph.PackageMember;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PackageMemberFormatterImplTest {
    @Test
    public void shouldFormatPackage() {
        ImportFormatter importFormatterMock = mock(ImportFormatter.class);
        ClassFormatter classFormatterMock = mock(ClassFormatter.class);
        PackageFormatter packageFormatter = new PackageFormatterImpl(importFormatterMock, classFormatterMock);

        String name = "packageName";
        List<ImportMember> importMembers = new ArrayList<>();
        importMembers.add(new ImportBuilder().withDefaults().build());
        importMembers.add(new ImportBuilder().withDefaults().build());

        List<ClassMember> classMembers = new ArrayList<>();
        classMembers.add(new ClassBuilder().withDefaults().build());

        PackageMember packageMemberObject = new PackageMember(name, importMembers, classMembers);
        List<String> formattedPackage = packageFormatter.format(packageMemberObject);

        assertThat(formattedPackage.get(0), is("package packageName;"));
        verify(importFormatterMock, times(importMembers.size())).format(any(ImportMember.class));
        verify(classFormatterMock, times(classMembers.size())).format(any(ClassMember.class));
    }
}