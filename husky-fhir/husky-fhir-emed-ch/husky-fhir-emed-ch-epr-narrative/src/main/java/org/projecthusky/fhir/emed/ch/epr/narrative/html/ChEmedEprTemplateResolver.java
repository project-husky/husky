package org.projecthusky.fhir.emed.ch.epr.narrative.html;

import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

public class ChEmedEprTemplateResolver {
    public static ITemplateResolver get() {
        final var templateResolver = new ClassLoaderTemplateResolver(ChEmedEprTemplateResolver.class.getClassLoader());
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setCacheable(true);
        templateResolver.setCacheTTLMs(300000L);
        templateResolver.setPrefix("/narrative/templates/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }
}
