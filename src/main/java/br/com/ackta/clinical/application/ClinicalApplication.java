package br.com.ackta.clinical.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.ackta.clinical.model.entity.IPersistable;

@EntityScan(basePackageClasses = { ClinicalApplication.class, IPersistable.class, Jsr310JpaConverters.class })
@SpringBootApplication
@ComponentScan(basePackages = { "br.com.ackta.clinical" }, excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = { ScanOnlyForTest.class }) })
@EnableTransactionManagement
// @ScanExceptForTest
@EnableJpaRepositories("br.com.ackta.clinical.model.repository")
public class ClinicalApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ClinicalApplication.class, args);
	}

}
