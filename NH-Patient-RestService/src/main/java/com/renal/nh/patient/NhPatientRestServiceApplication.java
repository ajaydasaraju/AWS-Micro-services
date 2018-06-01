
package com.renal.nh.patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Spring Boot Application definition
 * 
 * @author dasaraa
 *
 */
@SpringBootApplication
public class NhPatientRestServiceApplication extends
		SpringBootServletInitializer {

	/**
	 * Main method.
	 *
	 * @param args
	 * - startup arguments
	 */

	public static void main(String[] args) {
		SpringApplication.run(NhPatientRestServiceApplication.class, args);
	}
	
	 /**
     * @see #configure(SpringApplicationBuilder)
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(NhPatientRestServiceApplication.class);
    }
}
