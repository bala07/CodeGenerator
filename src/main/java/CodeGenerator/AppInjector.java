package CodeGenerator;

import CodeGenerator.CodeFormatters.ClassFormatterImpl;
import CodeGenerator.CodeFormatters.FieldFormatterImpl;
import CodeGenerator.CodeFormatters.ImportFormatterImpl;
import CodeGenerator.CodeFormatters.Interfaces.ClassFormatter;
import CodeGenerator.CodeFormatters.Interfaces.FieldFormatter;
import CodeGenerator.CodeFormatters.Interfaces.ImportFormatter;
import CodeGenerator.CodeFormatters.Interfaces.MethodFormatter;
import CodeGenerator.CodeFormatters.MethodFormatterImpl;
import com.google.inject.AbstractModule;

public class AppInjector extends AbstractModule {

    @Override
    protected void configure() {
        bind(ClassFormatter.class).to(ClassFormatterImpl.class);
        bind(FieldFormatter.class).to(FieldFormatterImpl.class);
        bind(ImportFormatter.class).to(ImportFormatterImpl.class);
        bind(MethodFormatter.class).to(MethodFormatterImpl.class);
    }
}
