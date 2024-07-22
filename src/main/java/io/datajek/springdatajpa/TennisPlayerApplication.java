package io.datajek.springdatajpa;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TennisPlayerApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// @Autowired
	// PlayerRepository repo;
	@Autowired
	PlayerSpringDataRepository repot;
	public static void main(String[] args) {
		SpringApplication.run(TennisPlayerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// logger.info("Inserting Player: {}", repo.insertPlayer(new Player(
		// 	"Djokovic", "Serbia", Date.valueOf("1987-05-22"), 81)));
		// logger.info("Inserting Player: {}", repo.insertPlayer(new Player(
		// 			"Monfils", "France", Date.valueOf("1986-09-01"), 10)));
		// logger.info("Inserting Player: {}", repo.insertPlayer(new Player(
		// 			"Thiem", "Austria", Date.valueOf("1993-09-03"), 17)));	
		// logger.info("All Players Data: {}", repo.getAllPlayers());

		logger.info("Inserting Player: {}", repot.save(new Player(
			"Djokovic", "Serbia", Date.valueOf("1987-05-22"), 81)));
		logger.info("Inserting Player: {}", repot.save(new Player(
					"Monfils", "France", Date.valueOf("1986-09-01"), 10)));
		logger.info("Inserting Player: {}", repot.save(new Player(
					"Thiem", "Austria", Date.valueOf("1993-09-03"), 17)));	

		logger.info("Updateing Player with id 3: {}", repot.save(new Player(3,
				"Thiem", "Austria", Date.valueOf("1993-09-03"), 17)));	
		logger.info("\n\n>>Player with Id 2: {}\n", repot.findById(2));
				repot.deleteById(2);
		logger.info("\n\n>>All Players Data: {}\n", repot.findAll());
	} 

}
