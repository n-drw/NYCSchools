package cab.andrew.nycschools.di.scopes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

import javax.inject.Scope;

@Scope
@Retention(RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface FragmentScope {
}
