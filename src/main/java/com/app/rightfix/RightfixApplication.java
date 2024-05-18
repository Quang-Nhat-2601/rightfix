package com.app.rightfix;

import com.app.rightfix.Entities.Address;
import com.app.rightfix.Entities.RepairHistory;
import com.app.rightfix.Entities.RepairShop;
import com.app.rightfix.Entities.User;
import com.app.rightfix.Enum.Gender;
import com.app.rightfix.dao.RepairHistoryDAO;
import com.app.rightfix.dao.RepairShopDAO;
import com.app.rightfix.dao.UserDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;

@SpringBootApplication
public class RightfixApplication {

	public static void main(String[] args) {
		SpringApplication.run(RightfixApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserDAO userDAO, RepairShopDAO repairShopDAO, RepairHistoryDAO repairHistoryDAO) {
		return runner -> {
			createUser(userDAO);
			createRepairShop(repairShopDAO);
			createRepairHistory(repairHistoryDAO);
		};
	}

	private void createUser(UserDAO userDAO) {
		// create the user
		User tempUser = new User(
				"Le Quang Nhat",
				Gender.male,
				Instant.parse("2002-01-26T00:00:00.00Z"),
				"quangnhat2601@gmail.com",
				"123");

		// save User
		System.out.println("Saving User with userId: " + tempUser.getId());
		userDAO.save(tempUser);

		// notify done
		System.out.println("DONE");
	}

	private void createRepairShop(RepairShopDAO repairShopDAO) {
		// create the user
		RepairShop temp = new RepairShop("HEAD 26");

		Address address = new Address("street name", "4", "8", "Ho Chi Minh");

		temp.setAddress(address);

		// save User
		System.out.println("Saving User with userId: " + temp.getId());
		repairShopDAO.save(temp);

		// notify done
		System.out.println("DONE");
	}

	private void createRepairHistory(RepairHistoryDAO repairHistoryDAO) {

		
	}
}
