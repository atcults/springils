package org.sanelib.ils;

import java.util.Locale;

import org.sanelib.ils.common.properties.AppProperties;
import org.sanelib.ils.common.utils.Clock;
import org.sanelib.ils.common.utils.CustomClock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CommonMain implements CommandLineRunner {

	@Autowired
	private AppProperties appProperties;

	@Override
	public void run(String... args) {
		Locale.setDefault(new Locale(this.appProperties.getLocale()));
    }

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CommonMain.class, args);
	}

    @Bean
    public Clock clock() {
        return new CustomClock();
    }

    //NOTE: Add tests for MapDictionaryService

}
