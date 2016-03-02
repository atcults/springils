package org.sanelib.ils;

import org.sanelib.ils.common.properties.AppProperties;
import org.sanelib.ils.common.session.UserSession;
import org.sanelib.ils.common.session.impl.UserSessionImpl;
import org.sanelib.ils.common.utils.Clock;
import org.sanelib.ils.common.utils.SystemClock;
import org.sanelib.ils.core.dao.UnitOfWork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import javax.persistence.EntityManagerFactory;
import java.util.Locale;

@SpringBootApplication
@EnableAspectJAutoProxy
public class ApiMain implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ApiMain.class);

	@Autowired
	private AppProperties appProperties;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

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
    public UserSession userSession(){
        UserSession userSession = new UserSessionImpl();
		//TODO : Remove it once they are set in OAuthorizationFilter and it is register with JerseyConfig
		userSession.setLibraryId(1);
		userSession.setUserCode("1");
        return userSession;
    }

    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public UnitOfWork unitOfWork(){
        return new UnitOfWork(this.entityManagerFactory);
    }
}
