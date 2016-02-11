package com.tictactoe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.mongodb.Mongo;
//import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages="com.tictactoe.db")
public class TicTacToeConfig {
	
	/* The bean below will be used to generate a Mongo instance (used later on by the MongoTemplate)
	 * This bean will "bridge" the Spring Data MongoDB to the database itself */
	@Bean
	public MongoClientFactoryBean mongo() {
		MongoClientFactoryBean mongo = new MongoClientFactoryBean();
		mongo.setHost("localhost");
		return mongo;
	}
	
	/* The bean below will create an object that will allow us to do certain operations over the DB */
	@Bean
	public MongoOperations mongoTemplate(Mongo mongo) {
		return new MongoTemplate(mongo, "TTTPlayersDB");
	}
}


/* The class below is an alternative to the configuration above
 * Marginally simpler, you'll extend from an abstract class and
 * only override some methods (specifying the DB name and creating
 * a client directly */

//@Configuration
//@EnableMongoRepositories("com.tictactoe.db")
//class TicTacToeAltConfig extends AbstractMongoConfiguration {
//	
//	@Override
//	public String getDatabaseName() {
//		return "TTTPlayersDB";
//	}
//	
//	@Override
//	public Mongo mongo() throws Exception {
//		return new MongoClient();
//	}	
//}