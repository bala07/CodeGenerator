package CodeGenerator;

import CodeGenerator.CodeFormatters.*;
import CodeGenerator.CodeFormatters.Interfaces.*;
import com.google.inject.AbstractModule;

public class AppInjector extends AbstractModule {

    @Override
    protected void configure() {
        bind(PackageFormatter.class).to(PackageFormatterImpl.class);
        bind(ClassFormatter.class).to(ClassFormatterImpl.class);
        bind(MethodFormatter.class).to(MethodFormatterImpl.class);
        bind(FieldFormatter.class).to(FieldFormatterImpl.class);
        bind(ImportFormatter.class).to(ImportFormatterImpl.class);
    }
}
