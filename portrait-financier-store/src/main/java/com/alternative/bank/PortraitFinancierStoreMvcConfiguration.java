package com.alternative.bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.*;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

import static org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType.HAL;

/**
 * Created by yannic on 02/04/17.
 */
@Configuration
@EnableHypermediaSupport(type = HAL)
public class PortraitFinancierStoreMvcConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(pageableResolver());
        argumentResolvers.add(sortResolver());
        argumentResolvers.add(pagedResourcesAssemblerArgumentResolver());
        super.addArgumentResolvers(argumentResolvers);
    }

    @Bean
    public HateoasPageableHandlerMethodArgumentResolver pageableResolver() {
        HateoasPageableHandlerMethodArgumentResolver resolver = new HateoasPageableHandlerMethodArgumentResolver(sortResolver());
        return resolver;
    }

    @Bean
    public HateoasSortHandlerMethodArgumentResolver sortResolver() {
        return new HateoasSortHandlerMethodArgumentResolver();
    }

    @Bean
    public PagedResourcesAssembler<?> pagedResourcesAssembler() {
        return new PagedResourcesAssembler<Object>(pageableResolver(), null);
    }

    @Bean
    public PagedResourcesAssemblerArgumentResolver pagedResourcesAssemblerArgumentResolver() {
        return new PagedResourcesAssemblerArgumentResolver(pageableResolver(), null);
    }

}
