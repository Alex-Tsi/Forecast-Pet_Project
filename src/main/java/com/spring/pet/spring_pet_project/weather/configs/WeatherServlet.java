package com.spring.pet.spring_pet_project.weather.configs;


import com.spring.pet.spring_pet_project.root_conf.RootConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WeatherServlet extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {RootConfigurer.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {LocalServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/api/weather", "/"};
    }
}
