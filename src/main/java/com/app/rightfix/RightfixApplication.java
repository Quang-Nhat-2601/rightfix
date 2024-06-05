package com.app.rightfix;

import com.app.rightfix.entity.Address;
import com.app.rightfix.entity.RepairShop;
import com.app.rightfix.entity.User;
import com.app.rightfix.Enum.Gender;
import com.app.rightfix.dao.RepairHistoryDAO;
import com.app.rightfix.dao.RepairShopDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.time.LocalDate;

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
		};
	}

	private void createUser(UserDAO userDAO) {
		// create the user
		User tempUser1 = new User(
				"Le Quang Nhat",
				Gender.MALE,
				LocalDate.parse("2002-01-26"),
				"quangnhat2601@gmail.com",
				"123");
		System.out.println("Saving User with userId: " + tempUser1.getId());
		userDAO.save(tempUser1);

		tempUser1 = new User(
				"Nguyen Van A",
				Gender.MALE,
				LocalDate.parse("2000-12-14"),
				"nguyenvana@gmail.com",
				"123");

		System.out.println("Saving User with userId: " + tempUser1.getId());
		userDAO.save(tempUser1);

		// notify done
		System.out.println("DONE");
	}

	private void createRepairShop(RepairShopDAO repairShopDAO) {
		// create the user
		RepairShop temp = new RepairShop("HEAD 26");
		Address address = new Address("street name", "4", "8", "Ho Chi Minh");
		temp.setAddress(address);
		// save User
		System.out.println("Saving Repair Shop with Id: " + temp.getId());

		// create the user
		RepairShop temp1 = new RepairShop("HEAD 30");
		Address address1 = new Address("street name", "3", "Binh Thanh", "Ho Chi Minh");
		temp1.setAddress(address1);
		// save User
		System.out.println("Saving Repair Shop with Id: " + temp.getId());

		repairShopDAO.save(temp);
		repairShopDAO.save(temp1);

		// notify done
		System.out.println("DONE");
	}
}
