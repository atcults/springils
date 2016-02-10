package org.sanelib.ils;

import org.sanelib.ils.common.utils.Clock;
import org.sanelib.ils.common.utils.CustomClock;
import org.sanelib.ils.core.dao.UnitOfWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class CoreTestMain  {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Bean
    public Clock clock() {
        return new CustomClock();
    }

    @Bean
    public UnitOfWork unitOfWork(){
        return new UnitOfWork(this.entityManagerFactory);
    }

}
