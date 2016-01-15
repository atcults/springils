package org.sanelib.ils;

import java.util.Locale;

import org.hibernate.SessionFactory;
import org.sanelib.ils.common.properties.AppProperties;
import org.sanelib.ils.common.utils.Clock;
import org.sanelib.ils.common.utils.SystemClock;
import org.sanelib.ils.core.dao.UnitOfWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@SpringBootApplication
public class ApiMain implements CommandLineRunner {

	@Autowired
	private AppProperties appProperties;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
	public void run(String... args) {
		Locale.setDefault(new Locale(this.appProperties.getLocale()));
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApiMain.class, args);
	}

    @Bean
    public Clock clock() {
        return new SystemClock();
    }

    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public UnitOfWork unitOfWork(){
        return new UnitOfWork(this.sessionFactory);

    }

}
