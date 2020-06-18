package cab.andrew.nycschools.di.scopes;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import javax.inject.Scope;

@Scope
@Documented
@Retention(RUNTIME)
public @interface AppScope {
}
