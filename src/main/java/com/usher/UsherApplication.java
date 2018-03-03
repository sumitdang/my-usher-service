package com.usher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsherApplication {
	private static final Logger logger = LoggerFactory.getLogger(UsherApplication.class);

	public static void main(String[] arguments) {

		// we can't take arguments anyways, so we just obliterate the args array
		// with our own stuff
		String[] args = new String[1];

		// if the env variable doesn't exist then deploy_env will be null
		// if running on comp, minc, prodlike, or prod, then the env var should
		// be there
		String deployEnv = System.getenv("DEPLOY_ENV");
		logger.info("DEPLOY_ENV: " + deployEnv);

		if (deployEnv == null) {
			args[0] = "--spring.profiles.active=local";
			logger.info("Will now deployment on: local");
		} else {
			if (!("comp".equals(deployEnv) || "minc".equals(deployEnv) || "prodlike".equals(deployEnv)
					|| "prod".equals(deployEnv))) {
				logger.error(deployEnv + " is not a recognized deploy environment, aborting.");
				return;
			}
			args[0] = "--spring.profiles.active=" + deployEnv;
			logger.info("Will now deployment on: " + deployEnv);
		}

		SpringApplication.run(UsherApplication.class, args);
		logger.info("Finish Main");
	}
}
