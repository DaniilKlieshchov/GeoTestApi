package api.module;

import api.HierarchyUtils;
import api.clients.RestClient;
import api.steps.EmployeeSteps;
import api.steps.GeoSteps;
import api.steps.HierarchySteps;
import com.google.inject.AbstractModule;

public class ApiModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(EmployeeSteps.class)
                .toInstance(new EmployeeSteps(createRestClient()));

        bind(GeoSteps.class)
                .toInstance(new GeoSteps(createRestClient()));

        bind(HierarchySteps.class)
                .toInstance(new HierarchySteps(createRestClient()));
    }

    private RestClient createRestClient() {
        return new RestClient();
    }
}
